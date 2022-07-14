package com.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.NetMedsPages;

public class TC_NetMeds_003 extends NetMed_TestBase {
	@Test()
	public  void FilterActivities() throws InterruptedException, IOException {
		boolean Title = driver.getTitle().contains("Netmeds.com: Indian Online Pharmacy | Buy Medicines Online, Fast Delivery");
		if(Title) {
			Reporter.log("The user is Landed on the NetMed Home Page");
			Assert.assertTrue(Title);
			NetMedOR.getClickOnFitness().click();
			boolean  CurrentUrlFitness= driver.getCurrentUrl().contains("fitness");
			if(CurrentUrlFitness) {
				Reporter.log("The user is navigated to the Fitness Page");
				Assert.assertTrue(CurrentUrlFitness);
				List<WebElement> FitnessCategoryList = NetMedOR.getFitnessCategoryList();
				for(WebElement item: FitnessCategoryList) {
					System.out.println(item.getText());
				}
				NetMedOR.getFitnessSubCategory().click();
				boolean CurrentUrlVitamins = driver.getCurrentUrl().contains("vitamins");
				if(CurrentUrlVitamins) {
					Reporter.log("The user is navigated to the Vitamins and Suplements Page");
					Assert.assertTrue(CurrentUrlVitamins);
				}else {
					captureScreenshot(driver,"FilterActivities");
					Reporter.log("The user is not navigated to the Vitamins and Suplements Page");
					Assert.assertTrue(CurrentUrlVitamins);
				}
			}else {
				captureScreenshot(driver,"FilterActivities");
				Reporter.log("The user is not navigated to the Fitness Page");
				Assert.assertTrue(CurrentUrlFitness);
			}
		}else {
			captureScreenshot(driver,"FilterActivities");
			Reporter.log("The user is not  Landed on the NetMed Home Page");
			Assert.assertTrue(Title);
		}
		Thread.sleep(3000);
	} 
	@Test(dependsOnMethods = {"FilterActivities"})
	public void AvailabilityCheckBoxSelected() throws InterruptedException, IOException{
		System.out.println("TotalNumber of products in the page before applying filters " + NetMedOR.getTotalCount().getText());
		JavascriptExecutor Js = (JavascriptExecutor)driver;
		Js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		NetMedOR.getAvailabilityCheckBox().click();
		Thread.sleep(3000);
		System.out.println("TotalNumber of products in the page after applying filters " + NetMedOR.getTotalCount().getText());
		boolean isAvailabilityCheckBoxSelected = NetMedOR.getCheckBox().isSelected();
		if(isAvailabilityCheckBoxSelected) {
			Reporter.log("Exclude out of stock check box selected");
			Assert.assertTrue(isAvailabilityCheckBoxSelected);
		}else {
			captureScreenshot(driver,"AvailabilityCheckBoxSelected");
			Reporter.log("Exclude out of stock check box is not selected");
			Assert.assertTrue(isAvailabilityCheckBoxSelected);
		}
		
	}


	@Test(dataProvider = "getData", dependsOnMethods = {"AvailabilityCheckBoxSelected"})
	public void categorySelection(String category) throws InterruptedException, IOException {
		List<WebElement> getItemNameBeforeFilter = NetMedOR.getUnorderedListOfCategory();
		for(WebElement item: getItemNameBeforeFilter) {
			System.out.println(item.getText());
		}
		SoftAssert SAssert = new SoftAssert();
		NetMedOR.getCategorySearchField().sendKeys(category);
		String textInsideSearchField = NetMedOR.getCategorySearchField().getAttribute("value");
		boolean isCategoryNameTyped = textInsideSearchField.isEmpty();
		if(isCategoryNameTyped ){
			captureScreenshot(driver,"categorySelection");
			Reporter.log("Category Name is not typed");
			SAssert.assertFalse(isCategoryNameTyped);
		}else {
			Reporter.log("Category name is  typed");
			SAssert.assertFalse(isCategoryNameTyped);
		}
		Thread.sleep(5000);
		List<WebElement> getItemNameAfterFilter = NetMedOR.getUnorderedListOfCategory();
		for(WebElement item: getItemNameAfterFilter) {
			item.click();
			String itemName = item.getText();
			if(itemName.contains("Multi-Vitamins")) {
				boolean iscategorySelected= NetMedOR.getMultiVitaminsCheckBox().isSelected();
				if(iscategorySelected) {
					Reporter.log("Searched category name Multi-Vitamins check box is selected");
					SAssert.assertTrue(iscategorySelected);
					System.out.println(item.getText());
				}else {
					captureScreenshot(driver,"categorySelection");
					Reporter.log("Searched category name Multi-Vitamins check box is not selected");
					SAssert.assertTrue(iscategorySelected);
				}
			}else if(itemName.contains("Calcium")){
				boolean iscategorySelected = NetMedOR.getCalciumAndMineralsCheckBox().isSelected();
				if(iscategorySelected) {
					Reporter.log("Searched category Calcium check box is selected");
					SAssert.assertTrue(iscategorySelected);
					System.out.println(item.getText());
				}else {
					captureScreenshot(driver,"categorySelection");
					Reporter.log("Searched category Calcium check box is not selected");
					SAssert.assertTrue(iscategorySelected);
				}
			}
		}
		NetMedOR.getCategorySearchField().clear();
		
		Thread.sleep(5000);
		SAssert.assertAll();
	}
	
	@Test(dependsOnMethods = {"categorySelection"} )
	public void clickTheManufacturer() throws InterruptedException, IOException {
		JavascriptExecutor Js1 = (JavascriptExecutor)driver;
		Js1.executeScript("window.scrollBy(0,500)");
		Thread.sleep(4000);
		NetMedOR.getManufacturerName1().click();
		Thread.sleep(5000);
		NetMedOR.getManufacturerName2().click();
		Thread.sleep(5000);
		if(NetMedOR.getcheckboxForManufacturer1().isSelected()) {
			boolean isManufacturerSelected = NetMedOR.getcheckboxForManufacturer2().isSelected();
			if(isManufacturerSelected) {
				Reporter.log("Both Manufacturer check boxes selected");
				Assert.assertTrue(isManufacturerSelected);
			}else {
				captureScreenshot(driver,"clickTheManufacturer");
				Reporter.log("Both Manufacturer check boxes not selected");
				Assert.assertTrue(isManufacturerSelected);
			}
		}
		List<WebElement> productList = NetMedOR.getProductListWithManufacturerName();
		  for(WebElement item: productList) { 
			  System.out.println(item.getText()); 
			  }
		  
	}
	@Test(dependsOnMethods = {"clickTheManufacturer"})
	public void isAddToCartPopUpDisplayed() throws InterruptedException, IOException{
		// Js.executeScript("arguments[0].scrollIntoView()", NetMedOR.getAddToCartButton());
		JavascriptExecutor Js2 = (JavascriptExecutor)driver;
		Js2.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(4000);
		NetMedOR.getAddToCartButton().click();
		Thread.sleep(5000);

		boolean isdisplayed = NetMedOR.getAddToCartPopUp().isDisplayed();
		if(isdisplayed) {
			Reporter.log("Order details added to the card is displayed");
			Assert.assertTrue(isdisplayed);
		}
		else {
			captureScreenshot(driver,"isAddToCartPopUpDisplayed");
			Reporter.log("Order details added to the card is not displayed");
			Assert.assertTrue(isdisplayed);
		}
		Thread.sleep(3000);

		Actions act = new Actions(driver);
		WebElement cardDetails = NetMedOR.getcartDetails();
		Thread.sleep(3000);
		act.moveToElement(cardDetails).build().perform();
		boolean isdisplayedMouseOver = NetMedOR.getAddToCartPopUp().isDisplayed();
		if(isdisplayedMouseOver) {
			Reporter.log("Order details added to the card is displayed");
			Assert.assertTrue(isdisplayedMouseOver);
		}
		else {
			captureScreenshot(driver,"isdAddToCartPopUpDisplayed");
			Reporter.log("Order details added to the card is not displayed");
			Assert.assertTrue(isdisplayedMouseOver);
		}
		System.out.println("TotalNumber of products in the page after applying filters " + NetMedOR.getTotalCount().getText());
	}
	
	@Test(dependsOnMethods = {"isAddToCartPopUpDisplayed"})
	public void CartPage() throws IOException {
		String FirstProduct = null;
		List<WebElement> productList = NetMedOR.getProductList();
		for(int i=0; i<productList.size(); i++) {
			if(i==0) {
				FirstProduct = productList.get(i).getText();
			}	
		}
		NetMedOR.getcartDetails().click();
		Boolean  CurrentUrlCart= driver.getCurrentUrl().contains("cart");
		if(CurrentUrlCart) {
			Reporter.log("The user is navigated to the cart page");
			Assert.assertTrue(CurrentUrlCart);
		}else {
			captureScreenshot(driver,"CartPage");
			Reporter.log("The user is not navigated to the cart page");
			Assert.assertTrue(CurrentUrlCart);
		}
		String ProductListInCart = NetMedOR.getProductDetailsInCart().getText();
		boolean isProductDisplayed = ProductListInCart.contains(FirstProduct);
		if(isProductDisplayed) {
			Reporter.log("The product added to the cart is present in the cart page");
			Assert.assertTrue(isProductDisplayed);
		}else {
			captureScreenshot(driver,"CartPage");
			Reporter.log("The product added to the cart is not present in the cart page");
			Assert.assertTrue(isProductDisplayed);
		}
	}
}

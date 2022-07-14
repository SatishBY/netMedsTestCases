package com.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.pages.NetMedsPages;


public class TC_NetMeds_001 extends NetMed_TestBase {
	@Test
	@Parameters({"Item"})
    public void SearchItem(String Item) throws IOException, InterruptedException {
    	boolean HomePageTitle = driver.getTitle().contains("Netmeds.com: Indian Online Pharmacy | Buy Medicines Online, Fast Delivery");
		if(HomePageTitle) {
			Reporter.log("The user is Landed on the NetMeds Home Page");
			Assert.assertTrue(HomePageTitle);
		}else {
			captureScreenshot(driver,"SearchItem");
			Reporter.log("The user is not Landed on the NetMeds Home Page");
			Assert.assertTrue(HomePageTitle);
		}
		boolean isPinCodeDisplayed = NetMedOR.getDeliveryPinCode().getText().equals("110002");
			if(isPinCodeDisplayed){
				Reporter.log("The default pincode 110002 is displayed");
				Assert.assertTrue(isPinCodeDisplayed);
			}else {
				captureScreenshot(driver,"SearchItem");
				Reporter.log("The default pincode 110002 is not displayed");
				Assert.assertTrue(isPinCodeDisplayed);
			}
		Thread.sleep(3000);
		NetMedOR.getSearchField().sendKeys(Item);
		boolean isSearchItemTyped = NetMedOR.getSearchField().getAttribute("value").equals("Dolo");
		if(isSearchItemTyped) {
			Reporter.log("Search item is typed");
			Assert.assertTrue(isSearchItemTyped);
		}else {
			captureScreenshot(driver,"SearchItem");
			Reporter.log("Search item is not typed");
			Assert.assertTrue(isSearchItemTyped);
		}
		
		NetMedOR.getSearchField().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		boolean PageUrl = driver.getCurrentUrl().contains("Dolo");
		if(PageUrl) {
			Reporter.log("Page related to item is loaded");
			Assert.assertTrue(PageUrl);
		}else {
			captureScreenshot(driver,"SearchItem");
			Reporter.log("Page related to item is not loaded");
			Assert.assertTrue(PageUrl);
		}
		
		List<WebElement> ItemList = NetMedOR.getItemList();
		int count = 0;
		for(WebElement item : ItemList ) {
			if(!item.getText().contains("Dolo")){
				Reporter.log("Item loaded is not related to search item");
			}else {
				count++;
			}
		}
			System.out.println(count);
			System.out.println(ItemList.size());
			boolean isItemsRelatedToSearchItem = (count == ItemList.size());
			if(isItemsRelatedToSearchItem) {
				Reporter.log("Items loaded are related to search item");
				Assert.assertTrue(isItemsRelatedToSearchItem);
			}else {
				captureScreenshot(driver,"SearchItem");
				Reporter.log("Items loaded are not related to search item");
				Assert.assertTrue(isItemsRelatedToSearchItem);
			}
		Thread.sleep(3000);
		NetMedOR.getFirstItem().click();
		boolean isdisplayed = NetMedOR.getAddToCartPopUp().isDisplayed();
		if(isdisplayed) {
			Reporter.log("Order details added to the cart is displayed");
			Assert.assertTrue(isdisplayed);
		}
		else {
			captureScreenshot(driver,"isAddToCartPopUpDisplayed");
			Reporter.log("Order details added to the cart is not displayed");
			Assert.assertTrue(isdisplayed);
		}
		
		
    }
}

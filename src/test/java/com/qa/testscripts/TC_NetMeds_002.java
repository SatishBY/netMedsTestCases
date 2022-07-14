package com.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_NetMeds_002 extends TC_NetMeds_001 {
    @Test(dependsOnMethods = {"SearchItem"})
	public void CartPage() throws IOException {
		String FirstProduct = null;
		List<WebElement> productList = NetMedOR.getItemList();
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

 
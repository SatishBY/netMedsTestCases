package com.qa.testscripts;
import org.openqa.selenium.Alert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.PaytmPages;

public class TC_Paytm_001 extends TestBase {
	@Test
	public  void FilterActivities() throws InterruptedException{
		SoftAssert SAssert = new SoftAssert();
		PaytmOR.getBookACylinder().click();
		String currentUrl = driver.getCurrentUrl();
		boolean status = currentUrl.contains("paytm");
		if(status) {
			Reporter.log("The user is landed on the Paytm page");
			Thread.sleep(2000);

			String title = driver.getTitle();
			boolean status2 = title.contains("Cylinder Booking");
			if(status2) {
				Reporter.log("The user is navigated to the Book a Cylinder page");
				SAssert.assertTrue(status2);
				PaytmOR.GasProviderField().click();
				PaytmOR.GasProviderName().click();
				Thread.sleep(3000);
			}
			else {
				
				Reporter.log("The user is not navigated to the Book a Cylinder page");
				SAssert.assertTrue(status2);
			}

		}
		else {
			
			Reporter.log("The user is not landed on the Paytm page");
			SAssert.assertTrue(status);

		}
		SAssert.assertAll();
	}  

	@Test(dataProvider = "getData")
	public void checktMobileNumberField(String MobileNumber) throws InterruptedException {
		SoftAssert SAssert = new SoftAssert();
		Boolean enabled = PaytmOR.MobileNumberInput().isEnabled();
		if(enabled) {
			Reporter.log("Mobile number Input field is enabled");
			PaytmOR.MobileNumberInput().sendKeys(MobileNumber);
			PaytmOR.ProceedButton().click();
			boolean displayed = PaytmOR.CloseSignInWindow().isDisplayed();
			if(displayed) {
				Reporter.log("Log in window is displayed");
				SAssert.assertTrue(displayed);
				Thread.sleep(3000);
				PaytmOR.CloseSignInWindow().click();
				Thread.sleep(3000);
			}
			else {
				Reporter.log("Log in window is not displayed");
				SAssert.assertTrue(displayed);
			}

			/*
			 * driver.navigate().to("https://paytm.com/coupons"); Thread.sleep(3000);
			 * PaytmOR.PromocodeLink().click(); Thread.sleep(3000);
			 * driver.switchTo().alert(); PaytmOR.DeleteIcon().click();
			 */

		}
		SAssert.assertAll();
	}
}


/*
 * Thread.sleep(3000); WebDriverWait wait = new WebDriverWait((WebDriver)
 * PaytmOR.WindowPage(),60);
 * if(wait.until(ExpectedConditions.alertIsPresent())== null) {
 * System.out.println("Please Enter the currect Mobile Number"); }else {
 * System.out.println("Log in window displayed");
 * PaytmOR.CloseSignInWindow().click(); Thread.sleep(3000); }
 */

/*Boolean displayed = PaytmOR.CloseSignInWindow().isDisplayed();
if(displayed) {
	   System.out.println("Log in window displayed");
	   PaytmOR.CloseSignInWindow().click();
	   Thread.sleep(3000);*/


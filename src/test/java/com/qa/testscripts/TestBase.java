package com.qa.testscripts;

import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.mongodb.MapReduceCommand.OutputType;
import com.qa.pages.PaytmPages;
import com.qa.utility.ExcelUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
   WebDriver driver;
   PaytmPages PaytmOR;
   
   @Parameters({"Browser","URL"})
   @BeforeClass 
   public void setup(String Browser, String URL) throws InterruptedException {
	   if(Browser.equalsIgnoreCase("Chrome")) {
		   WebDriverManager.chromedriver().setup();
		   ChromeOptions options = new ChromeOptions();
		   options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
		   driver = new ChromeDriver(options);
	   }else if (Browser.equalsIgnoreCase("Edge")) {
		   WebDriverManager.edgedriver().setup();
		   driver = new EdgeDriver();
	   }
		   
		   driver.get(URL);
		   driver.manage().window().maximize();
		   PaytmOR = new PaytmPages(driver);
	  
   }
   @AfterClass
   public void tearDown() {
	   driver.quit();
   }
   
   
   
  @DataProvider
  public String[][] getData() throws IOException {
	  String xFile = "C:\\Users\\91812\\Desktop\\Automation Testing\\TestAutomation.Selenium\\src\\test\\java\\com\\qa\\testdata\\TestData1.xlsx";
	  String xSheetName = "Sheet1";
	  
	  int rowCount = ExcelUtility.getRowCount(xFile, xSheetName);
		System.out.println(rowCount);
		
	  int cellCount = ExcelUtility.getCellCount(xFile, xSheetName,rowCount);
	  
	  String[][] data = new String[rowCount][cellCount];
	 
	  for (int i=1; i<=rowCount; i++) {
		     for(int j=0; j<cellCount; j++) {
			  data[i-1][j] = ExcelUtility.getCellData(xFile, xSheetName, i,j);
		     }
	  }
	  return data;
  }
  
	  
	/*
	 * public void captureScreenshot(WebDriver driver,String tName) throws
	 * IOException { TakesScreenshot ts = (TakesScreenshot)driver; File Source =
	 * ts.getScreenshotAs(OutputType.FILE); File Target = new
	 * File(System.getProperty("user.dir") + "/ScreenShots/" + tName + ".png");
	 * FileUtils.copyFile(Source, Target); }
	 */
	 
}

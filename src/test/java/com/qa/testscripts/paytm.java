package com.qa.testscripts;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class paytm {
   public static void main(String[] args) throws InterruptedException {
	   WebDriverManager.edgedriver().setup();
	   WebDriver driver = new EdgeDriver();
	   driver.get("https://paytm.com/");
	   driver.manage().window().maximize();
	   
	   driver.findElement(By.xpath("//*[@id=\"app\"]/div/section[3]/div/div/div/div[5]")).click();
       //driver.navigate().to("https://paytm.com/cylinder-gas-recharge");
	  // driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[4]/div[1]/div/div/div[2]/div[1]/div[1]/label")).click();
	   driver.findElement(By.className("_1exI")).click();
	  // List<WebElement> gasProvider = driver.findElements(By.className("_3xI1"));
	   //boolean displayed = ((WebElement) gasProvider).isDisplayed();
	   driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[4]/div[1]/div/div/div[2]/div[2]/ul/li[1]/div[1]/div/div[1]/ul/li[2]")).click();
       Thread.sleep(3000);
       WebElement inputField = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[4]/div[1]/div/div/div[2]/div[2]/ul/li[2]/div[1]/input"));
       boolean enabled = inputField.isEnabled();
       if(enabled) {
    	   System.out.println("Input Field is present");
    	   inputField.sendKeys("9740638830");
    	   Thread.sleep(3000);
    	   driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();    
    	   Thread.sleep(3000);
       }
       driver.navigate().to("https://paytm.com/coupons");
       Thread.sleep(3000);
       driver.findElement(By.className("pjke")).click();
       Alert alert = driver.switchTo().alert();
       alert.dismiss();
	   driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[4]/div[2]/div/div[1]/div/div/div[1]/div/div[1]/i")).click();
       
       
     //WebElement consumerDetails = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[4]/div[1]/div/div/div[2]/div[2]/ul/li[3]"));
       //driver.findElement(By.xpath("//a[@class='_2iSj' and @title = 'Close']")).click();
       Thread.sleep(5000);
       driver.close();
	  
	   }
}
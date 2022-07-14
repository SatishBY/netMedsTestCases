package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PaytmPages {
	public WebDriver driver;
	
	@FindBy(xpath= "//*[@id=\"app\"]/div/section[3]/div/div/div/div[5]") WebElement BookACylinder;
	
	
	public WebElement getBookACylinder() {
		return BookACylinder;
	}
	
	@FindBy(xpath= "//*[@id=\"app\"]/div/div[4]/div[1]/div/div/div[2]/div[1]/div[2]/label") WebElement BookACylinderRadioButton;
	
	public WebElement getBookACylinderRadioButton() {
		return BookACylinderRadioButton;
	}
	
    @FindBy(xpath= "//*[@id=\"app\"]/div/div[4]/div[1]/div/div/div[2]/div[1]/div[1]/label") WebElement PayGasBillRadioButton;
	
	public WebElement getPayGasBillRadioButton() {
		return PayGasBillRadioButton;
	}
	
	@FindBy(className ="_1exI") WebElement GasProviderField ;
	
	public WebElement GasProviderField() {
		return GasProviderField;
	}
	
	@FindBy(xpath ="//*[@id=\"app\"]/div/div[4]/div[1]/div/div/div[2]/div[2]/ul/li/div[1]/div/div/ul/li[2]/span") WebElement GasProviderName ;
	
	public WebElement GasProviderName() {
		return GasProviderName;
	}
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[4]/div[1]/div/div/div[2]/div[2]/ul/li[2]/div[1]/input") WebElement MobileNumberInput;
	
	public WebElement MobileNumberInput() {
		return MobileNumberInput;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Proceed')]") WebElement ProceedButton;
	
	public WebElement ProceedButton() {
		return ProceedButton;
	}
	
	@FindBy(className = "pjke") WebElement PromocodeLink;
	
	public WebElement PromocodeLink() {
		return PromocodeLink;
	}
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[4]/div[2]/div/div[1]/div/div/div[1]/div/div[1]/i") WebElement DeleteIcon;
	
	public WebElement DeleteIcon() {
		return DeleteIcon;
	}
	
	@FindBy(className = "_2iSj") WebElement CloseSignInWindow;
	
	public WebElement CloseSignInWindow() {
		return CloseSignInWindow;
	}
	
	@FindBy(id = "main-container") WebElement WindowPage;
	
	public WebElement WindowPage() {
		return WindowPage;
	}
	
	public PaytmPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	

}

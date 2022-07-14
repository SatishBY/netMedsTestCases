package com.qa.pages;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NetMedsPages {
       public WebDriver driver;
       
        @FindBy(xpath = "/html/body/div[1]/div[2]/nav/ul/li[7]") WebElement ClickOnFitness;
        
       public WebElement getClickOnFitness() {
    	   return ClickOnFitness;
       }
       
       @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[1]/ul/li[2]/ul") List<WebElement> FitnessCategoryList;
       
       public List<WebElement> getFitnessCategoryList() {
    	   return FitnessCategoryList;
       }
       
       @FindBy(xpath = "//a[contains(text(),'Vitamins And Supplements')]") WebElement FitnessSubCategory;
       
       public  WebElement getFitnessSubCategory() {
    	   return FitnessSubCategory;
       }
       
       @FindBy(className = "ais-RefinementList-list") WebElement AvailabilityCheckBox;
       
       public WebElement getAvailabilityCheckBox() {
    	   return AvailabilityCheckBox;
       }
       
       @FindBy(xpath = "//*[@id=\"stock_filter\"]/div/ul/li/div/div/div[1]/label/input") WebElement CheckBox;
       
       public WebElement getCheckBox() {
    	   return CheckBox;
       }
    
       @FindBy(xpath = "//*[@id=\"category_filter\"]/div/div/div/form/input") WebElement CategorySearchField;
       
       public WebElement getCategorySearchField() {
    	   return CategorySearchField;
       }
       
       @FindBy(xpath = "//input[@value ='Multi-Vitamins']") WebElement MultiVitaminsCheckBox;
       
       public WebElement getMultiVitaminsCheckBox() {
    	   return MultiVitaminsCheckBox;
       }
       
       @FindBy(xpath = "//input[@value ='Calcium And Minerals']") WebElement CalciumAndMineralsCheckBox;
       
       public WebElement getCalciumAndMineralsCheckBox() {
    	   return CalciumAndMineralsCheckBox;
       }
       @FindBy(xpath = "//*[@id=\"category_filter\"]/div/ul") List<WebElement> UnorderedListOfCategory;

       public List<WebElement> getUnorderedListOfCategory() {
    	   return UnorderedListOfCategory;
       }
       
       @FindBy(xpath = "//*[@id=\"manufacturer_filter\"]/div/ul/li[1]") WebElement ManufacturerName1;
       
       public WebElement getManufacturerName1() {
    	   return ManufacturerName1;
       }
       
       @FindBy(xpath = "//*[@id=\"manufacturer_filter\"]/div/ul/li[1]/div/div/label/input") WebElement checkboxForManufacturer1;
       
       public WebElement getcheckboxForManufacturer1(){
    	   return checkboxForManufacturer1;
       }
       
       @FindBy(xpath = "//*[@id=\"manufacturer_filter\"]/div/ul/li[2]") WebElement ManufacturerName2;
       
       public WebElement getManufacturerName2() {
    	   return ManufacturerName2;
       }
       
       @FindBy(xpath = "//*[@id=\"manufacturer_filter\"]/div/ul/li[2]/div/div/label/input") WebElement checkboxForManufacturer2;
       
       public WebElement getcheckboxForManufacturer2(){
    	   return checkboxForManufacturer2;
       }
       
       @FindBy(xpath = "//*[@id=\"brand_filter\"]/div/ul/li[1]") WebElement BrandName1;
       
       public WebElement getBrandName1() {
    	   return BrandName1;
       }
       
       @FindBy(xpath = "//*[@id=\"brand_filter\"]/div/ul/li[2]") WebElement BrandName2;
       
       public WebElement getBrandName2() {
    	   return BrandName2;
       }
       
       @FindBy(xpath = "//*[@id=\"alg_price_filter\"]/div/div/div[2]") WebElement RheostatPriceHandleLower;
       
       public WebElement getRheostatPriceHandleLower() {
    	   return RheostatPriceHandleLower;
       }
       
       @FindBy(xpath = "//*[@id=\"alg_price_filter\"]/div/div/div[3]") WebElement RheostatPriceHandleUpper;
       
       public WebElement getRheostatPriceHandleUpper( ) {
    	   return RheostatPriceHandleUpper;
       }
       
       @FindBy(xpath= "//*[@id=\"alg_discount_filter\"]/div/div/div[2]") WebElement RheostatDiscountHandleLower;
       
       public WebElement getRheostatDiscountHandleLower() {
    	   return RheostatDiscountHandleLower;
       }
       
       @FindBy(xpath= "//*[@id=\"alg_discount_filter\"]/div/div/div[3]") WebElement RheostatDiscountHandleUpper;

       public WebElement getRheostatDiscountHandleUpper() {
    	   return RheostatDiscountHandleUpper;
       }
       
       @FindAll(@FindBy(xpath = "//span[@class  =  'clsgetname']")) List<WebElement> ProductList;
       
       public List<WebElement> getProductList() {
    	   return ProductList;
       }
       
       @FindAll(@FindBy(xpath ="//li[@class = 'ais-InfiniteHits-item']")) List<WebElement> ProductListWithManufacturerName;
       
       public List<WebElement> getProductListWithManufacturerName(){
    	   return ProductListWithManufacturerName;
       }
       
       @FindBy(xpath = "//*[@id=\"algolia_hits\"]/div/div/ol/li[1]/div/form/button") WebElement AddToCartButton;
     
       public WebElement getAddToCartButton() {
    	   return AddToCartButton;
       }
       
       @FindBy(xpath = "//div[@class = 'text']") WebElement cartDetails;
       
       public WebElement getcartDetails() {
    	   return cartDetails;
       }
       
       @FindBy(xpath = "//*[@id=\"minicart_btn\"]/div/div[2]/a/div[3]/div") WebElement ProceedToCart;
       
       public WebElement getProceedToCart() {
    	   return ProceedToCart;
       }
       @FindBy(id = "webklipper-publisher-widget-container-notification-close-div") WebElement AddCloseButton;
       
       public WebElement getAddCloseButton() {
    	   return AddCloseButton;
       }
       
       @FindBy(className ="minicart_container") WebElement AddToCartPopUp;
       
       public WebElement  getAddToCartPopUp() {
    	   return AddToCartPopUp;
       }
       
       @FindBy(xpath = "//*[@id=\"app\"]/main/app-shopping-cart/div[1]/div/div/div[1]/div[2]") WebElement ProductDetailsInCart;
       
       public WebElement getProductDetailsInCart() {
    	   return ProductDetailsInCart;
       }
       
       @FindBy(id = "total_count") WebElement TotalCount;
       
       public WebElement getTotalCount() {
    	   return TotalCount;
       }
       
       @FindBy(id = "delivery_details") WebElement DeliveryPinCode;
       
       public WebElement getDeliveryPinCode() {
    	   return DeliveryPinCode;
       }
       
       @FindBy(id = "search") WebElement SearchField;
       
       public WebElement getSearchField() {
    	   return SearchField;
       }
       
       @FindAll(@FindBy(xpath = "//div[@class  =  'info']")) List<WebElement> ItemList;
       
       public List<WebElement> getItemList() {
    	   return ItemList;
       }
       
       @FindBy(xpath = "//*[@id=\"algolia_hits\"]/li[1]/div/div/div[3]/form/div") WebElement FirstItem;
    
       
       public WebElement getFirstItem() {
    	   return FirstItem;
       }
       
       public NetMedsPages(WebDriver driver) {
   		this.driver = driver;
   		PageFactory.initElements(driver, this);
   	}

	


        
}

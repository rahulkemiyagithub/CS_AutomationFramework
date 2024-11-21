package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	
	//create an object of webdriver
		WebDriver localDriver;

		//Constructor
		public SearchResultPage(WebDriver Remotedriver)
		{
			localDriver = Remotedriver;
			PageFactory.initElements(Remotedriver, this);
		}

		// Identify the web elements present in search result page
		
		//a[href$='https://magento.softwaretestingboard.com/selene-yoga-hoodie.html']
		@FindBy(xpath = "//a[contains(text(),'Selene Yoga Hoodie')]")
		WebElement searchResultProduct;
		
		@FindBy(linkText = "Selene Yoga Hoodie")
		WebElement clickOnProductNameLinkHoodie;
		
		
		// action methods on web elements of search result page
		
		public String getSearchResultProductName()
		{
			String getProduct = searchResultProduct.getText();
			return getProduct;
		}
		
		public void clickOnProductNameLink()
		{
			clickOnProductNameLinkHoodie.click();
		}
		
}

package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPaymentMethodPage {
	
	//create an object of webdriver
	WebDriver localDriver;
	
	//Constructor
	public OrderPaymentMethodPage(WebDriver RemoteDriver)
	{
		localDriver = RemoteDriver;
		PageFactory.initElements(RemoteDriver, this);
	}
	
	// Identify web elements for the order payment method page
	
	@FindBy(xpath = "//button[@class='action primary checkout']")
	WebElement clickOnPlaceOrderButton;
	
	
	// Actions methods for the find web elements on order payment method page
	
	public void clickOnPlaceOrderButtonOrderPaymentMethodPage()
	{
		clickOnPlaceOrderButton.click();
	}
	

}

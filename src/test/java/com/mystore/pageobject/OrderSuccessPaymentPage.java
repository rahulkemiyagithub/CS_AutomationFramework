package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSuccessPaymentPage {
	
	//create an object of webdriver
	WebDriver localDriver;
	
	//Constructor
	public OrderSuccessPaymentPage(WebDriver RemoteDriver)
	{
		localDriver = RemoteDriver;
		PageFactory.initElements(RemoteDriver, this);
	}
	
	// Identify web elements for the order payment success page
	
	@FindBy(xpath = "//h1[contains(.,'Thank you for your purchase!')]")
	WebElement successOrderMsg;
	
	
	// Actions methods for the find web elements on order payment success page
	
	public String getOrderSuccessMessage()
	{
		 return successOrderMsg.getText();
		
	}

}

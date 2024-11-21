package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWishListProductPage {

	//create an object of webdriver
	WebDriver localDriver;

	//Constructor
	public MyWishListProductPage(WebDriver RemoteDriver)
	{
		localDriver = RemoteDriver;
		PageFactory.initElements(RemoteDriver, this);

	}



	// Identify web elements for the MyWishListProductPage product page
	
	@FindBy(xpath = "(//div[@class='message-success success message'])[1]")
	WebElement successMsgProductAddedIntoWishList;


	// Create action methods for the web elements
	
	public String verifySuccessAlertMsgProductAddedIntoWishList()
	{
		return successMsgProductAddedIntoWishList.getText();
	}


	


}

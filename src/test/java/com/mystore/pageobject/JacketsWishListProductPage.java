package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JacketsWishListProductPage {
	
	//create an object of webdriver
	WebDriver localDriver;
	
	//Constructor
	public JacketsWishListProductPage(WebDriver RemoteDriver)
	{
		localDriver = RemoteDriver;
		PageFactory.initElements(RemoteDriver, this);
		
	}
	
	
	// Identify web elements for the WishList product page
	
	@FindBy(linkText = "Juno Jacket")
	WebElement clickOnJunoJacketProduct;
	
//	@FindBy(xpath = "(//a[@title='Add to Wish List'])[2]")
//	WebElement clickOnJunoJacketProduct;
	
	// Create action methods for the web elements
	
	public void clickedOnJunoJacketProduct()
	{
//		Actions action = new Actions(localDriver);
//		action.moveToElement(clickOnJunoJacketProduct).build().perform();
		clickOnJunoJacketProduct.click();
		
	}
	

}

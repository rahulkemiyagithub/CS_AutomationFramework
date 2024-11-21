package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	//create an object of webdriver
	WebDriver localDriver;
	
	//Constructor
	public ProductPage(WebDriver RemoteDriver)
	{
		localDriver =  RemoteDriver;
		PageFactory.initElements(RemoteDriver, this);
	}
	
	// Identify elements presents in the login page
	
	@FindBy(id = "option-label-size-143-item-168")
	WebElement selectSizeM;
	
	@FindBy(id = "option-label-color-93-item-56")
	WebElement selectColorOrange;
	
	@FindBy(id = "qty")
	WebElement enterQuantity;
	
	@FindBy(id = "product-addtocart-button")
	WebElement clickOnAddToCartButton;
	
	//a[@class='action showcart active']
	@FindBy(css = ".action.showcart")
	WebElement clickOnMyCartIcon;
	
	@FindBy(id = "top-cart-btn-checkout")
	WebElement clickOnProceedToCheckOut;
	
	
	//Create action methods for web elements
	
	public void selectProductSize()
	{
		selectSizeM.click();
	}
	
	public void selectProductColor()
	{
		selectColorOrange.click();
	}
	
	public void enterQuantity(String qty)
	{
		enterQuantity.clear();
		enterQuantity.sendKeys(qty);
	}
	
	public void clickOnAddToCartButton()
	{
		clickOnAddToCartButton.click();
	}
	
	public void clickOnCartIcon()
	{
		clickOnMyCartIcon.click();
	}
	
	public void clickOnProceedToCheckOut()
	{
		clickOnProceedToCheckOut.click();
	}
	

}

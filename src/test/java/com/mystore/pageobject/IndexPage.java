package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

	//create an object of webdriver
	WebDriver localDriver;

	//Constructor
	public IndexPage(WebDriver Remotedriver)
	{
		localDriver = Remotedriver;
		PageFactory.initElements(Remotedriver, this);
	}


	//identify webelements
	@FindBy(linkText = "Create an Account")
	WebElement CreateAnAccount;

	////div[@class='panel header']//a[contains(text(),'Sign In')]
	//identify webelements for registered user
	@FindBy(linkText = "Sign In")
	WebElement ClickOnSignInRegisterUser;


	//Actions methods for new account creation
	public void ClickOnCreateAccount()
	{
		CreateAnAccount.click();
	}

	//Actions methods for already registered users
	public void ClickOnSingLinkRegisterUser()
	{
		ClickOnSignInRegisterUser.click();
	}

}

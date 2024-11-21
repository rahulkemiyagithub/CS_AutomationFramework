package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateMyAccount {

	//Create an object of webdriver
	WebDriver localDriver;

	//Constructor
	public CreateMyAccount(WebDriver RemoteDriver)
	{
		localDriver = RemoteDriver;
		PageFactory.initElements(RemoteDriver, this);
	}

	//identify webelements
	//Create new account
		@FindBy(id = "firstname")
		WebElement enterFirstName;

		@FindBy(id = "lastname")
		WebElement enterLastName;

		@FindBy(id = "email_address")
		WebElement enterEmailAddress;

		@FindBy(id = "password")
		WebElement enterPassword;

		@FindBy(id = "password-confirmation")
		WebElement enterConfirmPassword;

		@FindBy(xpath = "//button[@title='Create an Account']")
		WebElement ClickOnNewCreateAccountButton;

	//Already registered user
		@FindBy(id = "email")
		WebElement registeredUsersEmail;

		@FindBy(id = "pass")
		WebElement registeredUsersPass;

		@FindBy(id = "send2")
		WebElement registeredUsersSignInButton;


	// Actions methods of webelement for new user
		public void enterFName(String fName)
		{
			enterFirstName.sendKeys(fName);
		}

		public void enterLName(String lName)
		{
			enterLastName.sendKeys(lName);
		}

		public void enterEmailAdd(String emailAdd)
		{
			enterEmailAddress.sendKeys(emailAdd);
		}

		public void enterPass(String pass)
		{
			enterPassword.sendKeys(pass);
		}

		public void enterConfirmPass(String ConfirmPass)
		{
			enterConfirmPassword.sendKeys(ConfirmPass);
		}

		public void clickSubmitCreate()
		{
			ClickOnNewCreateAccountButton.click();
		}


		//Actions methods for already registered users

		public void enterRegisteredEmailAddress(String emailAdd)
		{
			registeredUsersEmail.sendKeys(emailAdd);
		}

		public void enterRegisteredPassword(String pwd)
		{
			registeredUsersPass.sendKeys(pwd);
		}

		public void clickOnSingInButtonForRegisterCustomerLogin()
		{
			registeredUsersSignInButton.click();
		}



}

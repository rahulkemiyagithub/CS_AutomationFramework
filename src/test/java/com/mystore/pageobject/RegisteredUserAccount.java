package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUserAccount {

	//create an object of webdriver
		WebDriver localDriver;

		//Constructor
		public RegisteredUserAccount(WebDriver Remotedriver)
		{
			localDriver = Remotedriver;
			PageFactory.initElements(Remotedriver, this);
		}


		//identify webelements
		@FindBy(xpath = "(//li[@class='greet welcome'])[1]")
		WebElement registeredUserName;
		
		// identify singOut webelements
		@FindBy(xpath = "(//button[@class='action switch'])[1]")
		WebElement clickOnDataToggleDropdown;
		
		@FindBy(linkText = "Sign Out")
		WebElement clickOnSingOutLink;
		
	
		@FindBy(id="search")
		WebElement searchBox;
		
		@FindBy(xpath="//button[@title='Search']")
		WebElement submit_Search;

		@FindBy(linkText = "Women")
		WebElement clickOnWomen;
		
		@FindBy(xpath = "//a[contains(text(),'Jackets')]")
		WebElement clickOnJacketProduct;
		
		
		// actions of webelement
		public String getUserName()
		{
			String text = registeredUserName.getText();
			return text;

		}
		
		// actions on signout link
		public void clickOnDataToggleMenu()
		{
			clickOnDataToggleDropdown.click();
		}
		
		public void clickOnSignOut()
		{
			clickOnSingOutLink.click();
		}
		
		public void enterDataInSearchBox(String searchKeyData)
		{
			searchBox.sendKeys(searchKeyData);
		}
		
		public void clickOnSearchButton()
		{
			submit_Search.click();
		}
		
		public void clickOnWomenLink()
		{
			clickOnWomen.click();
		}
		
		public void clickOnJacketProductLink()
		{
			clickOnJacketProduct.click();
		}
		
		
		

}

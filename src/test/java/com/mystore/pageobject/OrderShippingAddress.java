package com.mystore.pageobject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrderShippingAddress {
	
	//create an object of webdriver
	WebDriver localDriver;
	
	//Constructor
	public OrderShippingAddress(WebDriver RemoteDriver)
	{
		localDriver = RemoteDriver;
		PageFactory.initElements(RemoteDriver, this);
	}
	
	
	// Identify web elements for the order shipping address page
	
	@FindBy(name = "firstname")
	WebElement addressFirstName;
	
	@FindBy(name = "lastname")
	WebElement addressLastName;
	
	@FindBy(name = "street[0]")
	WebElement streetAddress;
	
	@FindBy(name = "city")
	WebElement cityName;
	
	@FindBy(name = "postcode")
	WebElement zipPostalCode;
	
	@FindBy(name = "country_id")
	WebElement selectCountry;
	
	@FindBy(name = "region_id")
	WebElement selectCityStateProvince;
	
	@FindBy(name = "telephone")
	WebElement mobileNumber;
	
	//button[@class='button action continue primary']
	//@FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[2]/div[1]/div[3]/form[1]/div[3]/div[1]/button[1]/span[1]")
	@FindBy(css = ".button.action.continue.primary")
	WebElement clickOnNextButton;
	
	//div//button[@class='action action-show-popup']//span[text()='New Address']
	//span[normalize-space()='New Address']
	@FindBy(css = ".action.action-show-popup")
	WebElement clickOnNewAddress;
	
	@FindBy(css = ".action.primary.action-save-address")
	WebElement clickOnShipHereButton;
	
	//Create action methods for the web elements
	
	public void enterOrderShippingAddressFName(String fName)
	{
		addressFirstName.clear();
		addressFirstName.sendKeys(fName);
	}
	
	public void enterOrderShippingAddressLName(String LName)
	{
		addressLastName.clear();
		addressLastName.sendKeys(LName);
	}
	
	public void enterOrderShippingAddressStreetAddress(String strtAddress)
	{
		streetAddress.sendKeys(strtAddress);
	}
	
	public void enterOrderShippingAddressCityName(String ctyName)
	{
		cityName.sendKeys(ctyName);
	}
	
	public void enterOrderShippingAddresszipPostalCode(String postalCode)
	{
		zipPostalCode.sendKeys(postalCode);
	}
	
	//selectCountry
	public void enterOrderShippingAddressSelectCountry(String countryName)
	{
		Select countrySelect = new Select(selectCountry);
		countrySelect.selectByVisibleText(countryName);	
	}
	
	//selectCityStateProvince
	public void enterOrderShippingAddressSelectCityStateProvince(String cityStateName)
	{
		Select countrySelect = new Select(selectCityStateProvince);
		countrySelect.selectByVisibleText(cityStateName);	
	}
	
	public void enterOrderShippingAddressMobileNumber(String mobNumber)
	{
		mobileNumber.sendKeys(mobNumber);
	}
	
	public void clickOnNextButtonOrderShippingAddressPage()
	{
		clickOnNextButton.click();
	}
	
	public void clickOnAddNewAddressButton()
	{
		clickOnNewAddress.click();
	}
	
	public void clickOnShipHereButtonOrderShippingAddressPage()
	{
		clickOnShipHereButton.click();	
		
	}
	
	

}

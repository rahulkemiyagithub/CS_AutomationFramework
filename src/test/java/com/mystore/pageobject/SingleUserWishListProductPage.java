package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingleUserWishListProductPage {
	
	//create an object of web driver
		WebDriver localDriver;
		
		//Constructor
		public SingleUserWishListProductPage(WebDriver RemoteDriver)
		{
			localDriver = RemoteDriver;
			PageFactory.initElements(RemoteDriver, this);
			
		}
		
		
		// Identify web elements for the Jacket Wish List Product Page
		
		@FindBy(css = "div[class='product-addto-links'] a[class='action towishlist'] span")
		WebElement clickOnAddToWishListJunoJacketProduct;
		
		
		// Create action methods for the web elements
		
		public void clickedOnAddToWishListJunoJacketProduct()
		{

			clickOnAddToWishListJunoJacketProduct.click();
		}

}

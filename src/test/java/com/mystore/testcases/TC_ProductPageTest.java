package com.mystore.testcases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestListener;
import org.testng.annotations.Test;

import com.mystore.pageobject.CreateMyAccount;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.SingleUserWishListProductPage;
import com.mystore.utilities.ExtentListenerClass;
import com.mystore.pageobject.MyWishListProductPage;
import com.mystore.pageobject.OrderPaymentMethodPage;
import com.mystore.pageobject.OrderShippingAddress;
import com.mystore.pageobject.OrderSuccessPaymentPage;
import com.mystore.pageobject.ProductPage;
import com.mystore.pageobject.RegisteredUserAccount;
import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.JacketsWishListProductPage;

import junit.framework.Assert;

public class TC_ProductPageTest extends BaseClass{
	
	
	@Test()
	public void verifySearchProduct() throws IOException, InterruptedException
	{	
		String searchKeyData = "Hoodie";
		logger.info("\n******************TestCase Search Product Started*****************");
		
		//Sign in
		IndexPage pg = new IndexPage(driver);

		pg.ClickOnSingLinkRegisterUser();
		logger.info("Clicked on singin account link.");

		//Enter account details - email and password
		CreateMyAccount myAccpg = new CreateMyAccount(driver);
		
		myAccpg.enterRegisteredEmailAddress(email_id);
		logger.info("Entered email address");
		
		myAccpg.enterRegisteredPassword(password);
		logger.info("Entered password");

		myAccpg.clickOnSingInButtonForRegisterCustomerLogin();
		logger.info("Clicked on singIn - clickOnSingInButtonForRegisterCustomerLogin - button.");
		
		//Enter searchkey in search box
		RegisteredUserAccount regisUser = new RegisteredUserAccount(driver);
		
		regisUser.enterDataInSearchBox(searchKeyData);
		logger.info("Enter searched data in search box.");
		
		regisUser.clickOnSearchButton();
		logger.info("Clicked on searched button.");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)"); //scrolling in window level
		
		//Get name of searched product
		SearchResultPage searchPage = new SearchResultPage(driver);
		String getSearchProductName = searchPage.getSearchResultProductName();
		
		if(getSearchProductName.contains(searchKeyData))
		{
			Thread.sleep(5000);
			logger.info("Search Product TestCase - Passed");
			Assert.assertTrue(true);
			
			regisUser.clickOnDataToggleMenu();
			regisUser.clickOnSignOut();
			
		}
		else
		{
			logger.info("Search Product TestCase - Failed");
			captureScreenShot(driver,"verifySearchProduct");
			Assert.assertTrue(false);
			
		}
		
		logger.info("***************TestCase Search Product ends*********************");
		
	}
	
	
	@Test()
	public void verifyBuyProduct() throws InterruptedException, IOException
	{	
		String searchKey = "HOODIE";
		logger.info("\n******************TestCase Search Buy Product Started*****************");
		
		//Sign in
		IndexPage pg = new IndexPage(driver);

		pg.ClickOnSingLinkRegisterUser();
		logger.info("Clicked on singin account link.");

		//Enter account details - email and password
		CreateMyAccount myAccpg = new CreateMyAccount(driver);
		
		myAccpg.enterRegisteredEmailAddress(email_id);
		logger.info("Entered email address");
		
		myAccpg.enterRegisteredPassword(password);
		logger.info("Entered password");

		myAccpg.clickOnSingInButtonForRegisterCustomerLogin();
		logger.info("Clicked on singIn button.");
		
		//Enter searchkey in search box
		RegisteredUserAccount regisUser = new RegisteredUserAccount(driver);	
		regisUser.enterDataInSearchBox(searchKey);
		logger.info("Hoodie entered in search box");
		
		regisUser.clickOnSearchButton();
		logger.info("Clicked on searched button");
		
		Thread.sleep(2000);
		
		//Get name of searched product
		SearchResultPage searchPage = new SearchResultPage(driver);
		searchPage.getSearchResultProductName();
		searchPage.clickOnProductNameLink();
		logger.info("Clicked on searched product - Selene Yoga Hoodie");
		
		ProductPage productPg = new ProductPage(driver);
		productPg.selectProductSize();
		logger.info("Size M entered");
		
		productPg.selectProductColor();
		logger.info("Orange color selected");
		
		productPg.enterQuantity("2");
		logger.info("Quantity 2 entered");
		
		productPg.clickOnAddToCartButton();
		logger.info("Clicked on add to cart button");
		
		Thread.sleep(2000);
		
		productPg.clickOnCartIcon();
		logger.info("Clicked on add to cart icon");
		
		Thread.sleep(4000);
		
		productPg.clickOnProceedToCheckOut();
		logger.info("Clicked on proceed to checkout on product page");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2700)"); //scrolling in window level
		
		OrderShippingAddress orderShippingAddress = new OrderShippingAddress(driver);
		
		js.executeScript("window.scrollBy(0,2700)"); //scrolling in window level
		Thread.sleep(5000);
		orderShippingAddress.clickOnAddNewAddressButton();
		logger.info("Clicked on New Address button on shipping address page");
		
		orderShippingAddress.enterOrderShippingAddressFName("Rahul");
		orderShippingAddress.enterOrderShippingAddressLName("Kumar");
		orderShippingAddress.enterOrderShippingAddressStreetAddress("Okhla Delhi, GT Road");
		orderShippingAddress.enterOrderShippingAddressCityName("South Delhi");
		orderShippingAddress.enterOrderShippingAddresszipPostalCode("110020");
		orderShippingAddress.enterOrderShippingAddressSelectCountry("India");
		logger.info("Country selected from dropdown - India");
		
		orderShippingAddress.enterOrderShippingAddressSelectCityStateProvince("Delhi");
		logger.info("City selected from dropdown - Delhi");
		
		orderShippingAddress.enterOrderShippingAddressMobileNumber("9292929292");
		logger.info("All the details entered in shipping address page for order processing....!!!");
		
		Thread.sleep(5000);
		orderShippingAddress.clickOnShipHereButtonOrderShippingAddressPage();
		
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,2700)"); //scrolling in window level
		orderShippingAddress.clickOnNextButtonOrderShippingAddressPage();
		logger.info("Clicked on next button on shipping address page");
		
//		Alert alert = driver.switchTo().alert(); // switch to alert
//
//		String alertMessage= driver.switchTo().alert().getText(); // capture alert message
//
//		System.out.println(alertMessage); // Print Alert Message
//		Thread.sleep(5000);
//		alert.dismiss();
		
		OrderPaymentMethodPage orderPaymentMethodPage = new OrderPaymentMethodPage(driver);
		js.executeScript("window.scrollBy(0,2700)"); //scrolling in window level
		
		Thread.sleep(10000);
		orderPaymentMethodPage.clickOnPlaceOrderButtonOrderPaymentMethodPage();
		logger.info("Clicked on place order on payment method page");
		
		OrderSuccessPaymentPage successPaymentPage = new OrderSuccessPaymentPage(driver);
		js.executeScript("window.scrollBy(0,1000)"); //scrolling in window level
		//String successMsg  = successPaymentPage.getOrderSuccessMessage();
		
		String actualSuccessMsg = successPaymentPage.getOrderSuccessMessage();
		String expectedSuccessMsg = "Thank you for your purchase!";
		
		Thread.sleep(5000);
		//Assert.assertEquals(successMsg, "Checkout");
		if(actualSuccessMsg.equals(expectedSuccessMsg))
		{
			
			logger.info("Verify buy product success payment message - Passed");
			Assert.assertTrue(true);
			
			regisUser.clickOnDataToggleMenu();
			regisUser.clickOnSignOut();
			
		}
		else
		{
			logger.info("Verify buy product not success payment message - Failed");
			captureScreenShot(driver,"verifyBuyProduct");
			Assert.assertTrue(false);
		}
		
		logger.info("***************TestCase BuyProduct ends*****************");
		
	}
	
	
	@Test()
	public void verifyToAddWishlistProduct() throws IOException, InterruptedException
	{		
		logger.info("\n******************TestCase verifyToAddWishlistProduct Started*****************");
		
		//Sign in
		IndexPage pg = new IndexPage(driver);

		pg.ClickOnSingLinkRegisterUser();
		logger.info("Clicked on singin account link.");

		//Enter account details - email and password
		CreateMyAccount myAccpg = new CreateMyAccount(driver);
		
		myAccpg.enterRegisteredEmailAddress(email_id);
		logger.info("Entered email address");
		
		myAccpg.enterRegisteredPassword(password);
		logger.info("Entered password");

		myAccpg.clickOnSingInButtonForRegisterCustomerLogin();
		logger.info("Clicked on singIn - clickOnSingInButtonForRegisterCustomerLogin - button.");
		
		RegisteredUserAccount regisUser = new RegisteredUserAccount(driver);
		regisUser.clickOnWomenLink();
		logger.info("Clicked on women link.");
		
		regisUser.clickOnJacketProductLink();
		logger.info("Clicked on jackets product.");
		
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)"); //scrolling in window level
		
		JacketsWishListProductPage jacketsWishListProductPage = new JacketsWishListProductPage(driver);
		jacketsWishListProductPage.clickedOnJunoJacketProduct(); 
		logger.info("Clicked on add to click On Juno Jacket Product link.");
		
		js.executeScript("window.scrollBy(0,500)"); //scrolling in window level
		
		SingleUserWishListProductPage singletWishListProduct = new SingleUserWishListProductPage(driver);
		singletWishListProduct.clickedOnAddToWishListJunoJacketProduct();;
		logger.info("Clicked on add to JacketWishListProductPage linkText.");
		
		//Thread.sleep(10000);
		MyWishListProductPage myWishListProductPage = new MyWishListProductPage(driver);
		
		String actualMsg = myWishListProductPage.verifySuccessAlertMsgProductAddedIntoWishList();
		String exptectedMsg = "Juno Jacket has been added to your Wish List. Click here to continue shopping.";
		
		if(actualMsg.equals(exptectedMsg))
		{	
			logger.info("Verify product added into WishList - Passed");
			Assert.assertTrue(true);
			
			regisUser.clickOnDataToggleMenu();
			regisUser.clickOnSignOut();
			
		}
		else
		{
			logger.info("Verify product not added into WishList - Failed");
			captureScreenShot(driver, "verifyToAddWishlistProduct");
			Assert.assertTrue(false);
		}
		
	}

}

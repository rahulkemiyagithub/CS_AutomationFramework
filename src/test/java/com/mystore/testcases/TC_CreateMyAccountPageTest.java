package com.mystore.testcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.mystore.pageobject.CreateMyAccount;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.RegisteredUserAccount;

import junit.framework.Assert;

public class TC_CreateMyAccountPageTest extends BaseClass {

	@Test(enabled=false)
	public void verifyRegistrationAndLogin() throws InterruptedException
	{


		IndexPage pg = new IndexPage(driver);
		pg.ClickOnCreateAccount();
		logger.info("Clicked on create an account link.");

		CreateMyAccount myAccpg = new CreateMyAccount(driver);
		myAccpg.enterFName("Rahul");
		logger.info("Entered first name in input field.");

		myAccpg.enterLName("Kumar");
		logger.info("Entered last name in input field.");

		myAccpg.enterEmailAdd("rahulkumar999@gmail.com");
		logger.info("Email address entered in create account section.");

		myAccpg.enterPass("Rahkum999");
		logger.info("Password entered in create account section.");

		myAccpg.enterConfirmPass("Rahkum999");
		logger.info("Confirm password entered in create account section.");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)"); //scrolling in window level

		myAccpg.clickSubmitCreate();
		logger.info("Clicked on create an account submit button.");
		Thread.sleep(5000);

		RegisteredUserAccount regisUser = new RegisteredUserAccount(driver);
		String userName = regisUser.getUserName();

		Assert.assertEquals("Welcome, Rahul Kumar!", userName);
		

	}

	@Test
	public void verifyLogin() throws IOException, InterruptedException
	{
		logger.info("VerifyLogin test execution started.....");

		IndexPage pg = new IndexPage(driver);

		pg.ClickOnSingLinkRegisterUser();
		logger.info("Clicked on singin account link.");

		CreateMyAccount myAccpg = new CreateMyAccount(driver);

		myAccpg.enterRegisteredEmailAddress(email_id);
		logger.info("Entered email address");

		myAccpg.enterRegisteredPassword(password);
		logger.info("Entered password");

		myAccpg.clickOnSingInButtonForRegisterCustomerLogin();
		logger.info("Clicked on singIn button.");

		Thread.sleep(5000);

		RegisteredUserAccount regisUser = new RegisteredUserAccount(driver);
		String userName = regisUser.getUserName();

		if(userName.equals("Welcome, Rahul Kumar!"))
		{
			logger.info("VerifyLogin - Passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("VerifyLogin - Failed");
			captureScreenShot(driver,"verifyLogin");
			Assert.assertTrue(false);

		}

	}

}

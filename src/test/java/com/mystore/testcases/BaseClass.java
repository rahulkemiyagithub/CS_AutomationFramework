package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.mystore.utilities.ReadConfigFile;

public class BaseClass {

	ReadConfigFile readConfig = new ReadConfigFile();

	String url = readConfig.getBaseUrl();
	String browser = readConfig.getBrowser();
	String email_id = readConfig.getEmailIdUserName();
	String password = readConfig.getPassword();

	public static WebDriver driver;
	public static Logger logger;

	@BeforeClass
	public void setUp()
	{

		switch(browser.toLowerCase())
		{
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "msedge":
			driver = new EdgeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		default:
			driver = null;
			break;

		}

		//implicit wait of 10 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//for logging
		logger = LogManager.getLogger("MyStoreV1");

		//open url
		driver.get(url);
		driver.manage().window().maximize();
		logger.info("url opened");

	}

	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
		driver.quit();
	}
	

	public void captureScreenShot(WebDriver driver , String testName) throws IOException
	{
		//Step 1 : convert webdriver object to TakeScreenshot interface
		TakesScreenshot screenShot = ((TakesScreenshot) driver);

		//Step 2 : call getScreenshotAs method to create image file
		File src = screenShot.getScreenshotAs(OutputType.FILE);

		File destination = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");

		//Step 3 : copy image file to destination
		FileUtils.copyFile(src, destination);

	}



}

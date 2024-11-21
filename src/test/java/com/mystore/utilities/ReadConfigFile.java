package com.mystore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfigFile {
	
	Properties properties;
	String path = "C:\\Users\\CSCSPV868\\eclipse-workspace\\CS_AutomationFramework\\MyStoreV1\\Configuration\\config.properties";
	
	//Constructor
	public ReadConfigFile()
	{
		try {
		properties = new Properties();
		
			FileInputStream inputStream = new FileInputStream(path);
			properties.load(inputStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getBaseUrl()
	{
		String value = properties.getProperty("baseURL");
		
		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in config file.");
	}
	
	public String getBrowser()
	{
		String value = properties.getProperty("browser");
		
		if(value!=null)
			return value;
		else
			throw new RuntimeException("browser not specified in config file");
		
	}
	
	public String getEmailIdUserName()
	{
		String value = properties.getProperty("email_id");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("email id username is not specified in config file");
	}
	
	public String getPassword()
	{
		String value = properties.getProperty("password");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("password is not specified in config file");
	}
	
	
}

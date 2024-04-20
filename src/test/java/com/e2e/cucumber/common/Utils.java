package com.e2e.cucumber.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utils extends TestStarter{
	
	public void clickElementAndEnterText(WebElement element,String webText) {
		try {
			element.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			element.sendKeys(webText);
			
		}
		catch(Exception e) {
			
		}
	}
	
	public String propertyFileHandle(String key) throws IOException {
		Properties properties = new Properties();
		FileInputStream input = new FileInputStream(new File("credential.properties"));
		
		properties.load(input);
		String property = (String) properties.get(key);
		return property;
	}

}

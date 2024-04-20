package com.e2e.cucumber.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestStarter {
	public static WebDriver driver;
	
	
	public TestStarter() {
		try {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Failed to start");
		}
	}

}

package com.e2e.cucumber.stepdefinition;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

import com.e2e.cucumber.common.TestStarter;
import com.e2e.cucumber.common.Utils;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.bytebuddy.asm.Advice.This;

public class TestSwagLabLoginStepDef extends Utils {

    private static final Logger logger = LoggerFactory.getLogger(This.class);

	public TestSwagLabLoginStepDef() {
		PageFactory.initElements(driver,this);
	}
	@Given("connected to swag url")
	public void connectedToSwagUrl() {
		try {
			driver.get("https://www.saucedemo.com/");
			String title = driver.getTitle();
			logger.info("Web site title "+ title);
		}
		catch(Exception e) {
			
		}
	}
	@FindBy(xpath = "//input[@id='user-name']")
	private WebElement usernamePath;
	
	@And("login with correct username")
	public void loginWithCorrectUsername() {
		try {
			clickElementAndEnterText(usernamePath, propertyFileHandle("sales.username"));
			//usernamePath.sendKeys(propertyFileHandle("sales.username"));
		}
		catch(Exception e) {
			
		}
	}
	@FindBy(xpath="//input[@id='password']")
	private WebElement passwordPath;
	
	@Then("login with correct password")
	public void loginWithCorrectPassword() {
		try {
			clickElementAndEnterText(passwordPath, propertyFileHandle("sales.password"));
		}
		catch(Exception e) {
			logger.info("Failed on login");
		}
	}
	
	@FindBy(xpath="//input[@id='login-button']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[@class='app_logo']")
	private WebElement appLogValidate;
	
	@Then("login to swag labs")
	public void loginToSwagLabs() {
		try {
			loginButton.click();
			assertEquals("Failed to login", "Swag Labs", appLogValidate.getText());
		}
		catch(Exception e) {
			
		}
	}
	
	@After
	public void quitServer() {
		driver.quit();
	}
}

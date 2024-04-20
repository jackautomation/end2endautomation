package com.e2e.cucumber.stepdefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

import com.e2e.cucumber.common.TestStarter;
import com.e2e.cucumber.common.Utils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TestSwagLabLoginStepDef extends Utils {

    private static final Logger logger = LogManager.getLogger(TestSwagLabLoginStepDef.class);

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
	@FindBy(css = "//input[@id='user-name']")
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
	@FindBy(css="//input[@id='password']")
	private WebElement passwordPath;
	
	@Then("login with correct password")
	public void loginWithCorrectPassword() {
		try {
			clickElementAndEnterText(passwordPath, propertyFileHandle("sales.password"));
		}
		catch(Exception e) {
			
		}
	}
	
	@FindBy(css="//input[@id='login-button']")
	private WebElement loginButton;
	
	@FindBy(css="//div[@class='app_logo']")
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
}

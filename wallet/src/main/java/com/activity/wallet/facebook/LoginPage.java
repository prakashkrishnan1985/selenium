package com.activity.wallet.facebook;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(id="email")
	public WebElement txtEmail;
	
	@FindBy(id="pass")
	public WebElement txtPassword;
	
	@FindBy(css="[aria-label='Log In']")
	public WebElement btnLogin;
	
	
	public HomePage loginToApplication(Map<String, String> testData) {
		WebDriverWait wait = new WebDriverWait(driver, maxWaitTime);
		wait.until(ExpectedConditions.elementToBeClickable(txtEmail));
		txtEmail.sendKeys(testData.get("userName"));
		txtPassword.sendKeys(testData.get("password"));
		btnLogin.click();	
		return PageFactory.initElements(driver, HomePage.class);
	}

}

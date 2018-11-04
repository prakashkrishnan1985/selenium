package com.activity.wallet.wallethub;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {
	
	WebDriverWait wait;
	
	@FindBy(linkText="Login")
	public WebElement lnkLogin;
	@FindBy(name="em")
	public WebElement txtEmailAddress;
	@FindBy(name="pw1")
	public WebElement txtPassword;
	@FindBy(css=".blue")
	public WebElement btnLogin;
	
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, waitTime);
		
	}
	
	public ProfilePage enterLoginDetails(Map<String, String> testData) {
		wait.until(ExpectedConditions.elementToBeClickable(lnkLogin));
		lnkLogin.click();
		wait.until(ExpectedConditions.elementToBeClickable(txtEmailAddress));
		txtEmailAddress.sendKeys(testData.get("emailAddress"));
		txtPassword.sendKeys(testData.get("password"));
		wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
		btnLogin.click();
		return PageFactory.initElements(driver, ProfilePage.class);
	}

}

package com.activity.wallet.wallethub;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends AbstractPage {
	
	@FindBy(name="em")
	public WebElement txtEmailAdress;
	
	@FindBy(name="pw1")
	public WebElement txtPassword;
	
	@FindBy(name="pw2")
	public WebElement txtConfirmPassword;
	
	@FindBy(css=".btn.blue")
	public WebElement btnJoin;
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	public ProfilePage registerToWebsite(Map<String, String> testData) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.elementToBeClickable(btnJoin));
		txtEmailAdress.sendKeys(testData.get("emailAdress"));
		txtPassword.sendKeys(testData.get("password"));
		btnJoin.click();
		txtConfirmPassword.sendKeys(testData.get("confirmPassword"));
		return PageFactory.initElements(driver, ProfilePage.class);
	}
	
	

}

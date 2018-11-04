package com.activity.wallet.facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {
	WebDriver driver;
	public int maxWaitTime = 60000;
	public int minWaitTime = 60000;
	
	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage initializeHomePage(String url) {
		driver.manage().window().maximize();
		driver.get(url);
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	public LoginPage navigateBackToHomePage(String homePageURL) {
		this.driver.navigate().to(homePageURL);
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	public void quitDriver() {
		this.driver.quit();
	}

}

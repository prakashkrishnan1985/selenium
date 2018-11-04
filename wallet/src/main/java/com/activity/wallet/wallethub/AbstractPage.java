package com.activity.wallet.wallethub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.activity.wallet.wallethub.HomePage;

public class AbstractPage {
	
	public WebDriver driver;
	public final int waitTime=60;
	
	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage registrationToApplication(String applicationURL) {
		driver.manage().window().maximize();
		driver.get(applicationURL);
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	
	public HomePage navigateBackToHomePage(String homePageURL) {
		this.driver.navigate().to(homePageURL);
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	public void quitApplication()
	{
		this.driver.quit();
	}
}

package com.activity.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumHelper {
	
	public WebDriver driver;
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public WebDriver setDriver(String browserType) {
		if(browserType.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
			this.driver = new ChromeDriver(options);
			return this.driver;
		}
		return null;
	}
	
	public static void sleepWait(int duration) {
		try {
			Thread.sleep(duration);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}

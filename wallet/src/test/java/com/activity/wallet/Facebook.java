package com.activity.wallet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.activity.helpers.JavaHelper;
import com.activity.helpers.SeleniumHelper;
import com.activity.wallet.facebook.AbstractPage;
import com.activity.wallet.facebook.LoginPage;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Facebook {
	SeleniumHelper seleniumHelper = new SeleniumHelper();
	JavaHelper javaHelper = new JavaHelper();
	AbstractPage abstractPage;
	LoginPage loginPage;
	WebDriver driver;
	
	@BeforeClass
	@Parameters({"browserType", "environment"})
	public void setUp(String browserType, String environment) throws FileNotFoundException, IOException {
		driver = seleniumHelper.setDriver(browserType);
		Properties environmentDetails = javaHelper.readProperty(environment);
		abstractPage = new AbstractPage(driver);
		loginPage = abstractPage.initializeHomePage(environmentDetails.getProperty("applicationURL"));		
	}
	
	@Test(description = "Post status message Hello World")
	public void postMessage() throws InterruptedException, JsonIOException, JsonSyntaxException, FileNotFoundException {
		Map<String, String> testData = javaHelper.readJson("Facebook.json", "postMessage");
		long number = javaHelper.randomNumberGenerator();
		Assert.assertEquals(loginPage.loginToApplication(testData)
				 .enterStatusMessage("testAutomation"+number).getPostMessage(), "testAutomation"+number);;
	}
	
	@AfterClass
	public void tearDown() {
		abstractPage.quitDriver();
	}
	

}

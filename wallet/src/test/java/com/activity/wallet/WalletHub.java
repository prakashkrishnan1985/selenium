package com.activity.wallet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.activity.helpers.JavaHelper;
import com.activity.helpers.SeleniumHelper;
import com.activity.wallet.wallethub.AbstractPage;
import com.activity.wallet.wallethub.HomePage;
import com.activity.wallet.wallethub.RegistrationPage;
import com.github.javafaker.Faker;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import junit.framework.Assert;

public class WalletHub {
	
	SeleniumHelper seleniumHelper = new SeleniumHelper();
	JavaHelper javaHelper = new JavaHelper();
	AbstractPage abstractPage;
	RegistrationPage registrationPage;
	HomePage homePage;
	WebDriver driver;
	Properties environmentDetails;
	
	@BeforeClass
	@Parameters({"browserType", "environment"})
	public void setUp(String browserType, String environment) throws FileNotFoundException, IOException {
		driver = seleniumHelper.setDriver(browserType);
		environmentDetails = javaHelper.readProperty(environment);
		abstractPage = new AbstractPage(driver);
		homePage = abstractPage.registrationToApplication(environmentDetails.getProperty("applicationURL"));	
	}
	
	@Test(description="Testing insurance App")
	public void testInsuranceApplication() throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		Map<String, String> testData = javaHelper.readJson("Wallet.json", "testInsuranceApplication");
		Faker faker = new Faker();
		String reviewComment=faker.lorem().sentence(50);	
		Assert.assertEquals(homePage.selectRating(4)
									.selectPolicyType("Health")
									.selectStarRatings(Integer.valueOf(testData.get("rating")))
									.AddOptionalReviewAndSubmit(reviewComment)
									.enterLoginDetails(testData)
									.getReviewText(), 
						     reviewComment);
		
	}

	@AfterClass
	public void cleanUp() {
		abstractPage.quitApplication();
	}
}

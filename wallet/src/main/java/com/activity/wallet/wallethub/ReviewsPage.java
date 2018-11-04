package com.activity.wallet.wallethub;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.activity.helpers.SeleniumHelper;

public class ReviewsPage extends AbstractPage {
	public String cssPolicyType=".drop-el [data-target=";
	@FindBy(className="dropdown-title")
	public WebElement ddlPolicyType;
	@FindBy(css="[name='review']")
	public WebElement txtYourReview;
	@FindBy(css="[value='Submit']")
	public WebElement btnSubmit;
	@FindBy(className="bf-icon-star-empty")
	List<WebElement> icnStars;
	
	WebDriverWait wait;
	public ReviewsPage(WebDriver driver){
		super(driver);
		wait = new WebDriverWait(driver, waitTime);

	}
	
	public ReviewsPage selectPolicyType(String policyType) {
		wait.until(ExpectedConditions.elementToBeClickable(ddlPolicyType));
		ddlPolicyType.click();
		//Not using Page factory here to facilitate the selection of the policy type based on the inputs
		//Though this can be hard coded as a locator if the selection is only "Health"
		cssPolicyType = cssPolicyType+"'"+policyType+"']";
		WebElement optPolicyType = driver.findElement(By.cssSelector(cssPolicyType));
		wait.until(ExpectedConditions.elementToBeClickable(optPolicyType));
		optPolicyType.click();		
		return PageFactory.initElements(driver, ReviewsPage.class);
	}
	
	public ReviewsPage selectStarRatings(int stars) {
		wait.until(ExpectedConditions.elementToBeClickable(icnStars.get(1)));
		SeleniumHelper.sleepWait(2000);
		icnStars.get(stars).click();		
		return PageFactory.initElements(driver, ReviewsPage.class);
	}
	
	public LoginPage AddOptionalReviewAndSubmit(String reviewData) {
		wait.until(ExpectedConditions.elementToBeClickable(txtYourReview));
		txtYourReview.clear();
		txtYourReview.sendKeys(reviewData);
		wait.until(ExpectedConditions.elementToBeClickable(btnSubmit));
		btnSubmit.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}

}

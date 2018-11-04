package com.activity.wallet.wallethub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends AbstractPage {
	
	WebDriverWait wait;
	
	@FindBy(css=".profilenav [href*='activity']")
	public WebElement lnkActivity;
	
	@FindBy(css=".snippet-first [itemprop='description']")
	public WebElement snipFirstReview;
	
	public ProfilePage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, waitTime);
	}
	
	public String getReviewText() {
		wait.until(ExpectedConditions.elementToBeClickable(lnkActivity));
		System.out.println(snipFirstReview.getText());
		return snipFirstReview.getText();	
	}

}

package com.activity.wallet.wallethub;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {
	
	
	@FindBy(css=".wh-rating.rating_4_5")
	public WebElement spnRating;
	@FindBy(className="wh-rating-choices-holder")
	public WebElement divRating;
	@FindBy(css=".wh-rating-choices-holder a")
	public List<WebElement> lstHoverLinks;	
	@FindBy(className="login")
	public WebElement lnkLogin;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public ReviewsPage selectRating(int rating) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOf(lnkLogin));
		Actions action = new Actions(driver);
		action.moveToElement(spnRating).build().perform();
		lstHoverLinks.get(rating).click();
		return PageFactory.initElements(driver, ReviewsPage.class);
	}
	
	
	
	

}

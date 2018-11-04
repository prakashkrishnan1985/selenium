package com.activity.wallet.facebook;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {
	
	@FindBy(css="[title='Write something here...']")
	public WebElement plholdPost;
	
	@FindBy(css="[role='textbox']")	
	public WebElement txtStatusMessage;
	
	@FindBy(css="[data-testid='react-composer-post-button']")
	public WebElement btnShare;
	
	@FindBy(css="[data-ad-preview='message']")
	public List<WebElement> divPostedMessage;
	
	@FindBy(name="q")
	public WebElement txtSearch;

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public HomePage enterStatusMessage(String messageToPost) {
		WebDriverWait wait = new WebDriverWait(driver, maxWaitTime);
		wait.until(ExpectedConditions.elementToBeClickable(plholdPost));
		plholdPost.click();
		wait.until(ExpectedConditions.elementToBeClickable(txtStatusMessage));
		txtStatusMessage.click();
		txtStatusMessage.sendKeys(messageToPost);
		wait.until(ExpectedConditions.elementToBeClickable(btnShare));
		btnShare.click();
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	public String getPostMessage() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, maxWaitTime);
		wait.until(ExpectedConditions.elementToBeClickable(txtSearch));
		List<WebElement> messageList = driver.findElements(By.cssSelector("[data-ad-preview='message']"));
		return messageList.get(0).getText();
	}
	


}

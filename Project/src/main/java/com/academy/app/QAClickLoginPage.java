package com.academy.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QAClickLoginPage {

	WebDriver driver;
	
	public QAClickLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user_email")
	WebElement emailAddress;
	
	@FindBy(id = "user_password")
	WebElement password;
	
	@FindBy(css = "[value='Log In']")
	WebElement loginButton;
	
	public WebElement getEmailAddress() {
		return emailAddress;
	}
	
	public WebElement getPassword() {
		return password;
	}
	
	public WebElement getLoginButton() {
		return loginButton;
	}
}

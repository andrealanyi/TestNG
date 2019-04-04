package com.academy.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QAClickLandingPage {

	public WebDriver driver;

	@FindBy(css = "a[href*='sign_in']")
	WebElement loginLink;
	
//	@FindBy(xpath = "//h2[contains(text(),'Featured Courses')]")
//	WebElement featuredCourses;
	
	@FindBy(css = ".text-center>h2")
	WebElement pageTitle;
	
	@FindBy(css = ".nav.navbar-nav.navbar-right")
	WebElement navBar;
	
	public QAClickLandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getLoginLink() {
		return loginLink;
	}
	
	public WebElement getPageTitle() {
		return pageTitle;
	}
	
	public WebElement getNavBar() {
		return navBar;
	}
	
//	@FindBy(tagName = "a") List<WebElement> links;
//	 @FindBy(how = How.TAG_NAME, using = "a") List<WebElement> links;
}

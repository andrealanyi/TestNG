package com.academy.app;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class HomePageTest extends Base{
	
	final static Logger log = LogManager.getLogger(HomePageTest.class.getName());
	

	@BeforeMethod
	public void setUp() throws IOException{
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
	}
	
	@Test(dataProvider="getData")
	public void validateEmail(String emailAddress, String password) {
		
		//inheritance OR
		//create object of that class and invoke methods of it
		QAClickLandingPage home = new QAClickLandingPage(driver);
		home.getLoginLink().click();
		log.info("Clicked on login link");
		
		QAClickLoginPage login = new QAClickLoginPage(driver);
		login.getEmailAddress().sendKeys(emailAddress);
		log.info("Entered email address");
		login.getPassword().sendKeys(password);
		log.info("entered password");
		login.getLoginButton().click();
		log.info("Clicked on Go button");
		log.info("Test finished with parameters: " + emailAddress + " | " + password);
	}
	
	@DataProvider
	public Object[][] getData() {
		//row stands for how many different data types test should run
		// column stands for how many values per each test
		Object[][] data = new Object[2][2];
		data[0][0] = "nonrestricteduser@email.com";
		data[0][1] = "pass";
		
		data[1][0] = "restricteduser@email.com";
		data[1][1] = "password";
		
		return data;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
		driver=null;
		log.info("Closed and quit the browser");
	}
}

package com.academy.app;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class validateNavbarTest extends Base {

	final static Logger log = LogManager.getLogger(validateNavbarTest.class);
	
	@BeforeTest
	public void setUp() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
	}

	@Test
	public void validateNavBar() throws IOException {
		QAClickLandingPage home = new QAClickLandingPage(driver);
//		Assert.assertTrue(home.getNavBar().isDisplayed());
		Assert.assertFalse(home.getNavBar().isDisplayed());
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
		driver=null;
		log.info("Closed and quit the browser");
	}
}

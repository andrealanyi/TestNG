package com.academy.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Base {
	// browser invocation goes to one place

	public static WebDriver driver;
	public Properties prop;
	final static Logger log = LogManager.getLogger(Base.class);
	
	public WebDriver initializeDriver() throws IOException {

		//read the property file
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"/Users/Yes/eclipse-workspace/Project/resources/data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			// execute chrome driver
			System.setProperty("webdriver.chrome.driver", "/Users/Yes/eclipse-workspace/drivers/chromedriver");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/Yes/eclipse-workspace/drivers/geckodriver");
			driver = new FirefoxDriver();
		} else if (browserName.equals("safari")) {
			System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
			driver = new SafariDriver();
		}
		//it reflects to all the test cases
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenshot(String result) throws IOException {
		//we want this to execute if the test fails
		
		File rootDir = File.listRoots()[0];
		File dir = new File(new File(new File(new File(rootDir, "Users"), "Yes"), "Desktop"), "Mixed");
		if (!dir.exists()){
		    dir.mkdirs();
		}
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		log.info("taken screenshot");
		FileUtils.copyFile(src, new File(dir + "/" + result + "screenshot.png"));
		log.info("written it to: " + dir.getPath());
		
//		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(src, new File("/Users/eclipse-workspace/Project/screenshots/" + result + "screenshot.png"));
	}
}

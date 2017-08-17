package com.test.automation.uiAutomation.homepage;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiAction.HomePage;

import junit.framework.Assert;

public class TC001_VerifyLoginWithInvalidCredentials extends TestBase {
	public static final Logger log = Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());

	HomePage homepage;

	@BeforeTest
	public void setUp() {
		init();

	}

	@Test
	public void verifyLoginWithInvalidCredentials() {
		log.info("=============Starting test===============");
		homepage = new HomePage(driver);
		homepage.loginToApplication("test@gmail.com", "pass123");
		Assert.assertEquals(homepage.getInvalidLoginText(), "Authentication failed.");
		log.info("=============Finished test===============");
	}

	@AfterTest
	public void endTest() {
		driver.close();
	}
}

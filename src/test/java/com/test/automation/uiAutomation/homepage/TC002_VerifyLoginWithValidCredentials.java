package com.test.automation.uiAutomation.homepage;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiAction.HomePage;

import junit.framework.Assert;

public class TC002_VerifyLoginWithValidCredentials extends TestBase {
	public static final Logger log = Logger.getLogger(TC002_VerifyLoginWithValidCredentials.class.getName());

	HomePage homepage;

	@BeforeTest
	public void setUp() {
		init();

	}

	@Test
	public void verifyLoginWithValidCredentials() {
		log.info("=============Starting test===============");
		homepage = new HomePage(driver);
		homepage.loginToApplication("dhakeparag3@gmail.com", "123456");
		Assert.assertEquals(homepage.getInvalidLoginText(), "Authentication failed.");
		log.info("=============Finished test===============");
	}

	@AfterTest
	public void endTest() {
		driver.close();
	}
}

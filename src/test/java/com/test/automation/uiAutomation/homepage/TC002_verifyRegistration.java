package com.test.automation.uiAutomation.homepage;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiAction.HomePage;

import junit.framework.Assert;

public class TC002_verifyRegistration extends TestBase {
	public static final Logger log = Logger.getLogger(TC002_verifyRegistration.class.getName());

	HomePage homepage;
	String firstname = "test";
	String lastname = "lastname";
	String email = "tesst@gamil.com";
	String password = "tsest";

	@BeforeTest
	public void setUp() {
		init();

	}

	@Test
	public void testLogin() {
		homepage = new HomePage(driver);
		homepage.registeredUser(firstname, lastname, email, password);
		Assert.assertEquals(homepage.getSucessRegistrationMessage(), "To continue, let us know you're not a robot.");
	}

	@AfterTest
	public void endTest() {
		driver.quit();
	}
}

package com.test.automation.uiAutomation.uiAction;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public static final Logger log = Logger.getLogger(HomePage.class.getName());

	WebDriver driver;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='login']")
	WebElement SignIn;
	@FindBy(id = "email")

	WebElement lgoinEmailAddress;
	@FindBy(id = "passwd")
	WebElement loginPassword;

	@FindBy(id = "SubmitLogin")
	WebElement submitButton;

	@FindBy(xpath = "//div[@class='alert alert-danger']/ol/li")
	WebElement authancatonFailed;

	public void loginToApplication(String emailAddress, String password) {
		SignIn.click();
		log.info("clicking on sigin and object is :-" + SignIn.toString());
		lgoinEmailAddress.sendKeys(emailAddress);
		log.info("enterd email address :-" + emailAddress + "and objact is" + lgoinEmailAddress.toString());
		loginPassword.sendKeys(password);
		log.info("enterd password :-" + password + "and objact is" + loginPassword.toString());
		submitButton.click();
		log.info("clicking on submit butoon and object is :-" + submitButton.toString());
	}

	public String getInvalidLoginText() {
		log.info("error message :-" + authancatonFailed.getText());
		return authancatonFailed.getText();
	}
}

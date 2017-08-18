package com.test.automation.uiAutomation.uiAction;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public static final Logger log = Logger.getLogger(HomePage.class.getName());

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
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

	@FindBy(id = "PreviewFrame")
	WebElement homepageifreme;
	@FindBy(id = "customer_register_link")
	WebElement signUpLink;
	@FindBy(id = "FirstName")
	WebElement firstname;
	@FindBy(id = "LastName")
	WebElement lastname;
	@FindBy(id = "Email")
	WebElement email;
	@FindBy(id = "CreatePassword")
	WebElement password;
	@FindBy(xpath = ".//*[@id='create_customer']/p/input")
	WebElement createAccount;
	@FindBy(xpath = ".//*[@id='MainContent']/div/p")
	WebElement regsitrationMessage;

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

	public void registeredUser(String firstname, String lastname, String email, String password) {
		driver.switchTo().frame(homepageifreme);
		log.info("swiching to home page frame:-" + homepageifreme.toString());
		signUpLink.click();
		log.info("click on sign up link:-" + signUpLink.toString());
		this.firstname.sendKeys(firstname);
		log.info("entering data to firstname:-" + firstname.toString());
		this.lastname.sendKeys(lastname);
		log.info("entering data to lastname:-" + lastname.toString());
		this.email.sendKeys(email);
		log.info("entering data to email:-" + email.toString());
		this.password.sendKeys(password);
		log.info("entering data to password:-" + password.toString());
		createAccount.click();
		log.info("click on create account link:-" + createAccount.toString());

	}

	public String getSucessRegistrationMessage() {

		log.info("sucess registration message  message :-" + regsitrationMessage.getText());
		return regsitrationMessage.getText();
	}

}

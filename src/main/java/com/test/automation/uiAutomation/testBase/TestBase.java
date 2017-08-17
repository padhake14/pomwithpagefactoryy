package com.test.automation.uiAutomation.testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	public WebDriver driver;
	String url = "http://automationpractice.com/index.php";
	String browser = "chrome";
	
	

	public void init() {
		selectBrowser(browser);
		getUrl(url);
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}

	public WebDriver selectBrowser(String browser) {
		if (browser.equals("chrome") || browser.equals("CHROME")) {
			System.setProperty("webdriver.chrome.driver", "/home/parag/Music/chromedriver");
			log.info("creating object of  :- "+browser);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
		} else if (browser.equals("firefox") || browser.equals("FIREFOX")) {
			System.setProperty("webdriver.gecko.driver", "/home/parag/Music/geckodriver");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
		}
		return null;

	}

	public void getUrl(String url) {
		driver.get(url);
		log.info("Navgatig to:" +url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
}

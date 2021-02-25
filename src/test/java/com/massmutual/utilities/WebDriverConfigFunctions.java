package com.massmutual.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

public class WebDriverConfigFunctions extends LoadPropertiesFiledata {

	public WebDriver driver;

	/**
	 * Below method will launch browser and open application url based on data
	 * mentioned in properties file
	 * @author vivek
	 */
	public void launchBrowserAndApplication() {
		try {
			String browserName = getBrower();
			String driverPath = getDriverPath();

			if (browserName.equals("IExplore")) {
				System.setProperty("webdriver.ie.driver", driverPath + "\\IEDriverServer32Bit.exe");
				driver = new InternetExplorerDriver();
			} else if (browserName.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver", driverPath + "\\geckodriver64Bit.exe");
				driver = new FirefoxDriver();
			} else if (browserName.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", driverPath + "\\chromedriver.exe");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("['start-maximized']");
				driver = new ChromeDriver();
			} else if (browserName.equals("Edge")) {
				System.setProperty("webdriver.edge.driver", driverPath + "\\MicrosoftWebDriver.exe");
				driver = new EdgeDriver();
			} else {
				Reporter.log("Invalid browser name, Please check browser name.", false);
			}
			driver.get(getApplicationUrl());
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			Reporter.log("Invalid browser name, Please check browser name.", false);
		}
	}

}

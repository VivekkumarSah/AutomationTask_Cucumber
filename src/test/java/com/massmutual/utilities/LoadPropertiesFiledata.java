package com.massmutual.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

import org.testng.Reporter;

public class LoadPropertiesFiledata {
	private Properties properties;
	private final String propertyFilePath = "config/application.properties";

	public LoadPropertiesFiledata() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			properties.load(reader);
			reader.close();
		} catch (Exception e) {
			Reporter.log("Configuration.properties not found at " + propertyFilePath, false);
		}
	}

	/**
	 * Below method will return the browser name mentioned in properties file
	 * @return Browser Name
	 * @author vivek
	 */
	public String getBrower() {
		String browser = properties.getProperty("browser");
		try {
			if (browser != null) {
				Reporter.log("Following browser name " + browser + "specified in the properties file ", true);
			} else {
				Reporter.log("browser name specified in the properties file is is not found", false);
			}
		} catch (Exception e) {
			Reporter.log("browser name specified in the properties file is is not found", false);
		}
		return browser;
	}

	/**
	 * Below method will return the driver location mentioned in properties file
	 * @return driver location
	 * @author vivek
	 */
	public String getDriverPath() {
		String driverpath = properties.getProperty("driverpath");
		try {
			if (driverpath != null) {
				Reporter.log("Following driver path " + driverpath + " specified in the properties file", true);
			} else {
				Reporter.log("driverpath name specified in the properties file is not found", false);
			}
		} catch (Exception e) {
			Reporter.log("driverpath name specified in the properties file is not found", false);
		}
		return driverpath;
	}

	/**
	 * Below method will return the application url mentioned in properties file
	 * @return
	 * @author vivek
	 */
	public String getApplicationUrl() {
		String appUrl = properties.getProperty("applicationUrl");
		try {
			if (appUrl != null) {
				Reporter.log("Following application Url " + appUrl + " specified in the properties file found", true);
			} else {
				Reporter.log("Application url specified in the properties file is not found", false);
			}
		} catch (Exception e) {
			Reporter.log("Application url specified in the properties file is not found", false);
		}
		return appUrl;
	}
	
	/**
	 * Below method will return the screenshot Location mentioned in properties file
	 * @return
	 * @author vivek
	 */
	public String getScreenshotLocation() {
		String screenshotLocation = properties.getProperty("screenshotLocation");
		try {
			if (screenshotLocation != null) {
				Reporter.log("Following location " + screenshotLocation + " specified in the properties file found", true);
			} else {
				Reporter.log("Location specified in the properties file is not found", false);
			}
		} catch (Exception e) {
			Reporter.log("Location specified in the properties file is not found", false);
		}
		return screenshotLocation;
	}
}

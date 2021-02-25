package com.massmutual.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.massmutual.utilities.WebDriverConfigFunctions;

public class BaseTestPage extends WebDriverConfigFunctions {

	/**
	 * Below method will launch browser and open application url based on data
	 * @author vivek
	 */
	public void click(WebElement element, String msg) {
		try {
			if (element.isDisplayed()) {
				element.click();
				Assert.assertTrue("Able to click on" + msg + " successfully", true);
			} else {
				Assert.assertTrue("Unable to click on" + msg + " element", false);
			}
		} catch (Exception e) {
			Reporter.log("Unable to click on" + msg + " element", false);
		}
	}

	/**
	 * Below method used to enter text Parameter :webelement ,data and string message
	 * @author vivek
	 */
	public void enter(WebElement element, String data, String msg) {
		try {
			if (element.isDisplayed()) {
				element.sendKeys(data);
				Assert.assertTrue("Able to update " + msg + " field successfully", true);
			} else {
				Assert.assertTrue("Unable to update " + msg + " successfully", false);
			}
		} catch (Exception e) {
			Reporter.log("Unable to update " + msg + " successfully", false);
		}
	}

}

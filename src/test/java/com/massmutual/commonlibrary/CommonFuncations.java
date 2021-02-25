package com.massmutual.commonlibrary;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import com.massmutual.utilities.LoadPropertiesFiledata;

public class CommonFuncations extends LoadPropertiesFiledata {

	/**
	 * Below method will be used for comparing list and string arrays
	 * @param lists
	 * @param validateData
	 * @param splitBy
	 * @return true/false
	 * @author vivek
	 */
	public static boolean compareListAndStringArrays(List<String> lists, String validateData, String splitBy) {
		String[] elementLists = validateData.split(splitBy);
		String textResult = "";
		boolean flag = true;
		try {
			for (int i = 0; i < lists.size(); i++) {
				if (elementLists[i].equals(" ")) {
					elementLists[i] = "";
				}
				if (!elementLists[i].trim().equals(lists.get(i).trim())) {
					textResult = textResult + "," + lists.get(i);
					flag = false;
				}
			}
			if (flag) {
				Reporter.log("Following Options Matched" + validateData, true);
			} else {
				Reporter.log("Following data" + textResult + " Not Matched", false);
			}
		} catch (Exception e) {
			Reporter.log("Following data" + textResult + " Not Matched", false);
		}
		return flag;
	}

	/**
	 * below method will be use for replace character from string
	 * @param data
	 * @param fromData
	 * @param toData
	 * @return
	 * @author vivek
	 */
	public static String replaceData(String strdata, String fromCharacter, String toCharacter) {
		String strAfterReplace = null;
		try {
			strAfterReplace = strdata.replace(fromCharacter, toCharacter);
		} catch (Exception e) {
			Reporter.log("Unable to replace value", false);
		}
		return strAfterReplace;
	}
	
	/**
	 * Below method will take the screenshot and store in img folder
	 * @param driver
	 */
	public void takeScreenShot(WebDriver driver) {
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String timeStamp = getTimeStamp();
			String location = getScreenshotLocation();
			String screenShotLocation = location + timeStamp + ".png";
			FileUtils.copyFile(screenShot, new File(screenShotLocation));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Below method will give us date with current time stamp
	 * @return
	 */
	public String getTimeStamp() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String currentTimeStamp = dateFormat.format(date);
		return currentTimeStamp;
	}

}

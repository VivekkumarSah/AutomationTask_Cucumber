package com.massmutual.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.massmutual.commonlibrary.CommonFuncations;
import org.junit.Assert;

public class ValuesPage extends BaseTestPage {

	public ValuesPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "link_ValuePageLink")
	private WebElement link_ValuePage;

	@FindBy(id = "lbl_ttl_val")
	private WebElement label_TotalBalance;

	@FindBy(id = "txt_ttl_val")
	private WebElement label_TotalBalanceAmmount;

	@FindBy(xpath = "//*[Starts-with(@id,'txt_val'))")
	private List<WebElement> list_ValuesAmmount;

	@FindBy(xpath = "//*[Starts-with(@id,'lbl_val'))")
	private List<WebElement> list_Labels_Values;
	
	/**
	 * Below method will navigate to value page
	 * @author vivek
	 */
	public void navigateToValuePage() {
		link_ValuePage.click();
	}

	/**
	 * Below method will verify counts and then verify values label present in right side
	 * @param validateData
	 * @author vivek
	 */
	public void verifyCountAndlabelsName(String validateData) {
		boolean flag = false;
		try {
			List<WebElement> lists = list_Labels_Values;
			List<String> lablesText = new ArrayList<String>();
			for (int i = 0; i < lists.size(); i++) {
				lablesText.add(lists.get(i).getText().trim());
			}
			if(lists.size()==lablesText.size()) {
				flag = CommonFuncations.compareListAndStringArrays(lablesText, validateData, ",");
				if (flag) {
					Reporter.log("Labels name are matching", true);
				} else {
					Reporter.log("Labels name are not matching", false);
				}
			}else {
				Reporter.log("Expected value count not present", false);
			}	
		} catch (Exception e) {
			Reporter.log("Values labels count is not matching", false);
		}

	}

	/**
	 * Below method will verify all amount present in UI should be greater than zero
	 * @param val
	 * @author vivek
	 */
	public void verifyValueGreaterthanZero(Integer value) {
		try {
			List<WebElement> listAmount = list_ValuesAmmount;
			List<WebElement> listLabels = list_Labels_Values;
			for (int i = 0; i < listAmount.size(); i++) {
				if (Integer.parseInt(listAmount.get(i).getAttribute("value")) > value.intValue()) {
					Assert.assertTrue("For Label=" + listLabels.get(i).getAttribute("name") + " Value is "
							+ listAmount.get(i).getAttribute("value") + "  is greater than 0 ", true);
				} else {
					Assert.assertTrue("For Label=" + listLabels.get(i).getAttribute("name") + " Value is "
							+ listAmount.get(i).getAttribute("value") + "  is not greater than 0 ", false);
				}
			}
		} catch (Exception e) {
			Reporter.log("Amount value is not greater then 0", false);
		}
	}

	/**
	 * Below method will verify the sum of balance
	 * @author vivek
	 */
	public void verifySumOfBalance() {
		try {
			List<WebElement> listvalue = list_ValuesAmmount;
			int totalValue = 0;
			for (WebElement elementlist: listvalue) {
				String amount = elementlist.getAttribute("value");
				String amountAfterReplace = CommonFuncations.replaceData(amount,"$","");
				totalValue = totalValue + Integer.parseInt(amountAfterReplace);
			}
			String totalUIbalance = label_TotalBalanceAmmount.getAttribute("value");
			if (Integer.parseInt(totalUIbalance.replace("$", "")) == totalValue) {
				Assert.assertTrue("Total  value is " + totalValue + " instead of "
						+ Integer.parseInt(totalUIbalance.replace("$", "")), true);
			} else {
				Assert.assertTrue("Total  value is " + totalValue + " instead of "
						+ Integer.parseInt(totalUIbalance.replace("$", "")), false);
			}
		} catch (Exception e) {
			Reporter.log("Sum validation failed", false);
		}
	}

	/**
	 * Below method will verify the currency format
	 * @author vivek
	 */
	public void verifyCurrencyFormat() {
		try {
			List<WebElement> listAmmount = list_ValuesAmmount;
			List<WebElement> listlabelsValue = list_Labels_Values;
			for (int i = 0; i < listAmmount.size(); i++) {
				if(listAmmount.get(i).getAttribute("value").contains("$")) {
					if (listAmmount.get(i).getAttribute("value").indexOf("$") == 0) {
						Assert.assertTrue("For Field=" + listlabelsValue.get(i).getAttribute("name") + " Value is "
								+ listAmmount.get(i).getAttribute("value") + "  is in US currency format ", true);
					} else {
						Assert.assertTrue("For Field=" + listlabelsValue.get(i).getAttribute("name") + " Value is "
								+ listAmmount.get(i).getAttribute("value") + "  is not in US currency format ", false);
					}
				}else {
					Reporter.log("$ sign is missing from the ammount", false);
				}
				
			}} catch (Exception e){
				Reporter.log("$ sign is missing from the ammount", false);
		}
	}
}

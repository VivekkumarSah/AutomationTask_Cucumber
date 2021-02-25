package com.massmutual.stepdefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyTotalBalance_StepDefinition extends BaseTest_SetpDefinition {

	@When("User navigated to values screen")
	public void user_navigated_to_values_screen() {
		valuesPage.navigateToValuePage();
	}

	@Then("User should be able to see correct count and label text as {string} on the screen")
	public void user_should_be_able_to_see_correct_count_for_appear_in_the_screen(String labelstext) {
		valuesPage.verifyCountAndlabelsName(labelstext);
	}

	@Then("Verify all amount present on the screen should be greater than {int}")
	public void verify_all_ammount_present_on_the_screen_should_be_greater_than_zero(Integer intValue) {
		valuesPage.verifyValueGreaterthanZero(intValue);
	}

	@Then("Verify currency formate for all amounts")
	public void verify_currency_formate_for_all_ammount() {
		valuesPage.verifyCurrencyFormat();
	}

	@Then("Verify total balance match with the sum of the values amount")
	public void verify_total_balance_matches_the_sum_of_the_values() {
		valuesPage.verifySumOfBalance();
	}
}

package com.massmutual.stepdefinition;

import io.cucumber.java.en.Given;

public class Background_StepDefinition extends BaseTest_SetpDefinition {

	@Given("Reading data from proerties file and launching browser and opening application")
	public void reading_data_from_proerties_file_and_launching_browser_and_exercise_application() {
		webDriverConfig.launchBrowserAndApplication();
	}
}

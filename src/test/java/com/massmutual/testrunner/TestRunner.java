package com.massmutual.testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "featureFile/VerifyTotalBalance.feature",
		glue = {"com.massmutual.stepdefinition","com.massmutual.utilities"},
		plugin = {"pretty","html:target/HtmlReports"},
		monochrome = true
)
public class TestRunner {

}

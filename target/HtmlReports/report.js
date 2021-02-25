$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:featureFile/VerifyTotalBalance.feature");
formatter.feature({
  "name": "Verifying the total balance and formate for currencies",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Verifying the total balance and formate for currencies present in amount field",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User navigated to values screen",
  "keyword": "When "
});
formatter.step({
  "name": "User should be able to see correct count and label text as \"\u003cValueslabels\u003e\" on the screen",
  "keyword": "Then "
});
formatter.step({
  "name": "Verify all amount present on the screen should be greater than 0",
  "keyword": "And "
});
formatter.step({
  "name": "Verify currency formate for all amounts",
  "keyword": "And "
});
formatter.step({
  "name": "Verify total balance match with the sum of the values amount",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Valueslabels"
      ]
    },
    {
      "cells": [
        "Value 1,Value 2,Value 3,Value 4, Value 5"
      ]
    }
  ]
});
formatter.background({
  "name": "Launching browser and application",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "Reading data from proerties file and launching browser and opening application",
  "keyword": "Given "
});
formatter.match({
  "location": "com.massmutual.stepdefinition.Background_StepDefinition.reading_data_from_proerties_file_and_launching_browser_and_exercise_application()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verifying the total balance and formate for currencies present in amount field",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User navigated to values screen",
  "keyword": "When "
});
formatter.match({
  "location": "com.massmutual.stepdefinition.VerifyTotalBalance_StepDefinition.user_navigated_to_values_screen()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be able to see correct count and label text as \"Value 1,Value 2,Value 3,Value 4, Value 5\" on the screen",
  "keyword": "Then "
});
formatter.match({
  "location": "com.massmutual.stepdefinition.VerifyTotalBalance_StepDefinition.user_should_be_able_to_see_correct_count_for_appear_in_the_screen(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify all amount present on the screen should be greater than 0",
  "keyword": "And "
});
formatter.match({
  "location": "com.massmutual.stepdefinition.VerifyTotalBalance_StepDefinition.verify_all_ammount_present_on_the_screen_should_be_greater_than_zero(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify currency formate for all amounts",
  "keyword": "And "
});
formatter.match({
  "location": "com.massmutual.stepdefinition.VerifyTotalBalance_StepDefinition.verify_currency_formate_for_all_ammount()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify total balance match with the sum of the values amount",
  "keyword": "And "
});
formatter.match({
  "location": "com.massmutual.stepdefinition.VerifyTotalBalance_StepDefinition.verify_total_balance_matches_the_sum_of_the_values()"
});
formatter.result({
  "status": "passed"
});
});
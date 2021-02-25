Feature: Verifying the total balance and formate for currencies
Background: Launching browser and application
	Given Reading data from proerties file and launching browser and opening application

Scenario Outline:  Verifying the total balance and formate for currencies present in amount field
    When User navigated to values screen 
    Then User should be able to see correct count and label text as "<Valueslabels>" on the screen
    And  Verify all amount present on the screen should be greater than 0
    And  Verify currency formate for all amounts
    And  Verify total balance match with the sum of the values amount
   
  Examples:
  | Valueslabels |
  |Value 1,Value 2,Value 3,Value 4, Value 5|
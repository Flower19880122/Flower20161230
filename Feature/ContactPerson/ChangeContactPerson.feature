
Feature: Title of your feature
	I want to use this template for my feature file
Scenario Outline: Check contact person change function
Given Login into CAM project "<username>" "<password>"
When user open the client page
Then open client change model "<clientname>"
Then Double click the contact person
Then click contact person change button
Then change contact person telephone
Then save the changed telephone
Then check the saved result

Examples:
    | username |password | clientname |
    | 1000001@qq.com | test   | %test%|

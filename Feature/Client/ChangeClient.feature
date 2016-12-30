
Feature: Change client
	I want to check the client change function

Scenario Outline: Check the client change function
Given Login the CAM project "<username>" "<password>"
Then Open client apge
Then Input a client name to search for a client "<client_name>"
Then Load the client from popo-up
Then Click client change button 
Then Chang the email "<newemail>"
Then save the change and confirm
Then Check if the change is saved  "<newemailcheck>"

Examples:
   |username|password|client_name|newemail|newemailcheck|
   |1000001@qq.com|test|%test%|test@qq.com|test@qq.com|

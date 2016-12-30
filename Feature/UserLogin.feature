Feature: User login into the project
Scenario Outline: User login into the project under different conditions
	And user input username "<username>"
	And user input password "<password>"
  And user click login button
 Then user login in sucessfully "<loginsucessfully>"
 

Examples:
    |username|password|loginsucessfully|
    |1000001@qq.com|test|Schreibtisch|
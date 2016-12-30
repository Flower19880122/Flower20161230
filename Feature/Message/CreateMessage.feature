Feature: Create a new message
Scenario Outline: Create new message
Given user login in "<username>" "<password>"
And Go to client page
Then User fill in the mandatory fields of client
Then User click message new button
 Then user select sender
  And user select receiver
	And user input title  "<title>"
	And user input content "<content>"
 Then user click message save button
 Then user click new button again
 And user fill in all the mandatory fields "<submessage_title>" "<submessage_content>"
 Then save the sub message

 
 Examples:
   |username|password|title|content|submessage_title|submessage_content|
   |1000001@qq.com|test|main message1|This is test main message1|sub message1 |This is test sub message1|
   

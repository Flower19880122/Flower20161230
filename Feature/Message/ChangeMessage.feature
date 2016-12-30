
Feature: test message change function
	I want to check message change function

@tag1
Scenario Outline: check message change function
Given Login to the CAM project  "<username>" "<password>"
	And Open client tab 
  And Open new client model
	Then Create a new main message   "<mainmessagetitle>"  "<mainmessagecontent>"
	Then Create a new sub message  "<submessagetitle>"  "<submessageconhtent>"
	Then Select main message and click change button of the main message
  Then Change all the information of the main message "<changmainemessagetitle>" "<changemainmessagecontent>"
  Then click change button of sub message
	Then Change all the information of the sub message "<changsubemessagetitle>" "<changesubmessagecontent>"



Examples:
    |username|password|mainmessagetitle|mainmessagecontent|submessagetitle|submessageconhtent|changmainemessagetitle|changemainmessagecontent|changsubemessagetitle|changesubmessagecontent|
    | 1000001@qq.com | test | test main message|This is test main message|test sub message|This is test sub message|change main message|This is change main message|change sub message|This is change sub message|
   
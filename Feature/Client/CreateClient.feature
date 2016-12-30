Feature: Create a new client
Scenario Outline: Create new client
Given user login in liferay "<username>" "<password>"
Given user click client tab
  Then user click new button
	Then user input name
  Then user input street
  Then user input PLZ
  Then user input city
  Then user input telephone
  Then user save the client
  Then the hint message is alerted "<hintmessage>"
  Then click ok button on the pop-up
  Then click contact person new button
  Then select the anrede
  Then input contactperson name
  Then click cotnactperson save button
  Then click client save button
  Then check client isSaved "<clientsavemessage>"
  Then close the hint message window
  
   Examples:
   |username|password|hintmessage|clientsavemessage|
   |1000001@qq.com|test|Bitte mind. einen Ansprechpartner hinterlegen|Erfolgreich gespeichert!|
package com.haiberg.automation.client.StepDefinition;

import org.junit.Assert;

import org.junit.runners.Suite.SuiteClasses;

import com.haiberg.automation.client.task.CreateClientTask;
import com.haiberg.automation.client.contactperson.task.CreateContactPersonTask;
import com.haiberg.automation.client.message.task.CreateMessageTask;
import com.haiberg.automation.login.task.LoginTask;
import com.haiberg.automation.client.message.testRunner.CreateMessageRunner;
import com.haiberg.automation.login.testRunner.LoginRunner;
import com.haiberg.automation.web.WebBrowser;
import com.haiberg.automation.widget.ClientWidget;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CreateClientStepDefinition {
	CreateMessageTask createmessagetask=new CreateMessageTask();
	CreateMessageRunner CreateMessageRunnerrunner=new CreateMessageRunner();
	CreateClientTask createclienttask=new CreateClientTask();
	CreateContactPersonTask createcontactpersontask=new CreateContactPersonTask();
	LoginTask logintask=new LoginTask();
	LoginRunner loginrunner=new LoginRunner();
	boolean result=true;

	@Given("^user login in liferay \"([^\"]*)\" \"([^\"]*)\"$")
  		public void user_login_in(String username, String password) throws Throwable {
  		loginrunner.setUp();
  	    logintask.InputUsername(username);
  	    logintask.InputPassword(password);
  	    logintask.ClickLoginbutton();
  		}
  	
  	@Given("^user click client tab$")
  	public void user_click_client_tab() throws Throwable {
  		result=createclienttask.ClickClientTab();
  		Assert.assertTrue(result);
  	}
  	
  	@Then("^user click new button$")
  	public void click_new_button() throws Throwable {
          result=createclienttask.ClickClientNewButton();
          Assert.assertTrue(result);
  	}


  	@Then("^user input name$")
  	public void input_name() throws Throwable {
  		result=createclienttask.InputClientName1();
  		Assert.assertTrue(result);
  	}

  	@Then("^user input street$")
  	public void input_street() throws Throwable {
  		result=createclienttask.InputClientStreet();
  		Assert.assertTrue(result);
  	}

  	@Then("^user input PLZ$")
  	public void input_PLZ() throws Throwable {
  		result=createclienttask.InputClientPLZ();
  		Assert.assertTrue(result);
  	}

  	@Then("^user input city$")
  	public void input_city() throws Throwable {
  		result=createclienttask.InputClientCity();
  		Assert.assertTrue(result);
  	}

  	@Then("^user input telephone$")
  	public void input_telephone() throws Throwable {
  		result=createclienttask.InputClientTelephone();
  		Assert.assertTrue(result);
  	}
	
	
	@Then("^user save the client$")
	public void save_the_client() throws Throwable {
	    result=createclienttask.ClickClientSaveButton();
	    Assert.assertTrue(result);
	}
	
	@Then("^the hint message is alerted \"([^\"]*)\"$")
	public void the_hint_message_is_alerted(String contactpersonhintmessage) throws Throwable {
	    result=createclienttask.CheckNoContactPersonHintMessage(contactpersonhintmessage);
	    System.out.println("判断提示消息的结果是："+result);
	    Assert.assertTrue(result);
	    
	}
	

	@Then("^click ok button on the pop-up$")
	public void click_ok_button_on_the_pop_up() throws Throwable {
	    createclienttask.ClickNoContactPersonHintmessageOkbutton();
	}

	@Then("^click contact person new button$")
	public void click_contact_person_new_button() throws Throwable {
		createcontactpersontask.clickNewContatPersonButton();
	}

	@Then("^select the anrede$")
	public void select_the_anrede() throws Throwable {
		createcontactpersontask.selectContactPersonAnrede();
	}

	@Then("^input contactperson name$")
	public void input_contactperson_name() throws Throwable {
		createcontactpersontask.InputContactPersonName();;
	}

	@Then("^click cotnactperson save button$")
	public void click_cotnactperson_save_button() throws Throwable {
		createcontactpersontask.ClickContactPersonSaveButton();
	}
	
	@Then("^click client save button$")
	public void click_client_save_button(){
		createclienttask.ClickClientSaveButton();
	}
	
	@Then("^check client isSaved \"([^\"]*)\"$")
	public void check_client_isSaved(String clientsavemessage){
		result=createclienttask.CheckClientSaved(clientsavemessage);
		Assert.assertTrue(result);
	}
	
	@Then("^close the hint message window$")
	public void close_the_hint_message_window(){
		result=createclienttask.ClickClientSavedOKbutton();
		Assert.assertTrue(result);
		WebBrowser.closeBrowser();
	}

}

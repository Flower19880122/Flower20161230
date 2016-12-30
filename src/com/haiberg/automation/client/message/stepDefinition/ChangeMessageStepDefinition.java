package com.haiberg.automation.client.message.stepDefinition;

import com.haiberg.automation.client.message.task.ChangeMessageTask;

import com.haiberg.automation.client.task.CreateClientTask;
import com.haiberg.automation.client.message.task.CreateMessageTask;
import com.haiberg.automation.login.task.LoginTask;
import com.haiberg.automation.client.message.testRunner.CreateMessageRunner;
import com.haiberg.automation.login.testRunner.LoginRunner;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ChangeMessageStepDefinition {
	
	CreateMessageTask createmessagetask=new CreateMessageTask();
	CreateMessageRunner CreateMessageRunnerrunner=new CreateMessageRunner();
	CreateClientTask createclienttask=new CreateClientTask();
	ChangeMessageTask changemessagetask=new ChangeMessageTask();
	LoginTask logintask=new LoginTask();
	LoginRunner loginrunner=new LoginRunner();
	boolean result=true;
	
	@Given("^Login to the CAM project  \"([^\"]*)\" \"([^\"]*)\"$")
	public void login_to_the_CAM_project(String username, String password) throws Throwable {
		//loginrunner.setUp();
	    logintask.InputUsername(username);
	    logintask.InputPassword(password);
	    logintask.ClickLoginbutton();
	}

	@Given("^Open client tab$")
	public void open_client_tab() throws Throwable {
	    createclienttask.ClickClientTab();
	}

	@Given("^Open new client model$")
	public void open_new_client_model() throws Throwable {
		createclienttask.ClickClientNewButton();
	}

	@Then("^Create a new main message   \"([^\"]*)\"  \"([^\"]*)\"$")
	public void create_a_new_main_message(String messagetitle, String messagecontent) throws Throwable {
		changemessagetask.ClickMessageNewButton();
		changemessagetask.FilledMessageField(messagetitle, messagecontent);
	}

	@Then("^Create a new sub message  \"([^\"]*)\"  \"([^\"]*)\"$")
	public void create_a_new_sub_message(String messagetitle, String messagecontent) throws Throwable {
		changemessagetask.ClickMessageNewButton();
		changemessagetask.FilledMessageField(messagetitle, messagecontent);
	}

	@Then("^Select main message and click change button of the main message$")
	public void select_main_message_and_click_change_button_of_the_main_message() throws Throwable {
		changemessagetask.SelectMainMessage();
		changemessagetask.ClickMessageChangeButton();
	}

	@Then("^Change all the information of the main message \"([^\"]*)\" \"([^\"]*)\"$")
	public void change_all_the_information_of_the_main_message(String messagetitle, String messaegcontent) throws Throwable {
		changemessagetask.ChangeMessageField(messagetitle,messaegcontent);
	}

	@Then("^click change button of sub message$")
	public void click_change_button_of_sub_message() throws Throwable {
		changemessagetask.SelectSubMessage();
		changemessagetask.ClickMessageChangeButton();
	}

	@Then("^Change all the information of the sub message \"([^\"]*)\" \"([^\"]*)\"$")
	public void change_all_the_information_of_the_sub_message(String messagetitle, String messaegcontent) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		changemessagetask.ChangeMessageField(messagetitle,messaegcontent);
	}

}

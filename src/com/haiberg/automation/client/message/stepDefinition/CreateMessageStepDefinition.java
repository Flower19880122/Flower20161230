package com.haiberg.automation.client.message.stepDefinition;



import org.junit.Assert;










import com.haiberg.automation.client.task.CreateClientTask;
import com.haiberg.automation.client.message.task.CreateMessageTask;
import com.haiberg.automation.login.task.LoginTask;
import com.haiberg.automation.client.message.testRunner.CreateMessageRunner;
import com.haiberg.automation.login.testRunner.LoginRunner;
import com.haiberg.automation.web.WebBrowser;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.deps.com.thoughtworks.xstream.security.ForbiddenClassException;

public class CreateMessageStepDefinition {
	
	CreateMessageTask createmessagetask=new CreateMessageTask();
	CreateMessageRunner CreateMessageRunnerrunner=new CreateMessageRunner();
	CreateClientTask createclienttask=new CreateClientTask();
	LoginTask logintask=new LoginTask();
	LoginRunner loginrunner=new LoginRunner();
	boolean result=true;
	
   @Given("^user login in \"([^\"]*)\" \"([^\"]*)\"$")
		public void user_login_in(String username, String password) throws Throwable {
		//loginrunner.setUp();
	    logintask.InputUsername(username);
	    logintask.InputPassword(password);
	    logintask.ClickLoginbutton();
		}
	
	@And("Go to client page$")
	public void user_click_client_tab() throws Throwable {
		result=createclienttask.ClickClientTab();
		Assert.assertTrue(result);
	}
	
	@Then("^User fill in the mandatory fields of client$")
	public void user_fill_in_mandatory_fields() throws Throwable {
        createclienttask.ClickClientNewButton();
        createclienttask.InputClientName1();
        createclienttask.InputClientStreet();
        createclienttask.InputClientPLZ();
        createclienttask.InputClientCity();
        createclienttask.InputClientTelephone();
	}
	
	@Given("^User click message new button$")
	public void user_click_message_new_button() throws Throwable {
	  result=createmessagetask.ClickMessageNewButton();
	  Assert.assertTrue(result);
	}

	@Then("^user select sender$")
	public void user_select_sender() throws Throwable {
		result=createmessagetask.SelectSender();
		Assert.assertTrue(result);
	}

	@Then("^user select receiver$")
	public void user_select_receiver() throws Throwable {
		result=createmessagetask.SelectReceiver();
		Assert.assertTrue(result);
	}

	@Then("^user input title  \"([^\"]*)\"$")
	public void user_input_title(String title) throws Throwable {
		result=createmessagetask.InputMessageTitle(title);
		Assert.assertTrue(result);
	}

	@Then("^user input content \"([^\"]*)\"$")
	public void user_input_content(String content) throws Throwable {
		result=createmessagetask.InputMessageContent(content);
		Assert.assertTrue(result);
	}
	@Then("^user click message save button$")
	public void user_click_message_save_button() throws Throwable {
		result=createmessagetask.ClickMessageSaveButton();
		createmessagetask.checkMessage();
		Assert.assertTrue(result);
	//}
		//WebBrowser.closeBrowser();
	}
	
	@Then("^user click new button again$")
	public void user_click_new_button_again() throws Throwable {
	    createmessagetask.ClickMessageNewButton();
	}

	@Then("^user fill in all the mandatory fields \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_fill_in_all_the_mandatory_fields(String title, String content) throws Throwable {
		createmessagetask.SelectSender();
		createmessagetask.SelectReceiver();
		createmessagetask.InputMessageTitle(title);
		createmessagetask.InputMessageContent(content);
	}

	@Then("^save the sub message$")
	public void save_the_sub_message() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		createmessagetask.ClickMessageSaveButton();
		createmessagetask.checkMessage();
		//WebBrowser.closeBrowser();
	}
	

}

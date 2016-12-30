package com.haiberg.automation.client.StepDefinition;

import org.junit.Assert;


import com.haiberg.automation.client.task.ChangeClientTask;
import com.haiberg.automation.client.task.CreateClientTask;
import com.haiberg.automation.login.task.LoginTask;
import com.haiberg.automation.login.testRunner.LoginRunner;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ChangeClientStepDefinition {
	LoginTask logintask=new LoginTask();
	LoginRunner loginrunner=new LoginRunner();
	CreateClientTask createclienttask=new CreateClientTask();
	ChangeClientTask changeclienttask=new ChangeClientTask();
	boolean result=true;
	
	
	@Given("^Login the CAM project \"([^\"]*)\" \"([^\"]*)\"$")
	public void login_the_CAM_project(String username, String password) throws Throwable {
	   //loginrunner.setUp();
	   logintask.InputUsername(username);
	   logintask.InputPassword(password);
	   logintask.ClickLoginbutton();
	}

	@Then("^Open client apge$")
	public void open_client_apge() throws Throwable {
	    createclienttask.ClickClientTab();
	}
	
	@Then("^Input a client name to search for a client \"([^\"]*)\"$")
	public void input_a_client_name_to_search_for_a_client(String clientname) throws Throwable {
	    changeclienttask.InputClientNameSearch(clientname);

	}
	
	@Then("^Load the client from popo-up$")
	public void load_the_client_from_popo_up() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    changeclienttask.getClientSearchedResult();
	}

	@Then("^Click client change button$")
	public void click_client_change_button() throws Throwable {
		changeclienttask.clickClientChangeButton();
	}

	@Then("^Chang the email \"([^\"]*)\"$")
	public void chang_the_email(String newemail) throws Throwable {
		changeclienttask.changeClientEmailField(newemail);
		createclienttask.ClickClientSaveButton();
	}

	@Then("^save the change and confirm$")
	public void save_the_change_and_confirm() throws Throwable {
		createclienttask.ClickClientSavedOKbutton();
	}

	@Then("^Check if the change is saved  \"([^\"]*)\"$")
	public void check_if_the_change_is_saved(String newemailcheck) throws Throwable {
		result=changeclienttask.CheckClientChangedResult(newemailcheck);
		Assert.assertTrue(result);
	}

}

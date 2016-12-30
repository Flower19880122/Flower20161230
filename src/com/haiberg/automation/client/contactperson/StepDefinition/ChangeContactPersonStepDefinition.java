package com.haiberg.automation.client.contactperson.StepDefinition;

import org.junit.Assert;


import com.haiberg.automation.client.contactperson.testRunner.ChangeContactPersonRunner;
import com.haiberg.automation.client.contactperson.task.ChangeContactPersonTask;
import com.haiberg.automation.client.task.ChangeClientTask;

import com.haiberg.automation.client.task.CreateClientTask;
import com.haiberg.automation.client.contactperson.task.CreateContactPersonTask;
import com.haiberg.automation.login.task.LoginTask;
import com.haiberg.automation.login.testRunner.LoginRunner;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class ChangeContactPersonStepDefinition {
	LoginRunner loginRunner=new LoginRunner();
	LoginTask logintask=new LoginTask();
	CreateClientTask createclienttask=new CreateClientTask();
	ChangeClientTask changeclienttask=new ChangeClientTask();
	CreateContactPersonTask createcontactpersontask=new CreateContactPersonTask();
	ChangeContactPersonTask changecontactpersontask=new ChangeContactPersonTask();
	boolean result=true;
	
	@Given("^Login into CAM project \"([^\"]*)\" \"([^\"]*)\"$")
	public void login_into_CAM_project(String username, String password) throws Throwable {
	    //loginRunner.setUp();
	    logintask.InputUsername(username);
	    logintask.InputPassword(password);
	    logintask.ClickLoginbutton();
	}

	@When("^user open the client page$")
	public void user_open_the_client_page() throws Throwable {
	    createclienttask.ClickClientTab();
	}

	@Then("^open client change model \"([^\"]*)\"$")
	public void open_client_change_model(String clientname) throws Throwable {
	    changeclienttask.InputClientNameSearch(clientname);
	    changeclienttask.getClientSearchedResult();
	    changeclienttask.clickClientChangeButton();
	}

	@Then("^Double click the contact person$")
	public void double_click_the_contact_person() throws Throwable {
		changecontactpersontask.DoubleClickContactPerson();
	    
	}

//	@Then("^click contact person change button$")
//	public void click_contact_person_change_button() throws Throwable {
//		changecontactpersontask.ClickContactPersonChangeButton();
//	}

	@Then("^change contact person telephone$")
	public void change_contact_person_telephone() throws Throwable {
		changecontactpersontask.ChangeContactPersonTelephone();
	}

	@Then("^save the changed telephone$")
	public void save_the_changed_telephone() throws Throwable {
		createcontactpersontask.ClickContactPersonSaveButton();
	}

	@Then("^check the saved result$")
	public void check_the_saved_result() throws Throwable {
		result=changecontactpersontask.CheckChangegResult();
		Assert.assertTrue(result);
		
	}


}

package com.haiberg.automation.login.stepDefinition;

import com.haiberg.automation.login.task.LoginTask;


import com.haiberg.automation.login.testRunner.LoginRunner;
import com.haiberg.automation.web.WebBrowser;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginstepDefinition {
	
	LoginTask logintask=new LoginTask();
	LoginRunner loginrunner=new LoginRunner();
	
	


	@Given("^user input username \"([^\"]*)\"$")
	public void user_input_username(String username) throws Throwable {
		//loginrunner.setUp();
		logintask.InputUsername(username);
	    // Write code here that turns the phrase above into concrete actions
	
	}

	@Given("^user input password \"([^\"]*)\"$")
	public void user_input_password(String password) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		logintask.InputPassword(password);
	   
	}

	@Given("^user click login button$")
	public void user_click_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		logintask.ClickLoginbutton();
	   
	}
	

	@Then("^user login in sucessfully \"([^\"]*)\"$")
	public void user_login_in_sucessfully(String sucessfullymessage) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(6000);
	    logintask.getSucessfullymessage(sucessfullymessage);
	    WebBrowser.closeBrowser();
	}
	


}

package com.haiberg.automation.dashboard.stepDefinition;

import org.junit.Assert;


import com.haiberg.automation.client.task.CreateClientTask;
import com.haiberg.automation.client.message.task.CreateMessageTask;
import com.haiberg.automation.dashboard.task.DashboardTask;
import com.haiberg.automation.login.task.LoginTask;
import com.haiberg.automation.client.message.testRunner.CreateMessageRunner;
import com.haiberg.automation.login.testRunner.LoginRunner;
import com.haiberg.automation.web.WebBrowser;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;




public class DashboardDefaultCheckStepDefinition {
	
	LoginTask logintask=new LoginTask();
	LoginRunner loginrunner=new LoginRunner();
	boolean result=true;
	DashboardTask dashboardtask=new DashboardTask();
	
	
	@Given("^Login to the CAM \"([^\"]*)\" \"([^\"]*)\"$")
	public void login_to_the_CAM(String username, String password) throws Throwable {
	   //loginrunner.setUp();
	   logintask.InputUsername(username);
	   logintask.InputPassword(password);
	   logintask.ClickLoginbutton();
	   
	}

	@Then("^Check the default checked radio$")
	public void check_the_default_checked_radio() throws Throwable {
	    WebBrowser.waitForReady();
	    
	}

	@Then("^Check the total unread records \"([^\"]*)\"$")
	public void check_the_total_unread_records(String sql) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    result=dashboardtask.CheckTotalCount(sql);
	    Assert.assertTrue(result);
	}

	@Then("^Check all the status of first page$")
	public void check_all_the_status_of_first_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		result=dashboardtask.CheckPageStatus();
		Assert.assertTrue(result);
	}

	@Then("^Check all the status of last page$")
	public void check_all_the_status_of_last_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    dashboardtask.ClickLastPageButton();
	    WebBrowser.waitForReady();
	    result=dashboardtask.CheckPageStatus();
	    Assert.assertTrue(result);
	}

	@Then("^Click the all radio$")
	public void click_the_all_radio() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		dashboardtask.ClickAllRadioButton();
	}

	@Then("^check the total records \"([^\"]*)\"$")
	public void check_the_total_records(String sql) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		result=dashboardtask.CheckTotalCount(sql);
	    Assert.assertTrue(result);
	    WebBrowser.closeBrowser();
	}

	

}

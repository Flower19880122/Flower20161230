package com.haiberg.automation.dashboard.testRunner;

import org.junit.runner.RunWith;

import com.haiberg.automation.annotations.ExtendedCucumberRunner;

import cucumber.api.CucumberOptions;

@CucumberOptions(
		features = "Feature/CheckDashboard.feature", glue={"com.haiberg.automation.stepDefinition"})


@RunWith(ExtendedCucumberRunner.class)

public class DashboardDefaultCheckRunner {
	

}

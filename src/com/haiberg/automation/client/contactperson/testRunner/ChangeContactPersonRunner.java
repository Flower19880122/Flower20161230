package com.haiberg.automation.client.contactperson.testRunner;

import org.junit.runner.RunWith;


import com.haiberg.automation.annotations.ExtendedCucumberRunner;

import cucumber.api.CucumberOptions;

@CucumberOptions(
		features = "Feature/ChangeContactPerson.feature", glue={"com.haiberg.automation.stepDefinition"})


@RunWith(ExtendedCucumberRunner.class)


public class ChangeContactPersonRunner {
	

}

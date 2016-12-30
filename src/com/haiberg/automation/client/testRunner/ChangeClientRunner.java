package com.haiberg.automation.client.testRunner;

import org.junit.runner.RunWith;

import com.haiberg.automation.annotations.ExtendedCucumberRunner;

import cucumber.api.CucumberOptions;



@CucumberOptions(
		features = "Feature/Client", glue={"com.haiberg.automation.stepDefinition"})


@RunWith(ExtendedCucumberRunner.class)


public class ChangeClientRunner {

}

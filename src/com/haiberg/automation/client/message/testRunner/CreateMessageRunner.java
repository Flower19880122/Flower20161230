package com.haiberg.automation.client.message.testRunner;
import org.junit.runner.RunWith;





import com.haiberg.automation.annotations.ExtendedCucumberRunner;

import cucumber.api.CucumberOptions;

@CucumberOptions(
		features = "Feature/CreateMessage.feature", glue={"com.haiberg.automation.stepDefinition"})


@RunWith(ExtendedCucumberRunner.class)


public class CreateMessageRunner {

}

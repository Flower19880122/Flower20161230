package com.haiberg.automation.client.testRunner;

import org.junit.runner.RunWith;

import com.haiberg.automation.annotations.AfterSuite;
import com.haiberg.automation.annotations.BeforeSuite;
import com.haiberg.automation.annotations.ExtendedCucumberRunner;
import com.haiberg.automation.util.Config;
import com.haiberg.automation.web.WebBrowser;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		features = "Feature/Client/CreateClient.feature", glue={"com.haiberg.automation.client.StepDefinition"})


@RunWith(ExtendedCucumberRunner.class)


public class CreateClientRunner extends AbstractTestNGCucumberTests {
	
//	@BeforeSuite
//    public static void setUp() throws Exception {
//        // TODO: Add your pre-processing
//		System.out.println("BeforeMethod");
//		Thread.sleep(3000);
//		WebBrowser.browserinit();
//		
//	    WebBrowser.loadUrl(Config.getProperty("CAM"));
//
//    }
//	
//    @AfterSuite
//    public static void tearDown() {
//        // TODO: Add your post-processing
//    	WebBrowser.closeBrowser();
//    	
//    	System.out.println("浏览器被关闭了");
//    }
}

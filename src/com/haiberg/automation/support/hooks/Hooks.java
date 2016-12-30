package com.haiberg.automation.support.hooks;

import com.haiberg.automation.annotations.AfterSuite;
import com.haiberg.automation.annotations.BeforeSuite;
import com.haiberg.automation.util.Config;
import com.haiberg.automation.web.WebBrowser;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;

public class Hooks extends AbstractTestNGCucumberTests {
	
	@BeforeSuite
		  public static void openURL() throws Exception {
		        // TODO: Add your pre-processing
				System.out.println("BeforeMethod");
				Thread.sleep(3000);
				WebBrowser.browserinit();
				
			    WebBrowser.loadUrl(Config.getProperty("CAM"));

		    }
		

  @AfterSuite
  public static void tearDown() {
      // TODO: Add your post-processing
  	WebBrowser.closeBrowser();
  	
  	System.out.println("浏览器被关闭了");
  }
  }
  

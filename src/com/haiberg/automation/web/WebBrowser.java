package com.haiberg.automation.web;

import java.io.File;



import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.haiberg.automation.util.Config;
import com.sun.jna.platform.win32.WinNT.ACCESS_ACEStructure;

/**  
* <p>Title: WebBrowser</p>  
* <p>Project name: FIMS2.0</p>
* <p>Description: web browser options.TODO</p> 
* @author Adeng 
* @date Jan 23, 2016 5:19:43 PM 
* @version 1.0   
* <p>Copyright: 2015 www.haiberg.de Inc. All rights reserved.</p>
*/
public class WebBrowser {
	
	private static WebDriver driver;
	
	/** 
	* <p>Title: browserinit</p>
	* <p>Description:browser init. TODO</p>
	* @throws Exception
	* <p>Return Type: void</p>
	*/ 
	//public static void broserinitRemote(DesiredCapabilities caps) throws Exception{
		
		//driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
	//}
	
	//public static void headlessBroserinit() throws Exception{
		
		//driver= new HtmlUnitDriver();
		   // DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
		    //PhantomJSDriver driver = new PhantomJSDriver(capabilities);
		    //driver.get(Config.getProperty("Adassist"));
		  //  driver.manage().window().maximize();
	//}
	
	
	public static void browserinit() throws Exception{
		
		String type;
		type=Config.getProperty("browserType");
		
		if(type.equals("chrome")){
			String driverpath=Config.getProperty("ChromeDriverPath");
			//System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
			
			System.setProperty("webdriver.chrome.driver",driverpath);	
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--lang=de");
			driver = new ChromeDriver(options);
			System.out.println("pa2th"+driverpath);
			//driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(type.equals("firefox")){
			
			//System.setProperty ( "webdriver.firefox.driver" , "C:\\Program Files\\Mozilla Firefox\\firefox.exe" ); 
			driver = new FirefoxDriver();
			driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
		}
		else{
			
			System.out.println("No this browser!");
		}
	 
	}
	
	public static String captureScreenshot(String filename){
	
		String path=null;
		
		try { 
			
			String screeshotpath=Config.getProperty("ScreeshotPath");
			path=screeshotpath+filename+".png";
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
			FileUtils.copyFile (srcFile,new File(path)); 
			
		} catch (Exception e) { 
			e.printStackTrace(); 
		}
		
		return path;
	}
	
	public static  WebDriver getbrowser(){
	
		return driver;
	
	}
	
	/** 
	* <p>Title: loadUrl</p>
	* <p>Description:load url from properties. TODO</p>
	* @param url
	* <p>Return Type: void</p>
	*/ 
	
	public static void loadUrl(String url){
	
	//	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
        try { 
			
        	System.out.println("url="+url);
        	driver.get(url);
			
		} catch (Exception e) { 
			
			System.out.println("Timeout");
			//JavascriptExecutor js=(JavascriptExecutor)driver;
			//js.executeScript("window.stop()");
		}
     
	   
	}
	

	
	public static void waitForReady(long a){
		
		try {
			Thread.sleep(a);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static void shutdown(){
		
		driver.quit();
	
	}
	
	public static void waitForReady() {
			// TODO Auto-generated method stub
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	   public static Actions mouseOperations(){
	       	Actions ac= new Actions(driver);
	       	//ac.doubleClick(el);
	       	return ac;
	       }
	   
        public static void closeBrowser(){
        	driver.close();
        }
        public static void scrollPage(WebElement toElement){
        	Actions ac= new Actions(driver);
        	ac.moveToElement(toElement).perform();
        	
        }
        
        public static void releasaeMouse(){
        	Actions ac= new Actions(driver);
        	ac.release();
        	
        }
        
        public static void keyUp(){
        	Actions ac= new Actions(driver);
        	ac.sendKeys(Keys.UP);
        	
        }
        public static void pageUp(){
        	Actions ac= new Actions(driver);
        	ac.sendKeys(Keys.PAGE_UP).perform();
        	
        }
}
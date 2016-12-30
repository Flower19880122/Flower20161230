package com.haiberg.automation.web.widget;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.haiberg.automation.web.WebBrowser;


public class BaseWidgets {

	    protected WebDriver driver;
	    protected String[][] locatorMap;
        private WebElement e;
        private List<WebElement> es;
        
	    public BaseWidgets(){
	    	
	    	
	    }
	    
	    public BaseWidgets(Locator path) throws IOException{
	      
	    
	    	getElement(path);
		}

		public void type(String values) throws Exception {
	    	
	        e.sendKeys(values);
	    }
		
		public File getFile1() {
			
			File f=new File("D:\\complaints.xls");
			return f;
		
		}
		
		public String getExecuteFile1(){
			
			String executeFile="D:\\UploadFile.exe";
			return executeFile;
			
		}
	    
	    public void clickAndHold(Locator locator) throws IOException {
	    	
	        e = findElement(driver, locator);
	        Actions actions = new Actions(driver);
	        actions.clickAndHold(e).perform();
	    }

	    public WebDriver getDriver() {
	    	
	        return this.driver;
	    }

	    public void setDriver(WebDriver driver) {
	    	
	        this.driver = driver;
	    }

	    public WebElement getElement(Locator locator) {
	    	
	    	setDriver(WebBrowser.getbrowser());
	    	
	        try {
	        	
				return getElement(driver, locator);
				
			} catch (NoSuchElementException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
				
			} catch (IOException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	    }

	    /**
	     * get by parameter
	     * 
	     * @author Annie
	     * @param driver
	     * @param locator
	     * @return
	     * @throws IOException
	     */
	    public WebElement getElement(WebDriver driver, Locator locator)throws IOException {
	    	
	        //locator = getLocator(locator.getElement());
	     
	        switch (locator.getBy()) {
	      
	        case xpath:	       
	            e = driver.findElement(By.xpath(locator.getElement()));	         
	            break;
	        case id:
	            e = driver.findElement(By.id(locator.getElement()));
	            break;
	        case name:
	            e = driver.findElement(By.name(locator.getElement()));
	            break;
	        case cssSelector:
	            e = driver.findElement(By.cssSelector(locator.getElement()));
	            break;
	        case className:
	            e = driver.findElement(By.className(locator.getElement()));
	            break;
	        case tagName:
	            e = driver.findElement(By.tagName(locator.getElement()));
	            break;
	        case linkText:
	            e = driver.findElement(By.linkText(locator.getElement()));
	            break;
	        case partialLinkText:
	            e = driver.findElement(By.partialLinkText(locator.getElement()));
	            break;
	        default:
	        	System.out.println("bad");
	            e = driver.findElement(By.id(locator.getElement()));
	        }
	        
	        return e;
	    }
	    
	    public List<WebElement> getElements(Locator locator)throws IOException {
	    	
	        //locator = getLocator(locator.getElement());
	    	setDriver(WebBrowser.getbrowser());
	     
	        switch (locator.getBy()) {
	      
	        case xpath:	       
	            es = driver.findElements(By.xpath(locator.getElement()));	         
	            break;
	        case id:
	            es = driver.findElements(By.id(locator.getElement()));
	            break;
	        case name:
	            es = driver.findElements(By.name(locator.getElement()));
	            break;
	        case cssSelector:
	            es = driver.findElements(By.cssSelector(locator.getElement()));
	            break;
	        case className:
	            es = driver.findElements(By.className(locator.getElement()));
	            break;
	        case tagName:
	            es = driver.findElements(By.tagName(locator.getElement()));
	            break;
	        case linkText:
	            es = driver.findElements(By.linkText(locator.getElement()));
	            break;
	        case partialLinkText:
	            es = driver.findElements(By.partialLinkText(locator.getElement()));
	            break;
	        default:
	        	System.out.println("bad");
	            es = driver.findElements(By.id(locator.getElement()));
	        }
	        
	        return es;
	    }
	    
	    
	    public WebElement getElement(){
	    	
			return e;
		}
	    
	    public String getText(){
			  
			 return  e.getText().toString();
				   
		}
	    
	  
	    public void handleUpload(String browser, File file,String executeFile) {
	    	
	        String filePath= file.getAbsolutePath();
	        System.out.println("filepath"+filePath);
	        //String executeFile= "C:\\Users\\Adeng\\Desktop\\UploadFile.exe"; 
	        String cmd= "\""+ executeFile+ "\""+ " "+ "\""+ browser+ "\""+ " "+ "\""+ filePath+ "\"";
	        
	        try{
	        	
	            Process p= Runtime.getRuntime().exec(cmd);
	            p.waitFor();
	            
	        	} catch(Exception e) {
	        	
	            e.printStackTrace();
	            
	        	}
	    }
	    
	    public boolean isElementPresent(WebDriver driver, final Locator myLocator,int timeOut) throws IOException {
	    	
	       // final Locator locator = getLocator(myLocator.getElement());
	        boolean isPresent = false;
	        WebDriverWait wait = new WebDriverWait(driver, timeOut);
	        isPresent = wait.until(new ExpectedCondition<WebElement>() {
	            public WebElement apply(WebDriver d) {
	                try {
						return getElement(d, myLocator);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return null;
					}
	            }
	        }).isDisplayed();
	        
	        return isPresent;
	    }               
	       

	    /**
	     * This Method for check isPresent Locator
	     * 
	     * @param locator
	     * @param timeOut
	     * @return
	     * @throws IOException
	     */
	    public boolean isElementPresent(Locator locator, int timeOut)throws IOException {
	    	
	        return isElementPresent(driver,locator, timeOut);
	    }

	    /**
	     * 
	     * @param driver
	     * @param locator
	     * @return
	     */
	    public WebElement findElement(WebDriver driver, final Locator locator) {
	    	
	        WebElement element = (new WebDriverWait(driver, locator.getWaitSec())).until(new ExpectedCondition<WebElement>() {

	                    public WebElement apply(WebDriver driver) {
	                        try {
	                        
	                            return getElement(driver, locator);
	                        } catch (IOException e) {
	                            // TODO Auto-generated catch block
	                            return null;
	                        }

	                    }

	                });
	        
	        return element;

	    }

	    public Locator getLocator(String locatorName) throws IOException {

	        Locator locator;
	        for (int i = 0; i < locatorMap.length; i++) {
	        	
	            if (locatorMap[i][0].endsWith(locatorName)) {
	            	
	                return locator = new Locator(locatorMap[i][1]);
	            }
	        }

	        return locator = new Locator(locatorName);

	    }

		
	}
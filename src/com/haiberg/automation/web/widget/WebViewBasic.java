package com.haiberg.automation.web.widget;


import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import com.haiberg.automation.web.WebBrowser;

public class WebViewBasic {

private WebElement st;
	
	public  WebViewBasic(String a)
	{
		
		findWebViewBasic(a);
	}
	
	public String getClassname()
	{
		
		return st.getAttribute("class");
	}
	
	public WebElement findWebViewBasic(String e){
		
		st=WebBrowser.getbrowser().findElement(By.xpath(e));
		
		return st;
	}
	
	
	public WebElement getElement(){
		
		return st;
	}
	
	public String getElementText(){
		
		return st.getText();
	}
	
	public void waitForExistence(){
		
		try {
			
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
   /* public boolean isElementPresent(WebDriver driver, Locator myLocator,
            int timeOut) throws IOException {
       
        boolean isPresent = false;
        WebDriverWait wait = new WebDriverWait(driver, 60);
        isPresent = wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return findElement(d, locator);
            }
        }).isDisplayed();
        return isPresent;
    }
    */
	public void click()
	{
		st.click();
		
	}
}

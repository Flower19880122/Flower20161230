package com.haiberg.automation.web.widget;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.haiberg.automation.web.WebBrowser;


public class WebTextField {

private  WebElement st;
	
	public  WebTextField(String path)
	{
		
		findWebTextField(path);
	}
	
	public String getClassname()
	{
		
		return st.getAttribute("class");
	}
	
	public WebElement findWebTextField(String path)
	{
		
		st=WebBrowser.getbrowser().findElement(By.xpath(path));
		
		return st;
	}
	
	public void setText(String text)
	{
	    st.sendKeys(text);
	}
	
	public WebElement getTextField()
	{
		return st;
	}
	
	
	public void click(){
		
		st.click();
		
	}

	public void clear(){
		
		st.clear();
	}
	
	public String getText(){
		  
		 return  st.toString();
			   
	}
	  
	public void waitForExistence(String mess, final String xpath){
			
	/*	try {
				Thread.sleep(100);
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			WebElement message =(new WebDriverWait (WebBrowser.getbrowser(),10)).until(
				new ExpectedCondition<WebElement>(){
					@override
					public WebElement apply(WebBrowser.getbrowser()){
						return WebBrowser.getbrowser().findElement(By.xpath(xpath));
					}
		});*/
		
		WebDriverWait wait = new WebDriverWait(WebBrowser.getbrowser(), 60);
		 WebElement message=wait.until(new ExpectedCondition<WebElement>() {
	            @Override
	            public WebElement apply(WebDriver d) {
	                return findWebTextField(xpath);
	            }
		 });
		 
		 org.testng.AssertJUnit.assertTrue(message.getText().contains(mess));
	
				
					
			
	}


}

package com.haiberg.automation.web.widget;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public  class WebButton extends BaseWidgets{

	private WebElement st;
	
	public WebButton(Locator a) throws Exception {
		// TODO Auto-generated constructor stub
		FindWebButton(a);
	}

	
	public void FindWebButton(Locator path) throws Exception{
		
		st=new BaseWidgets().getElement(path);
	}
	
	
	public void click(){
		
		st.click();
	}
	
	public void clickAndHold(){
		
		Actions actions = new Actions(driver);
	    actions.clickAndHold(st).perform();
	}
	
}

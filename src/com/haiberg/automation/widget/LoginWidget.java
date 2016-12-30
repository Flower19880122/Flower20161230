package com.haiberg.automation.widget;

import org.openqa.selenium.WebElement;

import com.haiberg.automation.web.widget.Locator;
import com.haiberg.automation.web.widget.BaseWidgets;

public class LoginWidget extends BaseWidgets{
	
	public WebElement getTextFieldUserName() throws Exception {
		
		return getElement(new Locator("//*[@id='_58_login']"));
	}
	
	
public WebElement getTextFieldpassword() throws Exception {
		
		return getElement(new Locator("//*[@id='_58_password']"));

}

public WebElement getLoginbutton() throws Exception {
	
	return getElement(new Locator("//*[@id='_58_fm']//button"));

}

public WebElement LoginSucessfully(){
	return getElement(new Locator("//*[@id='CenterPanel-outerCt']//span//span//span[2]"));
}
}
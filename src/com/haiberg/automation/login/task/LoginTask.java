package com.haiberg.automation.login.task;

import com.haiberg.automation.web.WebBrowser;
import com.haiberg.automation.widget.LoginWidget;

public class LoginTask {
	static boolean result=false;
	LoginWidget loginwidget=new LoginWidget();
	
	public boolean InputUsername(String username) throws Exception{
		WebBrowser.waitForReady();
		loginwidget.getTextFieldUserName().clear();
		loginwidget.getTextFieldUserName().sendKeys(username);
		
		return result;
		
	}
	public boolean InputPassword(String password) throws Exception{
		loginwidget.getTextFieldpassword().sendKeys(password);
		return result;
		
	}
	public boolean ClickLoginbutton() throws Exception{
		loginwidget.getLoginbutton().click();
		return result;
	}
	
	
	public boolean getSucessfullymessage(String sucessfullymessage){
		loginwidget.LoginSucessfully().getText().equals(sucessfullymessage);
		return result;
	}
}

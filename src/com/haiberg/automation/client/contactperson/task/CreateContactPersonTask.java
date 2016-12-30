package com.haiberg.automation.client.contactperson.task;

import com.haiberg.automation.support.randomGenerator.RandomlyGenerator;
import com.haiberg.automation.web.WebBrowser;
import com.haiberg.automation.widget.ContactPersonWidget;

import freemarker.core.ReturnInstruction.Return;

public class CreateContactPersonTask {
	ContactPersonWidget contactpersonwidget= new ContactPersonWidget();
	private boolean result=false;
	RandomlyGenerator rg=new RandomlyGenerator();
	
	public boolean clickNewContatPersonButton(){
		contactpersonwidget.getNewContatPersonButton().click();
		return result;
	}
	
	public boolean selectContactPersonAnrede(){
		WebBrowser.waitForReady(30000);
		contactpersonwidget.getNewContatPersonAnredeList().click();
		WebBrowser.waitForReady(30000);
		contactpersonwidget.getNewContatPersonAnredeSelect().click();
		return result;
	}
	
	public boolean InputContactPersonName(){
		contactpersonwidget.getContatPersonNameFiedl().sendKeys(rg.GeneratorRandomly(10));
		return result;
	}
	
	public boolean ClickContactPersonSaveButton(){
		contactpersonwidget.getContatPersonSaveButton().click();
		return result;
	}

}

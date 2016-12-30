package com.haiberg.automation.client.contactperson.task;

import com.haiberg.automation.support.randomGenerator.RandomlyTelephoneGenerator;
import com.haiberg.automation.web.WebBrowser;
import com.haiberg.automation.widget.ContactPersonWidget;

public class ChangeContactPersonTask {
	private boolean result=true;
	ContactPersonWidget contactpersonwidget=new ContactPersonWidget();
	RandomlyTelephoneGenerator randomtelephone=new RandomlyTelephoneGenerator();
	String filledtelephoneString;
	
	
	public boolean DoubleClickContactPerson(){
		contactpersonwidget.getContatPersonRecord().click();
		System.out.println("先单击一下contact person");
		WebBrowser.captureScreenshot("click");
		WebBrowser.mouseOperations().doubleClick(contactpersonwidget.getContatPersonRecord());
		System.out.println("再双击一下contact person");
		return result;
		
		
	}
	
//	public boolean ClickContactPersonChangeButton(){
//		WebBrowser.waitForReady();
//		contactpersonwidget.getContatPersonChangeButton().click();
//		return result;
//		
//	}
//	
	public boolean ChangeContactPersonTelephone(){
		contactpersonwidget.getContatPersonTelephone().sendKeys(randomtelephone.GeneratorTelephoneRandomly(10));
		
		return result;
		
	}
	public String getFilledChangeTelephone(){
		filledtelephoneString=contactpersonwidget.getContatPersonTelephoneField().getAttribute("value");
		return filledtelephoneString;
		
	}
	
	public boolean CheckChangegResult(){
		result=contactpersonwidget.getContatPersonTelephone().equals(filledtelephoneString);
		return result;
		
	}
	

}

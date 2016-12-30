package com.haiberg.automation.client.task;

import com.haiberg.automation.support.randomGenerator.RandomlyGenerator;
import com.haiberg.automation.web.WebBrowser;
import com.haiberg.automation.widget.ClientMessageWidget;
import com.haiberg.automation.widget.ClientWidget;

public class CreateClientTask {
	
	static boolean result=true;
	ClientWidget clientwidget=new ClientWidget();
	RandomlyGenerator rg=new RandomlyGenerator();
	
	public boolean ClickClientTab(){
		WebBrowser.waitForReady();
	    clientwidget.getClientttab().click();
		return result;
		
	}
	
	public boolean ClickClientNewButton(){
		clientwidget.getClientNewButton().click();
		return result;
		
	}
    
	
	public boolean InputClientName1(){
		int length=10;
		clientwidget.getName1textfield().sendKeys(rg.GeneratorRandomly(length));;
		return result;
		
	}
	
	public boolean InputClientStreet(){
		int length=10;
		clientwidget.getStreettextfield().sendKeys(rg.GeneratorRandomly(length));;
		return result;
		
	}
	
	public boolean InputClientPLZ(){
		String plz="11111";
		clientwidget.getPLZtextfield().sendKeys(plz);
		return result;
		
	}
	
	public boolean InputClientCity(){
		int length=10;
		clientwidget.getOrttextfield().sendKeys(rg.GeneratorRandomly(length));
		return result;
		
	}
	
	public boolean InputClientTelephone(){
		String telephone="1111111111";
		clientwidget.getTelephonetextfield().sendKeys(telephone);
		return result;
		
	}
	
	public boolean ClickClientSaveButton(){
		WebBrowser.waitForReady(3000);
		System.out.println("等待了很长时间");
//		WebBrowser.releasaeMouse();
//		System.out.println("鼠标已经释放");
		//WebBrowser.scrollPage(clientwidget.getClientSaveButton());
		//System.out.println("我已经移动鼠标了");
		WebBrowser.pageUp();
		WebBrowser.waitForReady(3000);
		clientwidget.getClientSaveButton().click();
		return result;
		
	}
	
	public boolean CheckNoContactPersonHintMessage(String contactpersonhintmessage){
		result=clientwidget.getNoContactPersonHintMessage().getText().equals(contactpersonhintmessage);
		System.out.println(clientwidget.getNoContactPersonHintMessage().getText());
		System.out.println(contactpersonhintmessage);
		return result;
	}
	
	public boolean ClickNoContactPersonHintmessageOkbutton(){
		clientwidget.getNoContactPersonHintMessageOKbutton().click();
		return result;
	}
	
	
    public boolean CheckClientSaved(String clientsavemessage){
    	WebBrowser.waitForReady();
    	result=clientwidget.getClientsaveMessage().getText().equals(clientsavemessage);
    	return result;
    	
    }
    
    public boolean ClickClientSavedOKbutton(){
    	WebBrowser.waitForReady();
    	clientwidget.getClientsaveMessageOKbutton().click();
    	return result;
    	
    }
	
	
}

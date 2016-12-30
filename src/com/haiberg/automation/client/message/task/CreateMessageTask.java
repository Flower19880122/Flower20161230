package com.haiberg.automation.client.message.task;

import java.util.ArrayList;

import java.util.List;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.haiberg.automation.support.randomGenerator.RandomlyGenerator;
import com.haiberg.automation.web.WebBrowser;
import com.haiberg.automation.widget.ClientMessageWidget;

public class CreateMessageTask {
	
	static boolean result=true;
	ClientMessageWidget clientmessagewidget=new ClientMessageWidget();
	RandomlyGenerator messagegenerator=new RandomlyGenerator();
	String messagetitle;
	
	public boolean ClickMessageNewButton() {
		WebBrowser.waitForReady();
		clientmessagewidget.getMessageNewButton().click();
		WebBrowser.mouseOperations().sendKeys(Keys.ENTER);
		return result;
		
	}
	
	public boolean SelectSender(){
		clientmessagewidget.getMessageSenderField().click();
		WebBrowser.waitForReady();
		//WebBrowser.mouseOperations().sendKeys(Keys.ENTER);
		clientmessagewidget.getMessageSenderList().get(1).click();
		return result;
	}
	
	public boolean SelectReceiver(){
		clientmessagewidget.getMessageReceiverField().click();
		WebBrowser.waitForReady();
		clientmessagewidget.getMessageReceiverList().get(2).click();
		return result;
	}
	
	public boolean InputMessageTitle(String title){
		int length=30;
		//clientmessagewidget.getMessageTitle().sendKeys(messagegenerator.GeneratorRandomly(length));
		clientmessagewidget.getMessageTitle().sendKeys(title);
		return result;
		
	}
	
	public boolean InputMessageContent(String content){
		int length=130;
		//clientmessagewidget.getMessageContent().sendKeys(messagegenerator.GeneratorRandomly(length));
		clientmessagewidget.getMessageContent().sendKeys(content);
		return result;
		
	}
	
	public boolean ClickMessageSaveButton(){
		clientmessagewidget.getMessageSaveButton().click();
		return result;
		
	}
	
	public boolean checkMessage(){
		List<WebElement> webs = clientmessagewidget.getMessageList();
        for(int i=1;i<webs.size();i++){
        	
        	System.out.println("message的标题是："+webs.get(i).getText());
        	result=webs.get(i).getText().equals(clientmessagewidget.getMessageTitle().getAttribute("value"));
        
        	if(result=true) 
        	
            break;
        	
    	
        }
//        messagetitle=clientmessagewidget.getMessageTitle().getText();
//        
//		System.out.println("随机生成的message的标题是："+clientmessagewidget.getMessageTitle().getAttribute("value"));
		return result;
//		
	}
	
		
	}
	
	



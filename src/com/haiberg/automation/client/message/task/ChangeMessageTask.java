package com.haiberg.automation.client.message.task;

import com.haiberg.automation.widget.ClientMessageWidget;

public class ChangeMessageTask {
	ClientMessageWidget clientmessagewidget=new ClientMessageWidget();
	private boolean result=true;
	
	public boolean ClickMessageNewButton(){
		clientmessagewidget.getMessageNewButton().click();
		return result;
	}
	
	public boolean FilledMessageField(String messagetitle,String messagecontent ){

		clientmessagewidget.getMessageTypeList().get(2).click();
		clientmessagewidget.getMessageSenderList().get(1).click();
		clientmessagewidget.getMessageReceiverList().get(2).click();
		clientmessagewidget.getMessageTitle().sendKeys(messagetitle);
		clientmessagewidget.getMessageContent().sendKeys(messagecontent);
		clientmessagewidget.getMessageSaveButton().click();

		return result;
	}
	
	
	public boolean ChangeMessageField(String messagetitle,String messagecontent ){
		
		clientmessagewidget.getMessageNewButton().click();
		clientmessagewidget.getMessageTypeList().get(2).click();
		clientmessagewidget.getMessageSenderList().get(1).click();
		clientmessagewidget.getMessageReceiverList().get(2).click();
		clientmessagewidget.getMessageTitle().sendKeys(messagetitle);
		clientmessagewidget.getMessageContent().sendKeys(messagecontent);
		clientmessagewidget.getMessageSaveButton().click();
		
		return result;
	}

	public boolean SelectMainMessage(){
		clientmessagewidget.getMainmessage().click();
		return result;
		
	}
	
	public boolean SelectSubMessage(){
		clientmessagewidget.getSubMessage().click();
		return result;
		
	}
	
	public boolean ClickMessageChangeButton(){
		clientmessagewidget.getMessageChangeButton().click();
		return result;
		
	}
}

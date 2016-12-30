package com.haiberg.automation.widget;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.haiberg.automation.web.widget.BaseWidgets;
import com.haiberg.automation.web.widget.Locator;

public class ClientMessageWidget extends BaseWidgets{
	public WebElement getMessageNewButton(){
		return getElement(new Locator("//*[@id='clientMsgPanel-body']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/span[1]"));
	}
	
	
	public WebElement getMessageTypeField(){
		return getElement(new Locator("//*[@id='mssgType-inputEl']"));
	}
	public List<WebElement> getMessageTypeList(){
		
	   	List<WebElement> webs=new ArrayList<WebElement>();;
			try {
				webs = getElements(new Locator("//div[@id='boundlist-1176-listWrap']/ul[1]/li"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("数组的大小是:"+webs.size());  
			return webs;
	    }
		
	public WebElement getMessageSenderField(){
		return getElement(new Locator("//*[@id='mssgSender-inputEl']"));
	}
	
    public List<WebElement> getMessageSenderList(){
    	
    	
    	List<WebElement> webs=new ArrayList<WebElement>();;
		try {
			webs = getElements(new Locator("//div[@id='boundlist-1178']/div[1]/ul[1]/li"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("数组的大小是:"+webs.size());
		return webs;
   }
	
	
	public WebElement getMessageReceiverField(){
		return getElement(new Locator("//*[@id='mssgReceiver-inputEl']"));
	}
	
     public List<WebElement> getMessageReceiverList(){
    	 
    		List<WebElement> webs=new ArrayList<WebElement>();;
    		try {
    			webs = getElements(new Locator("//div[@id='boundlist-1181']/div[1]/ul[1]/li"));
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		System.out.println("数组的大小是:"+webs.size());
    		return webs;
    }
	
	
	public WebElement getMessageTitle(){
		return getElement(new Locator("//*[@id='msgForm-innerCt']/div[9]/div[1]/div[1]/div[1]/input"));
	}

	public WebElement getMessageContent(){
		return getElement(new Locator("//*[@name='content']"));
	}
	
	public WebElement getMessageSaveButton(){
		return getElement(new Locator("//*[@id='msgForm']//span[2]"));
	}
	
    public  List<WebElement> getMessageList(){
    	List<WebElement> webs=new ArrayList<WebElement>();;
		try {
			webs = getElements(new Locator("//span[@class='x-tree-node-text ']"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("数组的大小是:"+webs.size());
		return webs;
    }
    
    public WebElement getMainmessage(){
    	return getElement(new Locator("//div[@id='messageTree-body']//table[2]"));
    	
    	
    }
    
    public WebElement getSubMessage(){
    	return getElement(new Locator("//div[@id='messageTree-body']//table[3]"));
    	
    	
    }
    
    public WebElement getMessageChangeButton(){
    	
    	return getElement(new Locator("//*[@id='clientMsgPanel-body']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[3]/span[1]/span[1]/span[2]"));  	
    }
    
}

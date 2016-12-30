package com.haiberg.automation.widget;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.selenesedriver.GetElementAttribute;

import com.haiberg.automation.web.widget.BaseWidgets;
import com.haiberg.automation.web.widget.Locator;

public class ClientWidget extends BaseWidgets{
	public WebElement getClientttab(){
		return getElement(new Locator("//*[@id='CenterPanel-innerCt']/div[1]/div[1]/div[1]/div[2]/div/a[2]/span[1]/span[1]/span[2]"));
	}
	
	public WebElement getClientNewButton(){
		return getElement(new Locator("//*[@id='criterialPanel-innerCt']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/span[1]/span[1]/span[2]"));
	}
	
	public WebElement getName1textfield(){
		return getElement(new Locator("//*[@name='kundName1']"));
		
	}
	
	public WebElement getStreettextfield(){
		return getElement(new Locator("//*[@name='kundStreet']"));
		
	}
	
	public WebElement getPLZtextfield(){
		return getElement(new Locator("//*[@name='kundPLZ']"));
	}
	
	
	public WebElement getOrttextfield(){
		  return getElement(new Locator("//*[@name='kundOrt']"));
		}
	
	public WebElement getTelephonetextfield(){
		  return getElement(new Locator("//*[@name='kundTelephon']"));
		}
		
	public WebElement getClientSaveButton(){
		  return getElement(new Locator("//*[@id='criterialPanel-outerCt']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/span[1]/span[1]/span[2]"));
		}
	
	public WebElement getNoContactPersonHintMessage(){
		  return getElement(new Locator("//div[@id='messagebox-1001-displayfield-inputEl']"));
		}
	
	public WebElement getNoContactPersonHintMessageOKbutton(){
		  return getElement(new Locator("//span[@id='button-1005-btnEl']"));
		}
	
	public WebElement getClientsaveMessage(){
		return getElement(new Locator("//div[@id='messagebox-1001']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]"));
		
	}
	
	public WebElement getClientsaveMessageOKbutton(){
		return getElement(new Locator("//div[@id='messagebox-1001']/div[3]//a[1]/span[1]/span[1]"));
		
	}
	
	public WebElement getClientSearchNameField(){
		return getElement(new Locator("//div[@id='clientCriterialFormId-innerCt']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input"));
		
	}
	
	public WebElement getClientSearchPopupRecordPLZfield(){
		return getElement(new Locator("//div[@id='ClientQueryResultPanel']/div[1]/div[1]/div[1]/div[3]"));
		
	}
	
	public WebElement getClientSearchPopupRecord(){
		return getElement(new Locator("//div[@id='ClientQueryResultPanel-body']/div[1]/div[2]/table[1]"));
		
	}
	
	public WebElement getClientChangeButton(){
		return getElement(new Locator("//div[@id='criterialPanel-innerCt']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[2]"));
		
	}
	
	public WebElement getClientEmailField(){
		return getElement(new Locator("//input[@id='textfield-1086-inputEl']"));
		
	}
	
	public WebElement getClientSearchButton(){
		return getElement(new Locator("//div[@id='clientCriterialFormId-innerCt']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]"));
		
	}
			
	public WebElement getClientLoadButton(){
		return getElement(new Locator("//div[@id='clientQueryWindow-body']/div[2]/div[1]/div[1]/div[1]/a[1]"));
		
	}
	
}

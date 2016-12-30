package com.haiberg.automation.widget;

import org.openqa.selenium.WebElement;

import com.haiberg.automation.web.widget.BaseWidgets;
import com.haiberg.automation.web.widget.Locator;

public class ContactPersonWidget extends BaseWidgets{
	public WebElement getNewContatPersonButton(){
		  return getElement(new Locator("//*[@id='contact_new_btn-btnInnerEl']"));
		}
	
	public WebElement getNewContatPersonAnredeList(){
		  return getElement(new Locator("//input[@id='combox_anrede_id-inputEl']"));
		}
	
	public WebElement getNewContatPersonAnredeSelect(){
		  return getElement(new Locator("//div[@id='boundlist-1142-listWrap']//ul//li[1]"));
		}
	
	
	
	public WebElement getContatPersonNameFiedl(){
		  return getElement(new Locator("//div[@id='contact_form_id-innerCt']//div[3]//div//div//input"));
		}
	
    public WebElement getContatPersonSaveButton(){
			  return getElement(new Locator("//*[@id='contact_new_btn-btnInnerEl']"));
			}
    
    public WebElement getContatPersonRecord(){
		  return getElement(new Locator("//div[@id='contact_grid_id-body']/div[1]/div[1]/table[1]"));
		}
    
    public WebElement getContatPersonChangeButton(){
		  return getElement(new Locator("//span[@id='contact_new_btn-btnWrap']"));
		}
    
    public WebElement getContatPersonChangeAnrede(){
		  return getElement(new Locator("//div[@id='boundlist-1142-listWrap']/ul[1]/li[2]"));
		}
    
    public WebElement getContatPersonTelephoneField(){
		  return getElement(new Locator("//input[@id='textfield-1144-inputEl']"));
		}
    
    public WebElement getContatPersonTelephone(){
		  return getElement(new Locator("//div[@id='contact_grid_id-body']/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]"));
		}

}

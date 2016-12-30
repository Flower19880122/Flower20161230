package com.haiberg.automation.widget;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.haiberg.automation.web.widget.BaseWidgets;
import com.haiberg.automation.web.widget.Locator;

public class DashboardWidget extends BaseWidgets{
	public WebElement getUnreadRadio(){
		return getElement(new Locator("//div[@id='CenterPanel-innerCt']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]//table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/input[1]"));
	}
	
	
    public WebElement getPagingfield(){
		return getElement(new Locator("//div[@id='messageGrid']/div[5]/div[1]/div[1]/div[7]"));
	}
	
	public WebElement getTotalCountfield(){
		return getElement(new Locator("//div[@id='messageGrid']/div[5]/div[1]/div[1]/div[11]"));
	}
	
	
	public List<WebElement> getStatusColumn() throws IOException{
	
			return getElements(new Locator("//div[@id='messageGrid-body']/div[1]/div[2]/table//td[6]/div"));
		
		
	}
	
	public WebElement getLastPageButton(){
		return getElement(new Locator("//div[@id='messageGrid']/div[5]/div[1]/div[1]/a[4]/span[1]/span[1]/span[1]"));
	}
	
	public WebElement getAllRadio(){
		return getElement(new Locator("//div[@id='CenterPanel-innerCt']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]//table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[1]/input[1]"));
	}
	
	
}

package com.haiberg.automation.client.task;

import org.openqa.selenium.Keys;

import com.haiberg.automation.web.WebBrowser;
import com.haiberg.automation.widget.ClientWidget;

public class ChangeClientTask {
   private boolean result=true;
   ClientWidget clientwidget=new ClientWidget();
   
   public boolean InputClientNameSearch(String clientname){
	   clientwidget.getClientSearchNameField().sendKeys(clientname);
	   //WebBrowser.mouseOperations().sendKeys(Keys.ENTER);
	   clientwidget.getClientSearchButton().click();
	 
	return result;
   }
   
   public boolean getClientSearchedResult(){
	   WebBrowser.waitForReady();
	   clientwidget.getClientSearchPopupRecordPLZfield().click();
	   clientwidget.getClientSearchPopupRecordPLZfield().click();
	   clientwidget.getClientSearchPopupRecord().click();
	   System.out.println("here is ok");
	   clientwidget.getClientLoadButton().click();
	return result;
	   
   }
   
   public boolean clickClientChangeButton(){
	   clientwidget.getClientChangeButton().click();
	return result;
	   
   }
   
   public boolean changeClientEmailField(String newemail){
	   WebBrowser.waitForReady();
	   clientwidget.getClientEmailField().sendKeys(newemail);
	return result;
	   
   }
   
   public boolean CheckClientChangedResult(String newemailcheck){
       
	   result=clientwidget.getClientEmailField().getAttribute("value").equals(newemailcheck);
	   return result;
	   
   }

}

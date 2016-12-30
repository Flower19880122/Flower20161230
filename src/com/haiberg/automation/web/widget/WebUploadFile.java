package com.haiberg.automation.web.widget;

import org.openqa.selenium.By;

import com.haiberg.automation.web.WebBrowser;

public  class WebUploadFile {
		
	public WebUploadFile(String a, String file) {
		// TODO Auto-generated constructor stub
		findFileUploadbButtonandSendkey(a,file);
	}

	public void findFileUploadbButtonandSendkey(String e, String file){
		
		WebBrowser.getbrowser().findElement(By.xpath(e)).sendKeys(file);
	}
	

	
}

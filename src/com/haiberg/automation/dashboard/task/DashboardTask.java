package com.haiberg.automation.dashboard.task;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.INTERNAL;
import org.openqa.selenium.WebElement;

import com.haiberg.automation.support.jdbc.DBconnection;
import com.haiberg.automation.support.jdbc.GetQuriedresult;
import com.haiberg.automation.widget.DashboardWidget;

public class DashboardTask {
	DashboardWidget dashboardwidget=new DashboardWidget();
	Boolean result=true;
	GetQuriedresult getquriedresult=new GetQuriedresult();
	DBconnection dbconnection=new DBconnection();
	
	public boolean CheckTotalCount(String sql) throws SQLException{
		
	
	    //dbconnection.getDBconnection();
	    
		ArrayList[][] alist=getquriedresult.getQuriedresult(sql);
		String total=dashboardwidget.getTotalCountfield().getText();
		String[] totalcounts=total.split(" ");
		int totalcount=Integer.parseInt(totalcounts[6]);
		System.out.println("比较的时候页面上查询出来的总条数："+totalcount);
		if(totalcount==alist.length){
			result=true;
			
		}else{
			result=false;
		}
		System.out.println("比较的时候数据库中查询出来的总条数："+alist.length);
		
		return result;
		
		
	}
	
	public boolean CheckPageStatus() throws IOException{
	
	    List<WebElement> list=dashboardwidget.getStatusColumn();
	    for(int i=0;i<list.size();i++){
	    	if(list.get(i).getText().equals("erfasst")){
	    		result=true;
	    	}else{
	    		result=false;
	    		System.out.println("message的status:"+list.get(i));
	    		break;
	    	};
	    	
	    }
		return result;
	}
	
	public boolean ClickLastPageButton(){
		dashboardwidget.getLastPageButton().click();
		return result;
	}
	
	public boolean ClickAllRadioButton(){
		dashboardwidget.getAllRadio().click();
		return result;
	}
	
	

}

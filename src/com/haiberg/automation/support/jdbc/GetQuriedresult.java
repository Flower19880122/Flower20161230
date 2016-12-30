package com.haiberg.automation.support.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetQuriedresult {

	public static ArrayList[][] getQuriedresult(String sql){
		 
		
		 int rowcount=0;
		 int columncount=0;
		
		 DBconnection dbconnection=new DBconnection();
		 
		 ResultSet resultset = DBquery.getQuriedResult(sql);
		 
		 try {
				//System.out.println("从数据库查询出来的总行数："+rowcount);
				while(resultset.next()){
					rowcount++;
				}
				System.out.println("从数据库查询出来的总行数："+rowcount);
		        ResultSetMetaData rsmd = resultset.getMetaData();
			    columncount= rsmd.getColumnCount();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 ArrayList[][] alist= new ArrayList[rowcount][columncount];
		 System.out.println("执行的sql："+sql);
		 //System.out.println("DBConnectiontest");
		System.out.println("从数据库查询出来的总行数："+rowcount);
		System.out.println("从数据库查询出来的总列数："+columncount);
		System.out.println("在这个连接中获得的数组的行数是："+alist.length);
		
		return alist;
	 }
}

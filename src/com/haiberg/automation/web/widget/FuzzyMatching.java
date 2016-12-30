package com.haiberg.automation.web.widget;

public class FuzzyMatching {
	 
	 String orgStr ="";
	 String subStr ="";

	 public String setOrgStr(String orgStr){
		 
	   this.orgStr = orgStr;
	   return this.orgStr;
	 }
	
	 public String setSubStr(String subStr){
		 
	    this.subStr = subStr;
	    return this.subStr;
	 }
	   
	 public boolean ifStartandEndwithStar(){
		
		return orgStr.contains(subStr.substring(1, subStr.length()-1));	
	 }
	 
	 public boolean ifEndtwithStar(){
		 
		 return this.orgStr.startsWith(subStr.substring(0, subStr.length()-1));
	 }
	 	 
	 public boolean ifNoStar(){
		 
		 return this.orgStr.contains(subStr);
	 }
	 
	 public boolean ifStartwithStar(){
		 
		 return  this.orgStr.endsWith(subStr.substring(1));
	 
	 }
	 
	 public int judgeach(String a[][],int row,int kind){
		 
		 int count=0,i=0,j=0;		
		
		 for(i=0;i<row;i++ ){
			 
			 	boolean BREAK=false;
			 	
			 for(j=0;j<9;j++){
				 
				 setOrgStr(a[i][j]);
				// System.out.println("Origini="+i+"j="+j+"value="+ setOrgStr(a[i][j]));
				
				 switch(kind){
				 
				 case 1:
				     if(subStr.equals("*")){
				    	 
				    	 count++;
				    	 BREAK=true;
				     }
				     
				     else if(ifStartandEndwithStar()==true){
				    	 
						 count++;	
						 BREAK=true;
					 }
					 break;
					 
				 case 2:					 
					 if(ifEndtwithStar()==true){
						 
						 count++;
						 BREAK=true;
					 }
					 break;
					 
				 case 3:
					 if(ifStartwithStar()==true){
						 
						 count++;
						 BREAK=true;
					 }
					 break;
					 
				 case 4:
					 if(ifNoStar()==true){
						 
						 count++;	
						 BREAK=true;
					 }
					 break;	
					 
				 }
				 if(BREAK==true)
					 break;
		 }
	 }
		
		 return count;		 
	}
}
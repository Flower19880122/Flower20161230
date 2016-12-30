package com.haiberg.automation.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class Java2word {
    
     private boolean saveOnExit;  
     Dispatch doc = null;  
     private   ActiveXComponent word;  
     private  Dispatch documents;
     
     public Java2word() {
    	 
         if(word==null){
        	 
         word = new ActiveXComponent("Word.Application");
         word.setProperty("Visible",new Variant(false));
         
         }
         if(documents==null)
        	 
         documents = word.getProperty("Documents").toDispatch();
         
         saveOnExit = false;
     }
    
    
     public void setSaveOnExit(boolean saveOnExit) {
    	 
         this.saveOnExit = saveOnExit;
     }
     
     
     public boolean getSaveOnExit() {
    	 
         return saveOnExit;
     }
    
    
     public Dispatch open(String inputDoc) {
    	 
         return Dispatch.call(documents,"Open",inputDoc).toDispatch();
         //return Dispatch.invoke(documents,"Open",Dispatch.Method,new Object[]{inputDoc},new int[1]).toDispatch();
     }
    
    
     public Dispatch select() {
    	 
         return word.getProperty("Selection").toDispatch();
     }
    
    
     public void moveUp(Dispatch selection,int count) {
    	 
         for(int i = 0;i < count;i ++)
        	 
             Dispatch.call(selection,"MoveUp");
     }
    
     public void moveDown(Dispatch selection,int count) {
    	 
         for(int i = 0;i < count;i ++)
        	 
             Dispatch.call(selection,"MoveDown");
     }
    
     
     public void moveLeft(Dispatch selection,int count) {
    	 
         for(int i = 0;i < count;i ++) 
        	 
             Dispatch.call(selection,"MoveLeft");
     }
    
     
     public void moveRight(Dispatch selection,int count) {
    	 
         for(int i = 0;i < count;i ++)
        	 
             Dispatch.call(selection,"MoveRight");
     }
    
     public void moveStart(Dispatch selection) {
    	 
         Dispatch.call(selection,"HomeKey",new Variant(6));
     }
    
     
     public boolean find(Dispatch selection,String toFindText) {
        
         Dispatch find = word.call(selection,"Find").toDispatch();       
         Dispatch.put(find,"Text",toFindText);         
         Dispatch.put(find,"Forward","True");       
         Dispatch.put(find,"Format","True");     
         Dispatch.put(find,"MatchCase","True");    
         Dispatch.put(find,"MatchWholeWord","True");
      
         return Dispatch.call(find,"Execute").getBoolean();
     }
    
     public void replace(Dispatch selection,String newText) {
       
         Dispatch.put(selection,"Text",newText);
     }
    

     public void replaceAll(Dispatch selection,String oldText,Object replaceObj) {
        
         moveStart(selection);
        
         if(oldText.startsWith("table") || replaceObj instanceof ArrayList)
        	 
             replaceTable(selection,oldText,(ArrayList) replaceObj);
         
         else {
        	 
             String newText = (String) replaceObj;
             
             if(newText==null)
            	 
                 newText="";
             
             if(oldText.indexOf("image") != -1&!newText.trim().equals("") || newText.lastIndexOf(".bmp") != -1 || newText.lastIndexOf(".jpg") != -1 || newText.lastIndexOf(".gif") != -1){
               
            	 while(find(selection,oldText)) {
            		 
                     replaceImage(selection,newText);
                     Dispatch.call(selection,"MoveRight");
                 }
             }else{
            	 
                 while(find(selection,oldText)) {
                	 
                     replace(selection,newText);
                     Dispatch.call(selection,"MoveRight");
                 }
             }
         }
     }
    
 
     public void replaceImage(Dispatch selection,String imagePath) {
    	 
         Dispatch.call(Dispatch.get(selection,"InLineShapes").toDispatch(),"AddPicture",imagePath);
     }
    

     public void replaceTable(Dispatch selection,String tableName,ArrayList dataList) {
    	 
         if(dataList.size() <= 1) {
        	 
             System.out.println("Empty table!");
             
             return;
         }
        
       
         String[] cols = (String[]) dataList.get(0);  
         String tbIndex = tableName.substring(tableName.lastIndexOf("@") + 1);        
         int fromRow = Integer.parseInt(tableName.substring(tableName.lastIndexOf("$") + 1,tableName.lastIndexOf("@")));     
         Dispatch tables = Dispatch.get(doc,"Tables").toDispatch();     
         Dispatch table = Dispatch.call(tables,"Item",new Variant(tbIndex)).toDispatch();      
         Dispatch rows = Dispatch.get(table,"Rows").toDispatch();
         
         for(int i = 1;i < dataList.size();i ++) {
             
             String[] datas = (String[]) dataList.get(i);
         
             if(Dispatch.get(rows,"Count").getInt() < fromRow + i - 1)
            	 
                 Dispatch.call(rows,"Add");
            
             for(int j = 0;j < datas.length;j ++) {
                
                 Dispatch cell = Dispatch.call(table,"Cell",Integer.toString(fromRow + i - 1),cols[j]).toDispatch();               
                 Dispatch.call(cell,"Select");               
                 Dispatch font = Dispatch.get(selection,"Font").toDispatch();
                 Dispatch.put(font,"Bold","0");
                 Dispatch.put(font,"Italic","0");              
                 Dispatch.put(selection,"Text",datas[j]);
             }
         }
     }
    
  
     public  void save(String outputPath) {
    	 
         Dispatch.call(Dispatch.call(word,"WordBasic").getDispatch(),"FileSaveAs",outputPath);
     }
    
 
     public void close(Dispatch doc) {
    	 
         Dispatch.call(doc,"Close",new Variant(saveOnExit));
         word.invoke("Quit",new Variant[]{});
         word = null;
     }
    
 
     public void toWord(String inputPath,String outPath,HashMap data) {
    	 
         String oldText;
         Object newValue;
         
         try {
        	 
             if(doc==null)
             doc = open(inputPath);           
             Dispatch selection = select();            
             Iterator keys = data.keySet().iterator();
             while(keys.hasNext()) {
            	 
                 oldText = (String) keys.next();
                 newValue = data.get(oldText);                
                 replaceAll(selection,oldText,newValue);
             }
            
             save(outPath);
         } catch(Exception e) {
        	 
             System.out.println("Operation failed!");
             e.printStackTrace();
         } finally {
        	 
             if(doc != null)
            	 
                 close(doc);
         }
     }
    
     public synchronized static void word(String inputPath,String outPath,HashMap data){
    	 
         Java2word j2w = new Java2word();
         j2w.toWord(inputPath,outPath,data);
     }
    
   
        
}
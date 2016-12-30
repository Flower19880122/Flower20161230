package com.haiberg.automation.util;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.util.ArrayList;  
import org.apache.poi.hssf.usermodel.HSSFCell;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.usermodel.Workbook;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  
  

  
/**  
* <p>Title: GetData</p>  
* <p>Project name: ZOEIIAuto</p>
* <p>Description: get data from els.TODO</p> 
* @author Adeng 
* @date Sep 23, 2014 5:39:26 PM 
* @version 1.0   
* <p>Copyright: 2014 www.haiberg.de Inc. All rights reserved.</p>
*/
public class GetData{  
  
	private int totalRows = 0;  
    private int totalCells = 0;  
    private String errorInfo;  
 
    public int getTotalRows(){  
  
        return totalRows;  
  
    }  
  
    public int getTotalCells(){  
  
        return totalCells;  
  
    }  
  
    public String getErrorInfo(){  
  
        return errorInfo;  
  
    }  
  
    public boolean validateExcel(String filePath){  
   
        if (filePath == null || !(WDWUtil.isExcel2003(filePath) || WDWUtil.isExcel2007(filePath))){  
  
            errorInfo = "The file is not excel format.";  
  
            return false;  
        }  
  
        File file = new File(filePath);  
  
        if (file == null || !file.exists()){  
  
            errorInfo = "The file does not exist!";  
            
            return false;  
  
        }  
  
        return true;  
  
    }
    
    public ArrayList<String> read(String filePath){  
    	
    	ArrayList<String> dataLst = new ArrayList<String>();  
  
        InputStream is = null;  
  
        try{  
  
            if (!validateExcel(filePath)){  
  
                System.out.println(errorInfo);  
  
                return null;  
  
            }  
  
            boolean isExcel2003 = true;  
  
            if (WDWUtil.isExcel2007(filePath)){  
  
                isExcel2003 = false;  
  
            }  
   
            File file = new File(filePath);  
  
            is = new FileInputStream(file);  
  
            dataLst = read(is,isExcel2003);  
  
            is.close();  
  
        }  
        catch (Exception ex){  
  
            ex.printStackTrace();  
  
        }  
        finally{  
  
            if (is != null){  
  
                try{  
  
                    is.close();  
  
                }  
                catch (IOException e){  
  
                    is = null;  
  
                    e.printStackTrace();  
  
                }  
  
            }  
  
        }  
  
        return dataLst;  
  
    } 
    
    public ArrayList<String> read(InputStream inputStream, boolean isExcel2003){  
  
        ArrayList<String> dataLst = null;  
  
        try{  
   
            Workbook wb = null;  
  
            if (isExcel2003){  
            	
                wb = new HSSFWorkbook(inputStream);  
            }  
            else{  
            	
                wb = new XSSFWorkbook(inputStream);  
            }  
            
            dataLst = read(wb);  
  
        }  
        catch (IOException e){  
  
            e.printStackTrace();  
  
        }  
  
        return dataLst;  
  
    }  
    
    
    private ArrayList<String> read(Workbook wb){  
    	  
        ArrayList<String> dataLst = new ArrayList<String>();  
        Sheet sheet = wb.getSheetAt(0);  
        this.totalRows = sheet.getPhysicalNumberOfRows();  
        
        if (this.totalRows >= 1 && sheet.getRow(0) != null) {  
  
            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();  
  
        }  
        
        Row rowmark=sheet.getRow(0);
 
        for (int r = 1; r < this.totalRows; r++){  
  
            Row row = sheet.getRow(r);  
  
            if (row == null){  
  
                continue;  
  
            }  
  
          //  Hashtable<String,String> rowLst = new Hashtable<String,String>();  
     
            for (int c = 0; c < this.getTotalCells(); c++){  
  
                Cell cell = row.getCell(c);  
                String first=rowmark.getCell(c).getStringCellValue();
           
                String cellValue = "";  
  
                if (null != cell){  
                   
                    switch (cell.getCellType()){  
                    
                    case HSSFCell.CELL_TYPE_NUMERIC: 
                        cellValue = cell.getNumericCellValue() + "";  
                        break;  

                    case HSSFCell.CELL_TYPE_STRING:  
                        cellValue = cell.getStringCellValue()+ "";  
                        break;  
  
                    case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean  
                        cellValue = cell.getBooleanCellValue() + "";  
                        break;  
  
                    case HSSFCell.CELL_TYPE_FORMULA: 
                        cellValue = cell.getCellFormula() + "";  
                        break;  
  
                    case HSSFCell.CELL_TYPE_BLANK: 
                        cellValue = "";  
                        break;  
  
                    case HSSFCell.CELL_TYPE_ERROR: //  
                        cellValue = "Illegal characters";  
                        break;  
  
                    default:  
                        cellValue = "unknown type";  
                        break;  
                    }  
                    
                    dataLst.add(cellValue);
                   
                } 
  
            }  
       }  
  
        return dataLst;  
  
    }  
    
    
  /*  private ArrayList<Hashtable<String,String>> read(Workbook wb){  
  
        ArrayList<Hashtable<String,String>> dataLst = new ArrayList<Hashtable<String,String>>();  
        Sheet sheet = wb.getSheetAt(0);  
        this.totalRows = sheet.getPhysicalNumberOfRows();  
        
        if (this.totalRows >= 1 && sheet.getRow(0) != null) {  
  
            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();  
  
        }  
        
        Row rowmark=sheet.getRow(0);
 
        for (int r = 1; r < this.totalRows; r++){  
  
            Row row = sheet.getRow(r);  
  
            if (row == null){  
  
                continue;  
  
            }  
  
            Hashtable<String,String> rowLst = new Hashtable<String,String>();  
     
            for (int c = 0; c < this.getTotalCells(); c++){  
  
                Cell cell = row.getCell(c);  
                String first=rowmark.getCell(c).getStringCellValue();
           
                String cellValue = "";  
  
                if (null != cell){  
                   
                    switch (cell.getCellType()){  
                    
                    case HSSFCell.CELL_TYPE_NUMERIC: 
                        cellValue = cell.getNumericCellValue() + "";  
                        break;  

                    case HSSFCell.CELL_TYPE_STRING:  
                        cellValue = cell.getStringCellValue()+ "";  
                        break;  
  
                    case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean  
                        cellValue = cell.getBooleanCellValue() + "";  
                        break;  
  
                    case HSSFCell.CELL_TYPE_FORMULA: 
                        cellValue = cell.getCellFormula() + "";  
                        break;  
  
                    case HSSFCell.CELL_TYPE_BLANK: 
                        cellValue = "";  
                        break;  
  
                    case HSSFCell.CELL_TYPE_ERROR: //  
                        cellValue = "Illegal characters";  
                        break;  
  
                    default:  
                        cellValue = "unknown type";  
                        break;  
                    }  
                }  
               
                rowLst.put(first, cellValue);
                dataLst.add(rowLst);  
  
            }  

            //dataLst.add(rowLst);  
            
        }  
  
        return dataLst;  
  
    }  
    */
    public static ArrayList<String> getGroupData(String a){
    	
    	GetData poi = new GetData();  
    	ArrayList<String> list = poi.read(a);  
    	
    	return list;
    }
}
  
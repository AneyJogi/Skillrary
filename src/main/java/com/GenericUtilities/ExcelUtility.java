package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * This method will read data from excel sheet
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @throws Throwable
	 */
	public String readDataFromExcel(String SheetName,int RowNo,int ColumnNo) throws Throwable 
	{
		
	FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet Sh= wb.getSheet(SheetName);
	String value = Sh.getRow(RowNo).getCell(ColumnNo).getStringCellValue();
	System.out.println(value);
	 return value;

    }
	
	/**
	 * This method will get last row number
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public  int getLastRowNumber(String SheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet(SheetName);
		int count= sh.getLastRowNum();
		return count;
	}
	
	/**
	 * This method will write data into excel sheet
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @param data
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String SheetName,int RowNo,int ColumnNo,String data) throws Throwable 
	{
		
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet Sh= wb.getSheet(SheetName);
		Sh.getRow(RowNo).createCell(ColumnNo).setCellValue(data);
		FileOutputStream fout= new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fout);
		
	}
	
	
	/**
	 * This method will read mutiple  data from excel sheet
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public  HashMap<String, String> readMultipleData(String SheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet(SheetName);
		int count= sh.getLastRowNum();
		
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0;i<=count;i++)
		{
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key,value);
		}
		return map;
	}
		
	
	
	public Object[][] readMultipleDataSet() throws Throwable
	{
		FileInputStream fis= new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("DataproviderDetails");
		int lastRow=sh.getLastRowNum()+1;
		int lastCel = sh.getRow(0).getLastCellNum();
		
		Object[][] obj= new Object[lastRow][lastCel];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCel;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj; 
	}
}


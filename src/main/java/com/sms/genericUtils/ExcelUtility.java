package com.sms.genericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Subhadip Ganguly
 *
 */
public class ExcelUtility
{
	/**
	 * This method is used to fetch the data from excel
	 * @param sheetno
	 * @param rowno
	 * @param cellno
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcel(String sheetname,int rowno,int cellno) throws Throwable
	{
		Workbook book = WorkbookFactory.create(new FileInputStream(IpathConstants.excelPath));
		Sheet sh = book.getSheet(sheetname);
		Row r = sh.getRow(rowno);
		Cell c = r.getCell(cellno);
		String data = c.toString();
		return data;
	}
	
	/**
	 * This method is used to count the row number
	 * @param sheetname
	 * @return
	 * @throws Throwable
	 */
	public int rowCount(String sheetname) throws Throwable
	{
		Workbook book = WorkbookFactory.create(new FileInputStream(IpathConstants.excelPath));
		Sheet sh = book.getSheet(sheetname);
		int row = sh.getLastRowNum();
		return row;
	}
	
	/**
	 * This method is used to write data in excel
	 * @param sheetname
	 * @param rowno
	 * @param celno
	 * @param value
	 * @throws Throwable
	 */
	public void writeDataInExcel(String sheetname,int rowno,int celno,String value) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.excelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetname);
		sh.createRow(rowno).createCell(celno).setCellValue(value);
		
		FileOutputStream fout = new FileOutputStream(IpathConstants.excelPath);
		book.write(fout);
		book.close();
	}
	
	/**
	 * This method is used to fetch multiple data from excel
	 * @param sheetname
	 * @param keycolumn
	 * @param valuecolumn
	 * @param driver
	 * @return
	 * @throws Throwable
	 */
	public HashMap<String, String> getMultipleDataFromExcel(String sheetname,int keycolumn,int valuecolumn,WebDriver driver) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int count = sh.getLastRowNum();
		
		HashMap<String, String> map = new HashMap<>();
		
		for(int i=1;i<=count;i++)
		{
			String key = sh.getRow(i).getCell(keycolumn).getStringCellValue();
			String value = sh.getRow(i).getCell(valuecolumn).getStringCellValue();
			map.put(key, value);
		}
		for(Entry<String, String> s:map.entrySet())
		{
				driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
		}
		return map;
	}
	
	/**
	 * Fetch data from excel and use it in Dataprovider
	 * @param sheetname
	 * @return 
	 * @return
	 * @throws Throwable
	 */
	public Object[][] getMultipleData(String sheetname) throws Throwable
	{
	FileInputStream fis = new FileInputStream(IpathConstants.excelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetname);
	int lastRow = sh.getLastRowNum()+1;
	int lastCell = sh.getRow(0).getLastCellNum();
	
	Object[][] obj = new Object[lastRow][lastCell];
	
	for(int i=0;i<lastRow;i++)
	{
		for(int j=0;j<lastCell;j++)
		{
			obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
		}
	}
	return obj;
	}
}

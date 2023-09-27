package genericsUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.testng.annotations.DataProvider;

/**
 * @author Anjali
 */
public class ExcelUtility extends JavaUtility
{
	/**
	 * This method will return the value present in a particular cell
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcelSheet(String sheetName,int rowNum,int cellNum) throws Throwable 
	{
		FileInputStream fis=new FileInputStream(IPathConstants.excelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		String value=sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;		
		
	}
	/**
	 * This method will help to write data into excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param value
	 * @throws Throwable
	 */
	public void writeDataIntoExcelSheet(String sheetName,int rowNum,int cellNum,String value) throws Throwable 
	{
		FileInputStream fis=new FileInputStream(IPathConstants.excelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell=row.createCell(cellNum);
		cell.setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream(IPathConstants.excelFilePath);
		wb.write(fos);
		wb.close();
	}
	/**
	 * This method is used to fetch row count in created excel sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int countRowNumInExcelSheet(String sheetName) throws Throwable 
	{
		FileInputStream fis=new FileInputStream(IPathConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int count=sheet.getLastRowNum();
		return count;
		
		
	}
	/**
	 * This method is used to get multiple data from excel sheet
	 * @param sheetName
	 * @param keyColumn
	 * @param cellColumn
	 * @param driver
	 * @param iLab
	 * @return
	 * @throws Throwable
	 */
	public HashMap<String, String> getMultipleDataFromExcel(String sheetName,int keyColumn,int cellColumn,WebDriver driver,JavaUtility jLib) throws Throwable{
		FileInputStream fis=new FileInputStream(IPathConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		 Sheet sheet = wb.getSheet(sheetName);
		 int count=sheet.getLastRowNum();
		 HashMap<String, String> map=new HashMap<String, String>();
		 for (int i = 1; i <=count; i++)
		 {
			String key = sheet.getRow(i).getCell(keyColumn).getStringCellValue();
			String value = sheet.getRow(i).getCell(cellColumn).getStringCellValue();
			map.put(key, value);
		}
		 for(Entry<String, String> set:map.entrySet()) 
		 {
			 if(set.getKey().contains("username")) 
			 {
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+getRandomNumber());
				//driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+jLib.getRandomNumber());

				 }
		 else
		 {
				 driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			 
		 }
	
	}
			return map;
}
/***
 * This method will fetch  multiple sets of data from excel sheet
 * @return 
 * @return
 * @throws Throwable 
 * @throws Throwable
 */
		public Object[][] getMultiSetsOfsData(String sheetName) throws Throwable {
			FileInputStream fis=new FileInputStream(IPathConstants.excelFilePath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheet(sheetName);
			int lastRowNum=s.getLastRowNum()+1;
			int lastCellNum=s.getRow(0).getLastCellNum();
			Object[][] obj=new Object[lastRowNum][lastCellNum];
			for(int i=0;i<lastRowNum;i++) {
				for(int j=0;j<lastCellNum;j++) {
					obj[i][j]=s.getRow(i).getCell(j).getStringCellValue();
				}
			}
			
			return obj;
			
		}
	}


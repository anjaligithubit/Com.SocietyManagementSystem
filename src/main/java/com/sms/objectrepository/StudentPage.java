package com.sms.objectrepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sms.genericUtils.WebdriverUtility;

public class StudentPage extends WebdriverUtility
{
	//declaration
	@FindBy (xpath =  "//button[@id='add_student']")
	private WebElement addStudentBtn;
	
	@FindBy (name = "student_id")
	private WebElement sidtxt;
	
	@FindBy (name = "firstname")
	private WebElement firstNametxt;
	
	@FindBy (name = "lastname")
	private WebElement lastNametxt;
	
	@FindBy (name = "section")
	private WebElement sectiontxt;
	
	@FindBy (name = "year")
	private WebElement yeardd;
	
	@FindBy (name = "save_student")
	private WebElement savebtn;
	
	//initialization
	public StudentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getAddStudentBtn() {
		return addStudentBtn;
	}

	public WebElement getSidtxt() {
		return sidtxt;
	}

	public WebElement getFirstNametxt() {
		return firstNametxt;
	}

	public WebElement getLastNametxt() {
		return lastNametxt;
	}

	public WebElement getSectiontxt() {
		return sectiontxt;
	}

	public WebElement getYeardd() {
		return yeardd;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	//Business Library
	public void clickOnAddStudent()
	{
		addStudentBtn.click();
	}
	public void createStudent(String sid,String fstname,String lastName,String section,String ddtxt)
	{
		sidtxt.sendKeys(sid);
		firstNametxt.sendKeys(fstname);
		lastNametxt.sendKeys(lastName);
		sectiontxt.sendKeys(section);
		selectDropdown(ddtxt, yeardd);
		savebtn.click();
	}
	public void addStudent(HashMap<String, String> map,WebDriver driver,String ddtxt)
	{
		for(Entry<String, String> s:map.entrySet())
		{
				driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
		}
		
		selectDropdown(ddtxt, yeardd);
		savebtn.click();
	}
}

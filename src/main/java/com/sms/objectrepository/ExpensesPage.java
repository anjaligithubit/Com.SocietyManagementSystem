package com.sms.objectrepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sms.genericUtils.WebdriverUtility;

public class ExpensesPage extends WebdriverUtility
{
	//declaration
	@FindBy (xpath = "//button[@id='add_expenses']")
	private WebElement addExpensesbtn;
	
	@FindBy (name = "detail")
	private WebElement detailtxt;
	
	@FindBy (name = "price")
	private WebElement pricetxt;
	
	@FindBy (name = "ay1")
	private WebElement ayStart;
	
	@FindBy (name = "ay2")
	private WebElement ayEnd;
	
	@FindBy (name = "sem")
	private WebElement semdd;
	
	@FindBy (name = "deadline")
	private WebElement deadline;
	
	@FindBy (name = "save_expenses")
	private WebElement savebtn;
	
	//initialization
	public ExpensesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getAddExpensesbtn() {
		return addExpensesbtn;
	}

	public WebElement getDetailtxt() {
		return detailtxt;
	}

	public WebElement getPricetxt() {
		return pricetxt;
	}

	public WebElement getAyStart() {
		return ayStart;
	}

	public WebElement getAyEnd() {
		return ayEnd;
	}

	public WebElement getSemdd() {
		return semdd;
	}

	public WebElement getDeadline() {
		return deadline;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	//Business Library
	public void clickOnAddExpenses()
	{
		addExpensesbtn.click();
	}
	public void createExpenses(String detail,String price,String ay1,String ay2,String sem,String date)
	{
		
		detailtxt.sendKeys(detail);
		pricetxt.sendKeys(price);
		ayStart.sendKeys(ay1);
		ayEnd.sendKeys(ay2);
		selectDropdown(sem, semdd);
		deadline.sendKeys(date);
		savebtn.click();
	}
	public void createExpenses(HashMap<String, String> map,WebDriver driver,String sem,String date)
	{
		for(Entry<String, String> s:map.entrySet())
		{
				driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
		}
		
		selectDropdown(sem, semdd);
		deadline.sendKeys(date);
		savebtn.click();
	}
}

package com.sms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sms.genericUtils.WebdriverUtility;

public class TransactionPage extends WebdriverUtility
{
	//declaration
	@FindBy (id = "search")
	private WebElement enterStudentIdtxt;
	
	@FindBy (id = "btn_search")
	private WebElement searchbtn;
	
	@FindBy (xpath = "//select[@class='form-control status']")
	private WebElement statusdd;
	
	@FindBy (xpath = "//select[@class='form-control expenses']")
	private WebElement expensesdd;
	
	@FindBy (xpath = "//input[@class='form-control payment']")
	private WebElement paymenttxt;
	
	@FindBy (xpath = "// button[.=' Cash Invoice']")
	private WebElement cashInvoiceBtn;
	
	//initialization
	public TransactionPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getEnterStudentIdtxt() {
		return enterStudentIdtxt;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getStatusdd() {
		return statusdd;
	}

	public WebElement getExpensesdd() {
		return expensesdd;
	}

	public WebElement getPaymenttxt() {
		return paymenttxt;
	}

	public WebElement getCashInvoiceBtn() {
		return cashInvoiceBtn;
	}
	
	//Business Library
	public void transaction(String sid,String status,String expenses,String pay)
	{
		enterStudentIdtxt.sendKeys(sid);
		searchbtn.click();
		selectDropdown(status, statusdd);
		selectDropdown(expenses, expensesdd);
		paymenttxt.sendKeys(pay);
		cashInvoiceBtn.click();
		
	}
}


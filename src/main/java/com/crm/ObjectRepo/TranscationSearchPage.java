package com.crm.ObjectRepo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericsUtils.WebDriverUtility;

public class TranscationSearchPage extends WebDriverUtility
{
	@FindBy(id = "search")
	private WebElement searchEdt;
	@FindBy(id = "btn_search")
	private WebElement searchtn;
	@FindBy(xpath = "//select[@class='form-control status']")
	private WebElement statusDropDown;
	@FindBy(xpath = "//select[@class='form-control expenses']")
	private WebElement expensesDropDown;
	@FindBy(xpath = "//input[@class='form-control payment']")
	private WebElement paymentEdt;
	@FindBy(id = "btn_cash")
	private WebElement cashInvoiceBtn;
	public TranscationSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getSearchEdt() {
		return searchEdt;
	}
	public WebElement getSearchtn() {
		return searchtn;
	}
	public WebElement getStatusDropDown() {
		return statusDropDown;
	}
	public WebElement getExpensesDropDown() {
		return expensesDropDown;
	}
	public WebElement getPaymentEdt() {
		return paymentEdt;
	}
	public WebElement getCashInvoiceBtn() {
		return cashInvoiceBtn;
	}
	public void validateTranscationPageDisplayedOrNotMethod(WebDriver driver) {
		String StudentTranscation=driver.findElement(By.xpath("//div[@class=\"alert alert-info\"]")).getText();
		if(StudentTranscation.contains("Transaction")) 
		{
			System.out.println("navigated to student transcation page");
		}
		else
		{
			System.out.println("not navigated to student transcation page");
		}
	}

	public void createCashInvoice(String statusText,String expText,String payment  ) {
		 statusDropDown.click();
			selectDropDown(statusText, statusDropDown); 
			expensesDropDown.click();
			selectDropDown(expText, expensesDropDown);
			paymentEdt.sendKeys(payment);
			cashInvoiceBtn.click();
			
	}
	
}

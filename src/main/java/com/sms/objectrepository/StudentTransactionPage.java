package com.sms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentTransactionPage 
{
	//declaration
	@FindBy (id = "student_id")
	private WebElement sidtxt;
	
	@FindBy (id = "student_login")
	private WebElement studentLoginbtn;
	
	@FindBy (xpath = "//a[.='View Transaction']")
	private WebElement viewTransactionLink;
	
	@FindBy (xpath = "//a[.='Logout']")
	private WebElement logoutLink;
	
	@FindBy (xpath = "//a[.='Balance']")
	private WebElement balanceLink;
	
	@FindBy (xpath = "//a[.='Paid']")
	private WebElement paidLink;
	
	@FindBy (xpath = "//span[@class='close pull-right glyphicon glyphicon-remove']")
	private WebElement crossmark;
	
	//initialization
	public StudentTransactionPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getSidtxt() {
		return sidtxt;
	}

	public WebElement getStudentLoginbtn() {
		return studentLoginbtn;
	}

	public WebElement getViewTransactionLink() {
		return viewTransactionLink;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getBalanceLink() {
		return balanceLink;
	}

	public WebElement getPaidLink() {
		return paidLink;
	}

	public WebElement getCrossmark() {
		return crossmark;
	}
	
	//Business library
	public void ViewTransaction(String sid)
	{
		sidtxt.sendKeys(sid);
		studentLoginbtn.click();
		viewTransactionLink.click();
	}
	
	public void clickOnBalance()
	{
		balanceLink.click();
	}
	
	public void clickOnPaid()
	{
		paidLink.click();
	}
	
	public void clickOnLogout()
	{
		crossmark.click();
		logoutLink.click();
	}
}

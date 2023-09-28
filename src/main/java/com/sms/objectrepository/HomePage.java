package com.sms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	//declaration
	@FindBy(xpath = "//a[.=' Accounts']")
	private WebElement accountslink;
	
	@FindBy (xpath = "//a[.=' Activities']")
	private WebElement activitieslink;
	
	@FindBy(xpath = "//a[.=' Expenses']")
	private WebElement expenseslink;
	
	@FindBy (xpath = "//a[.=' Transaction']")
	private WebElement transactionlink;
	
	@FindBy (xpath = "//a[.=' Administrator']")
	private WebElement administratorlink;
	
	@FindBy (xpath = "//a[.=' Student']")
	private WebElement studentlink;
	
	@FindBy (xpath = "//a[.=' Options']")
	private WebElement optionslink;

	@FindBy (xpath = "//a[.=' Logout']")
	private WebElement logoutbtn;
	
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getAccountslink() {
		return accountslink;
	}

	public WebElement getActivitieslink() {
		return activitieslink;
	}

	public WebElement getExpenseslink() {
		return expenseslink;
	}

	public WebElement getTransactionlink() {
		return transactionlink;
	}

	public WebElement getAdministratorlink() {
		return administratorlink;
	}

	public WebElement getStudentlink() {
		return studentlink;
	}

	public WebElement getOptionslink() {
		return optionslink;
	}

	public WebElement getLogoutbtn() {
		return logoutbtn;
	}
	
	//Business Library
	public void account()
	{
		accountslink.click();
	}
	
	public void activities()
	{
		activitieslink.click();
	}
	
	public void expenses()
	{
		expenseslink.click();
	}
	
	public void transaction()
	{
		transactionlink.click();
	}
	
	public void administrator()
	{
		administratorlink.click();
	}
	
	public void student()
	{
		studentlink.click();
	}
	
	public void logout()
	{
		optionslink.click();
		logoutbtn.click();
	}
}

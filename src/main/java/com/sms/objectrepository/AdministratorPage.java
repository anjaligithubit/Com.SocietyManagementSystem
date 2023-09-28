package com.sms.objectrepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sms.genericUtils.ExcelUtility;

public class AdministratorPage extends ExcelUtility
{
	//declaration
	@FindBy (id = "add_admin")
	private WebElement addAdminBtn;
	
	@FindBy (name = "username")
	private WebElement usernametxt;
	
	@FindBy (name = "password")
	private WebElement passwordtxt;
	
	@FindBy (name = "name")
	private WebElement nametxt;
	
	@FindBy (name = "save_admin")
	private WebElement savebtn;
	
	@FindBy (xpath = "//div[@class='alert alert-info']")
	private WebElement administratorAccountPage;
	
	//initialization
	public AdministratorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getAddAdminBtn() {
		return addAdminBtn;
	}

	public WebElement getUsernametxt() {
		return usernametxt;
	}

	public WebElement getPasswordtxt() {
		return passwordtxt;
	}

	public WebElement getNametxt() {
		return nametxt;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getAdministratorAccountPage() {
		return administratorAccountPage;
	}
	
	//Business Library
	public void clickOnAddAdmin()
	{
		addAdminBtn.click();
	}
	
	public void createAdmin(String un,String pwd,String name)
	{
		usernametxt.sendKeys(un);
		passwordtxt.sendKeys(pwd);
		nametxt.sendKeys(name);
	}
	
	public void addAdmin(HashMap<String, String> map,WebDriver driver)
	{
		for(Entry<String, String> s:map.entrySet())
		{
				driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
		}
	}
	
	public void saveAdmin()
	{
		savebtn.click();
	}
	
	public void adminPageValidate()
	{
		String expmsg = "Accounts/Administrator";
		String actmsg = administratorAccountPage.getText();
		if(actmsg.contains(expmsg))
		{
			System.out.println("Admin page is displayed");
		}
		else
		{
			System.out.println("Admin page is not displayed");
		}
	}

}

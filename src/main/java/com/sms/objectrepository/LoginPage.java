package com.sms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	//declaration
	@FindBy(id = "username")
	private WebElement usernametxt;
	
	@FindBy(id = "password")
	private WebElement passwordtxt;
	
	@FindBy(id = "login")
	private WebElement loginbtn;
	
	//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getUsernametxt() {
		return usernametxt;
	}

	public WebElement getPasswordtxt() {
		return passwordtxt;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	//Business Library
	public void login(String un,String pwd)
	{
		usernametxt.sendKeys(un);
		passwordtxt.sendKeys(pwd);
		loginbtn.click();
	}

}

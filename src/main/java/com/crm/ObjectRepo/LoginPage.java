package com.crm.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
@FindBy(id = "username")
private  WebElement usernameEdt;

@FindBy(id = "password")
private WebElement passwordEdt;

@FindBy(id = "login")
private WebElement loginBtn;


public LoginPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getUsernameEdt() 
{
	return usernameEdt;
}

public WebElement getPasswordEdt()
{
	return passwordEdt;
}

public WebElement getLoginBtn()
{
	return loginBtn;
}

public void loginMethod(String username,String password)
{
	usernameEdt.sendKeys(username);
	passwordEdt.sendKeys(password);
	loginBtn.click();
}
public void homePageValidateMethod(WebDriver driver) {
	String expected="http://rmgtestingserver/domain/Society_Management_System/admin/";
	//validate homepage is displayed 
	String acutal=driver.getCurrentUrl();
	if(acutal.contains(expected))
	{
		System.out.println("navigate to home page");
	}
	else 
	{
		System.out.println("not navigated to home page");
	}
}
}
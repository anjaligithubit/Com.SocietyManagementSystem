package com.crm.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdministratorPage
{

@FindBy(id = "add_admin")
private WebElement addAdminBtn;

@FindBy(linkText = " entries")
private WebElement entriesDropDown;

@FindBy(linkText = "Search:")
private WebElement serachTextField;

@FindBy(linkText = " Update")
private WebElement upadteBtn;

@FindBy(linkText = " Delete")
private WebElement deleteBtn;

@FindBy(linkText = "Previous")
private WebElement previousBtn;

@FindBy(linkText = "Next")
private WebElement nextBtn;
public AdministratorPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public WebElement getAddAdminBtn() {
	return addAdminBtn;
}
public WebElement getEntriesDropDown() {
	return entriesDropDown;
}
public WebElement getSerachTextField() {
	return serachTextField;
}
public WebElement getUpadteBtn() {
	return upadteBtn;
}
public WebElement getDeleteBtn() {
	return deleteBtn;
}
public WebElement getPreviousBtn() {
	return previousBtn;
}
public WebElement getNextBtn() {
	return nextBtn;
}
public void clickOnAddAdminButtonMethod() {
	addAdminBtn.click();
}
public void adminPagevalidateMethod(WebDriver driver) {
	String adminPage=driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText();
	if(adminPage.contains("Accounts/Administrator")) 
	{
		System.out.println("naviagted to admin page");
	}
	else 
	{
		System.out.println("not naviagated to admin page");
	}
}


}

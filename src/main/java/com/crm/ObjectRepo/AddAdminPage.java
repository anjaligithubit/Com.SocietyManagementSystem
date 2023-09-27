package com.crm.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericsUtils.JavaUtility;

public class AddAdminPage 
{
@FindBy(name = "username")
private WebElement userNameEdt;
@FindBy(name = "password")
private WebElement passwordEdt;
@FindBy(name = "name")
private WebElement nameEdt;
@FindBy(name = "save_admin")
private WebElement saveBtn;
public AddAdminPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public WebElement getUserNameEdt() {
	return userNameEdt;
}
public WebElement getPasswordEdt() {
	return passwordEdt;
}
public WebElement getNameEdt() {
	return nameEdt;
}
public WebElement getSaveBtn() {
	return saveBtn;
}
public void addAdminMethod(String UN,String PWD,String NAME) {
	userNameEdt.sendKeys(UN);
	passwordEdt.sendKeys(PWD);
	nameEdt.sendKeys(NAME);
	saveBtn.click();
}
public void addNewAdminPageValidateMethod(WebDriver driver) {
	String addAdminPage=driver.findElement(By.xpath("//div[@class=\"alert alert-success\"]")).getText();
	if(addAdminPage.contains("Accounts/Administrator/Add new"))
	{
		System.out.println("naviagted to add new page");
	}
	else 
	{
		System.out.println("not naviagated to add new page");
	}
}
public void createAdminAccount(HashMap<String, String> map,WebDriver driver,JavaUtility jLib) {
	 for(Entry<String, String> set:map.entrySet()) 
	 {
//		 if(set.getKey().contains("username")) 
//		 {
////			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+getRandomNumber());
//			//driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+jLib.getRandomNumber());//
//
//			 }
	
 
		 driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
	 

}
}
public void validateAccountCreatedOrNotMethod(WebDriver driver) {
	String	adminPage=driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText();
	if(adminPage.contains("Accounts/Administrator")) 
	{
		System.out.println("account created successfully");
	}
	else 
	{
		System.out.println("account not created");
	}
}

}

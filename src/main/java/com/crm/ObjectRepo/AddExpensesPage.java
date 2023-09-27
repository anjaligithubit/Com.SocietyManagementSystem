package com.crm.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericsUtils.JavaUtility;
import genericsUtils.WebDriverUtility;

public class AddExpensesPage extends WebDriverUtility
{
@FindBy(name = "detail")
private WebElement detailEdt;
@FindBy(name = "price")
private WebElement priceEdt;
@FindBy(name = "ay1")
private WebElement ay1Edt;
@FindBy(name = "ay2")
private WebElement ay2Edt;
@FindBy(name = "sem")
private WebElement semesterDD;
@FindBy(name = "deadline")
private WebElement deadlineEdt;
@FindBy(name = "save_expenses")
private WebElement saveBtn;
public AddExpensesPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public WebElement getDetailEdt() {
	return detailEdt;
}
public WebElement getPriceEdt() {
	return priceEdt;
}
public WebElement getAy1Edt() {
	return ay1Edt;
}
public WebElement getAy2Edt() {
	return ay2Edt;
}
public WebElement getSemesterEdt() {
	return semesterDD;
}
public WebElement getDeadlineEdt() {
	return deadlineEdt;
}
public WebElement getSaveBtn() {
	return saveBtn;
}
public void addExpensesPageDisplayedOrNotMethod(WebDriver driver) {
	String addExpensesPage = driver.findElement(By.xpath("//div[@class=\"alert alert-success\"]")).getText();
	if(addExpensesPage.contains("Expenses/Add new"))
	{
		System.out.println("navigated to add expenses page");
	}
	else 
	{
		System.out.println("not navigated to add expenses page");
	}
}

public void addExpenses(HashMap<String, String> map,WebDriver driver,JavaUtility jLib,String text) {
	for(Entry<String, String> set:map.entrySet()) 
	 {
		 if(set.getKey().contains("username")) 
		 {
//			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+getRandomNumber());
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+jLib.getRandomNumber());

			 }
	 else
	 {
			 driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		 
	 }
		 
}
	selectDropDown(text, semesterDD);
	 saveBtn.click();
}
public void validateExpensesAddedOrNotMethod(WebDriver driver) {
	String expensesPage = driver.findElement(By.xpath("//div[@class=\"alert alert-info\"]")).getText();
	if(expensesPage.contains("Expenses"))
	{
		System.out.println("expenses successfully saved");
	}
	else
	{
		System.out.println("expenses not saved");
	}
}
}




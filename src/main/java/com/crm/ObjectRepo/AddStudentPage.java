package com.crm.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericsUtils.WebDriverUtility;

public class AddStudentPage extends WebDriverUtility
{
@FindBy(name = "student_id")
private WebElement studentIdEdt;

@FindBy(name = "firstname")
private WebElement firstNameEdt;

@FindBy(name = "lastname")
private WebElement lastNameEdt;

@FindBy(name = "year")
private WebElement yearDropDown;

@FindBy(name = "section")
private WebElement sectionEdt;

@FindBy(name = "image")
private WebElement chooseImageBtn;

@FindBy(name = "save_student")
private WebElement saveBtn;
public AddStudentPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
public WebElement getStudentIdEdt() {
	return studentIdEdt;
}
public WebElement getFirstNameEdt() {
	return firstNameEdt;
}
public WebElement getLastNameEdt() {
	return lastNameEdt;
}
public WebElement getYearDropDown() {
	return yearDropDown;
}
public WebElement getSectionEdt() {
	return sectionEdt;
}
public WebElement getChooseImageBtn() {
	return chooseImageBtn;
}
public WebElement getSaveBtn() {
	return saveBtn;
}
public void validateAddStudentPageDisplayedOrNotMethod(WebDriver driver) {
	String addNewStudent = driver.findElement(By.xpath("//div[@class=\"alert alert-success\"]")).getText();
	if(addNewStudent.contains("Accounts/Student/Add new")) 
	{
		System.out.println("navigated to add new student page");
	}
	else 
	{
		System.out.println("not navigated to add new student page");
	}
}
public void addNewStudentWithDetailsMethod(String studentId,String firstName,String lastName,String yearText,String section) 
{
	studentIdEdt.sendKeys(studentId);
	firstNameEdt.sendKeys(firstName);
	lastNameEdt.sendKeys(lastName);
	selectDropDown(yearText, yearDropDown);
	sectionEdt.sendKeys(section);
	saveBtn.click();
}

}

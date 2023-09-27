package com.crm.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentPage 
{
@FindBy(id = "add_student")
private WebElement addStudentBtn;


public StudentPage(WebDriver driver){
	PageFactory.initElements(driver, this);
}


public WebElement getAddStudentBtn() {
	return addStudentBtn;
}
public void validateStudentPageDisplayedOrNotMethod(WebDriver driver) {
	String studentPage = driver.findElement(By.xpath("//div[@class=\"alert alert-info\"]")).getText();
	if(studentPage.contains("Accounts/Student"))
	{
		System.out.println("navigated to student page");
	}
	else 
	{
		System.out.println("not naviagted to student page");
	}
}
public void clickOnAddStudentMethod() {
	addStudentBtn.click();
}
public void studentIdCreatedOrNotMethod(WebDriver driver) {
	String	addNewStudent = driver.findElement(By.xpath("//div[@class=\"alert alert-info\"]")).getText();
	if(addNewStudent.contains("Accounts/Student"))
	{
		System.out.println("student id created");
	}
	else 
	{
		System.out.println("student id not created");
	}
}
}

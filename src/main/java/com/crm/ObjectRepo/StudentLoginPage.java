package com.crm.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentLoginPage {
	@FindBy(id = "student_id")
	private WebElement studentIdEdt;
	@FindBy(id = "student_login")
private WebElement studentLoginBtn;
	@FindBy(linkText = "Activities")
private WebElement activitiesBtn;
	public StudentLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getStudentIdEdt() {
		return studentIdEdt;
	}
	public WebElement getStudentLoginBtn() {
		return studentLoginBtn;
	}
	public WebElement getActivitiesBtn() {
		return activitiesBtn;
	}
	public void loginStudentMethod(String studentId) {
		studentIdEdt.sendKeys(studentId);
		studentLoginBtn.click();
	}
}

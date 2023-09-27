package com.crm.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentHomePage {
	@FindBy(xpath = "//a[.='View Transaction']")
	private WebElement viewTranscationBtn;
	@FindBy(xpath = "//a[.='Logout']")
	private WebElement logoutBtn;
	public StudentHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getViewTranscationBtn() {
		return viewTranscationBtn;
	}
	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	public void clickOnViewTranscation() {
		viewTranscationBtn.click();
	}
	public void studentLogout() {
		logoutBtn.click();
	}
	

}

package com.crm.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage
{
@FindBy(xpath = "//a[.=' Options']")
private WebElement optionsBtn;
@FindBy(xpath = "//a[.=' Logout']")
private WebElement logOutBtn;
public LogoutPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	
}
public WebElement getOptionsBtn() {
	return optionsBtn;
}
public WebElement getLogOutBtn() {
	return logOutBtn;
}
public void logoutMethod() throws InterruptedException {
	Thread.sleep(2000);
	optionsBtn.click();
	logOutBtn.click();
}
}

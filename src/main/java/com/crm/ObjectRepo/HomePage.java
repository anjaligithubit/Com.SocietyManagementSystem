package com.crm.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
@FindBy(linkText = " Home")
private WebElement homeBtn;

@FindBy(xpath = "//a[.=' Accounts']")
private WebElement accountsBtn;

@FindBy(xpath = "//a[.=' Administrator']")
private WebElement administratorLink;

@FindBy(xpath = "//a[.=' Student']")
private WebElement studentLink;

@FindBy(linkText = " Activities")
private WebElement activitiesBtn;

@FindBy(xpath = "//a[.=' Expenses']")
private WebElement expensesBtn;

@FindBy(xpath = "//a[.=' Transaction']")
private WebElement transcationBtn;

@FindBy(linkText = " Options")
private WebElement optionsBtn;

public HomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getHomeBtn() {
	return homeBtn;
}

public WebElement getAccountsBtn() {
	return accountsBtn;
}
public WebElement getAdministratorLink() {
	return administratorLink;
}

public WebElement getStudentLink() {
	return studentLink;
}

public WebElement getActivitiesBtn() {
	return activitiesBtn;
}

public WebElement getExpensesBtn() {
	return expensesBtn;
}

public WebElement getTranscationBtn() {
	return transcationBtn;
}

public WebElement getOptionsBtn() {
	return optionsBtn;
}
public void clickOnAccMethod() {
	accountsBtn.click();
	
}
public void clickOnAdministratorMethod() {
	administratorLink.click();
}
public void clickOnExpensesMethod() {
	expensesBtn.click();
}
public void clickOnTranscationMethos() {
	transcationBtn.click();
}
public void clickOnStudentMethod() {
	studentLink.click();
}


}

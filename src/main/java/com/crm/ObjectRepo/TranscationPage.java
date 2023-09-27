package com.crm.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TranscationPage
{
@FindBy(id = "search")
private WebElement searchEdt;
@FindBy(id = "btn_search")
private WebElement searchBtn;
public TranscationPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	}
public WebElement getSearchEdt() {
	return searchEdt;
}
public WebElement getSearchBtn() {
	return searchBtn;
}
public void enterIdOnSearchFieldMethod(String studentId) {
	searchEdt.sendKeys(studentId);
	searchBtn.click();
}

}

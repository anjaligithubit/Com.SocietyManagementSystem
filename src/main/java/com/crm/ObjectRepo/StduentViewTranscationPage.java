package com.crm.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StduentViewTranscationPage {
	@FindBy(linkText = "Balance")
	private WebElement balanceBtn;
	@FindBy(xpath = "//a[.='Paid']")
private WebElement paidBtn;
	@FindBy(linkText = " entries")
	private WebElement entriesDropDown;
	@FindBy(xpath = "//span[@style=\"cursor:pointer;\"]")
	private WebElement crossBtn;
	@FindBy(xpath = "//input[@type=\"search\"]")
	private WebElement searchEdt;
	public StduentViewTranscationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getBalanceBtn() {
		return balanceBtn;
	}
	public WebElement getPaidBtn() {
		return paidBtn;
	}
	public WebElement getEntriesDropDown() {
		return entriesDropDown;
	}
	public WebElement getCrossBtn() {
		return crossBtn;
	}
	public WebElement getSearchEdt() {
		return searchEdt;
	}
	public void clickOnPaidLink() {
		paidBtn.click();
		crossBtn.click();
	}
	
}

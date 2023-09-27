package com.crm.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExpensesPage {
	@FindBy(id = "add_expenses")
	private WebElement addExpensesBtn;
	
	public ExpensesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getAddExpensesBtn() {
		return addExpensesBtn;
	}
	 public void validateExpensesPageDisplayedOrNotMethod(WebDriver driver) {
		 String expensesPage = driver.findElement(By.xpath("//div[@class=\"alert alert-info\"]")).getText();
			if(expensesPage.contains("Expenses"))
			{
				System.out.println("naviagated to expenses page");
			}
			else 
			{
				System.out.println("not navigated to expenses page");
			}

	 }
	 public void clickOnAddExpensesBtnMethod() {
			addExpensesBtn.click();
		}


	
}

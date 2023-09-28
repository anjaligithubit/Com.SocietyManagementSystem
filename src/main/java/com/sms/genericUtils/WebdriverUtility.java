package com.sms.genericUtils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * 
 * @author Subhadip Ganguly
 *
 */

public class WebdriverUtility 
{
	/**
	 * This method is used maximize the Browser
	 * @param driver
	 */
	public void maximizeTheBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to minimize the browser
	 * @param driver
	 */
	
	public void minimizeTheBrowser(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will wait until elements in the page gets load
	 * @param driver
	 * @param duration
	 */
	public void implicitWait(WebDriver driver,int duration)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}
	
	/**
	 * This method will wait until url of the page gets load
	 * @param driver
	 * @param duration
	 * @param expectedUrl
	 */
	public void waitUntilUrlLoads(WebDriver driver,int duration,String expectedUrl)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.urlContains(expectedUrl));
	}
	
	/**
	 * This method will wait until Title of the page gets load
	 * @param driver
	 * @param duration
	 * @param expectedTitle
	 */
	public void waitUntilTitleLoads(WebDriver driver,int duration,String expectedTitle)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.titleContains(expectedTitle));
	}
	
	/**
	 * This method will wait until the element in the page gets load
	 * @param driver
	 * @param duration
	 * @param element
	 */
	public void waitUntilElementToBeClickable(WebDriver driver,int duration,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will ignore no such element exception and continue the execution
	 * @param driver
	 * @param duration
	 */
	public void ignoreNoSuchElementException(WebDriver driver, int duration)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
	}
	
	/**
	 * This method will wait until the element to be visible in the page
	 * @param element
	 * @throws InterruptedException
	 */
	public void customWait(WebElement element) throws InterruptedException
	{
		int count =0;
		while (count<20)
		{
			try
			{
				element.click();
				break;
			}
			catch(Exception e)
			{
				Thread.sleep(1000);
				count++;
			}
			
		}
		
	}
	
	/**
	 * This method will select a dropdown element based on index
	 * @param element
	 * @param index
	 */
	public void selectDropdown(WebElement element,int index)
	{
		Select	sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method will select a dropdown element based on value
	 * @param element
	 * @param value
	 */
	public void selectDropdown(WebElement element,String value)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method will select a dropdown element based on visible text
	 * @param text
	 * @param element
	 */
	public void selectDropdown(String text,WebElement element)
	{
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * This method is used to mouseOver on an element
	 * @param driver
	 * @param element
	 */
	public void mouseOverOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method is used to double click on an element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method is used to right click on an element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method is used to click on Enter button
	 * @param driver
	 */
	public void clickOnEnterKey(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	/**
	 * This method is used to press the key
	 * @param driver
	 * @throws Throwable
	 */
	public void enterKey(WebDriver driver) throws Throwable
	{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method is used to release the key
	 * @param driver
	 * @throws Throwable
	 */
	public void enterRelease(WebDriver driver) throws Throwable
	{
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method is used to switch from one frame to another using index
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method is used to switch from one frame to another using id
	 * @param driver
	 * @param id
	 */
	public void switchFrame(WebDriver driver,String id)
	{
		driver.switchTo().frame(id);
	}
	
	/**
	 * This method is used to switch from one frame to another using element
	 * @param driver
	 * @param element
	 */
	public void switchFrame(WebDriver driver, WebElement element) 
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method is used to switch to main frame
	 * @param driver
	 */
	public void switchTOMainFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This msg is used to accept alert popup
	 * @param driver
	 * @param expectedMsg
	 */
	public void acceptAlertPopup(WebDriver driver,String expectedMsg)
	{
		Alert alt = driver.switchTo().alert();
		if(alt.getText().equalsIgnoreCase(expectedMsg))
		{
			System.out.println("alert msg is verified");
		}
		else
		{
			System.out.println("alert msg is not verified");
		}
		alt.accept();
	}
	
	/**
	 * This method is used to dismiss the alert popup
	 * @param driver
	 * @param expectedmsg
	 */
	public void dismisAlertPopup(WebDriver driver, String expectedmsg)
	{
		Alert alt = driver.switchTo().alert();
		if(alt.getText().equalsIgnoreCase(expectedmsg))
		{
			System.out.println("alert msg is verified");
		}
		else
		{
			System.out.println("alert msg is not verified");
		}
		alt.dismiss();
	}
	
	/**
	 * This method is used to switch from one window to another based on Title
	 * @param driver
	 * @param expectedTitle
	 */
	public void switchWindowBasedOnTitle(WebDriver driver,String expectedTitle)
	{
		Set<String> set = driver.getWindowHandles();
		for(String str:set)
		{
			driver.switchTo().window(str);
			String title = driver.getTitle();
			if(title.contains(expectedTitle))
			{
				break;
			}
		}	
	}
	
	/**
	 * This method is used to switch from one window to another based on url
	 * @param driver
	 * @param expectedUrl
	 */
	public void switchWindowBasedONUrl(WebDriver driver,String expectedUrl)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String wid = it.next();
			driver.switchTo().window(wid);
			String url = driver.getCurrentUrl();
			if(url.contains(expectedUrl))
			{
				break;
			}
		}
		
	}
	
	/**
	 * This method is used to take screenshot whenever the testscript getting failed
	 * @param driver
	 * @param screenshotName
	 * @return
	 */
	public static String takeScreenshot(WebDriver driver, String screenshotName)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshots/"+screenshotName+".png");
		try
		{
			Files.copy(src, dst);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return screenshotName;
	}
	
	/**
	 * This method is used to scroll to Particular element
	 * @param driver
	 * @param element
	 */
	public void scrollTOParticularElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
}

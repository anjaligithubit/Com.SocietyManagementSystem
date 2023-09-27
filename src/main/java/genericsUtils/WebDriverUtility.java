package genericsUtils;

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
 * @author Anjali
 */
public class WebDriverUtility {
	/**
	 * This method is used to maximize the browser
	 * @param driver
	 */
	public void maximixeTheBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();

	}
	/**
	 * This method is used to minimize the browser
	 * @param driver
	 */
	public void minimizetheBrowser(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * this method will wait until elements in the page gets load
	 * @param driver
	 * @param duration
	 */
	public void implicityWait(WebDriver driver,int duration)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}
	/**
	 * This method will wait until the url of the page gets load
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
	 * This method will wait until the title gets load
	 * @param driver
	 * @param duration
	 * @param expectedTite
	 */
	
	public void waitUntilTitleLoads(WebDriver driver,int duration, String expectedTite) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.titleContains(expectedTite));
		
	}
	/**
	 * This method will wait until the element in the page gets load
	 * @param driver
	 * @param element
	 * @param duration
	 */
	public void waitUntilElementToBeClickable(WebDriver driver,WebElement element,int duration)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will ignore NoSuChElementException and continues the execution
	 * @param driver
	 * @param duration
	 */
	public void ignoreNoSuchElementException(WebDriver driver,int duration) 

	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
	}	
	/**
	 * This method will wait until the element to be visiable in the page
	 * @param element
	 * @throws InterruptedException
	 */
	public void customWait(WebElement element) throws InterruptedException 
	{
		int count=0;
		while(count<20) 
		{
			
		try 
		{
			element.click();
			break;	
		}
		catch (Exception e) 
		{
			Thread.sleep(3000);
			count++;
		}
		}
		
		
	}
	/**
	 * This method will select a dropdown element based on index
	 * @param element
	 * @param index
	 */
	
	public void selectDropDown(WebElement element,int index) 
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * This method will select a dropdown on the based on value
	 * @param element
	 * @param value
	 */
	public void  selectDropDown(WebElement element,String value) 
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	/**
	 * This method will select a dropdown based on the visiable text
	 * @param text
	 * @param element
	 */
	public void selectDropDown(String text,WebElement element) 
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	/**
	 * This method will move to a particular element on the webpage
	 * @param driver
	 * @param element
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element) 
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * This method will perform right click on the webpage
	 * @param driver
	 */
	public void rightClickOnElement(WebDriver driver) {
		Actions action=new Actions(driver);
		action.contextClick().perform();
	}
	/**
	 * This method will perform right click on a particular element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.contextClick(element).perform();	
    }
	/**
	 * This method will perform double click operation on a particular element
	 * @param driver
	 */
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}
	/**
	 * This method is used to click on enter button
	 * @param driver
	 */
	public void clickOnEnterKey(WebDriver driver)	
	{
	Actions action=new Actions(driver);
	action.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * This method is used to perform drag and drop operation
	 * @param driver
	 * @param source
	 * @param dest
	 */
	public void dragAndDrop(WebDriver driver,WebElement source,WebElement dest) {
		Actions action=new Actions(driver);
		action.dragAndDrop(source, dest).perform();
	}
	/**
	 * This method will press the enter key
	 * @throws Throwable
	 */
	public void enterKey() throws Throwable {
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
	}
	/**
	 * This method will release the enter key
	 * @throws Throwable
	 */
	public void enterRelease() throws Throwable {
		Robot robot=new Robot();
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * This method is used to switch from one frame to another frame
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver,int index) 
	{
		driver.switchTo().frame(index);
		
	}
	/**
	 * This method is used to switch from one frame to another frame
	 * @param driver
	 * @param id
	 */
	public void switchFrame(WebDriver driver,String id)
	
	{
		driver.switchTo().frame(id);
	}
	/**
	 * This method is used to switch from one frame to another frame
	 * @param driver
	 * @param element
	 */
	public void switchFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This method is used to switch to main frame
	 * @param driver
	 */
	public void switchToMainFrame(WebDriver driver) 
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used to accept alert popup
	 * @param driver
	 * @param expectedMessage
	 */
	public void aceeptAlertPopUp(WebDriver driver,String expectedMessage)
	{
		Alert alert=driver.switchTo().alert();
		if(alert.getText().equalsIgnoreCase(expectedMessage))
		{
		System.out.println("alert is verified");
    	}
		else 
		{
			System.out.println("alert is not verified");
		}
		alert.accept();
	}
	/**
	 * This method is used to dismiss the alert popup
	 * @param driver
	 * @param expectedMessage
	 */
	public void dismissAlertPopUp(WebDriver driver,String expectedMessage)
	{
		Alert alert=driver.switchTo().alert();
		if(alert.getText().equalsIgnoreCase(expectedMessage))
		{
			System.out.println("alert is verified");
		}
		else
		{
			System.out.println("alert is not verified");
		}
		alert.dismiss();
			
		
	}
	/**
	 * This method is used to switch from one window to another based on title
	 * @param driver
	 * @param expectedTitle
	 */
	public void switchWindowBasedOnTitle(WebDriver driver,String expectedTitle)
	{
		Set<String> set = driver.getWindowHandles();
		for(String str:set)
		{
			driver.switchTo().window(str);
			String title=driver.getTitle();
			if(title.contains(expectedTitle))
			{
				break;
			}
		}
	}
	/**
	 * This method is used to switch from one frame to another based on url
	 * @param driver
	 * @param expectedUrl
	 */
	public void switchWindowBasedOnUrl(WebDriver driver,String expectedUrl)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		while(it.hasNext()) 
		{
			String wind=it.next();
			String url=driver.getCurrentUrl();
			if(url.contains(expectedUrl))
			{
				driver.switchTo().window(wind);
			}
		}
	}
	/**
	 * This method is used to take screenshot of failed test case
	 * @param driver
	 * @param screenShotName
	 * @return
	 */
	public  static String takeScreenShot(WebDriver driver,String screenShotName) 
	{
		TakesScreenshot takeScreenShot = (TakesScreenshot)driver;
		File src=takeScreenShot.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+screenShotName+".png");
		try 
		{
			Files.copy(src, dest);
		}
		catch (Exception e)
		{
			e.printStackTrace();		
		}
		return screenShotName;
		}
	/**
	 * This method is used to scroll into a particular element using javaScriptExecutor
	 * @param driver
	 * @param element
	 */

	public void scrollToParticularElementUsingJSE(WebDriver driver,WebElement element) 
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	/**
	 * This method will perfrom random scroll
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)", "");
	}
	/**
	 * This method will scroll until specified element is found
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	/**
	 * This method is used to click a particular element using javascriptExecutor
	 * @param driver
	 * @param element
	 */
	public void clickUsingJavaScriptExecutor(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",element );
	}
	/**
	 * This method is used to enter value into text field using javascriptExecutor
	 * @param driver
	 * @param text
	 * @param element
	 */
	public void enterDataInTextFieldUsingJSE(WebDriver driver,String text,WebElement element) 
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=text", element);
	}
	/**
	 * This method is used to close the browser
	 * @param driver
	 */
	public void closeBrowser(WebDriver driver)
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

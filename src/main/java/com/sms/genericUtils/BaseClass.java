package com.sms.genericUtils;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.sms.objectrepository.HomePage;
import com.sms.objectrepository.LoginPage;

public class BaseClass 
{
	//create object for all utility classes
	public WebdriverUtility wlib = new WebdriverUtility();
	public ExcelUtility elib = new ExcelUtility();
	public FileUtility flib = new FileUtility();
	public DatabaseUtility dlib = new DatabaseUtility();
	public JavaUtility jlib = new JavaUtility();
	
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void configBS() throws Throwable
	{
		dlib.connectToDB();
		System.out.println("Database is connected");
	}
	
	//@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void configBC() throws Throwable
	{
		String browser = flib.getPropertyKeyValue("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("It's invalid");
		}
		sdriver = driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws Throwable
	{
		String url = flib.getPropertyKeyValue("url");
		String un = flib.getPropertyKeyValue("username");
		String pwd = flib.getPropertyKeyValue("password");
		
		driver.get(url); 
		wlib.maximizeTheBrowser(driver);
		wlib.implicitWait(driver, 10);
		
		LoginPage lp = new LoginPage(driver);
		lp.login(un, pwd);
		
		System.out.println("Login to the application");
	}
	
	@AfterMethod(alwaysRun = true)
	public void configAM()
	{
		HomePage hp = new HomePage(driver);
		hp.logout();
		
		System.out.println("Logout from application");
	}
	
	@AfterClass(alwaysRun = true)
	public void configAC()
	{
		driver.quit();
		System.out.println("Close the browser");
	}
	
	@AfterSuite(alwaysRun = true)
	public void configAS() throws SQLException
	{
		dlib.closeDB();
		System.out.println("Close db connection");
	}
}

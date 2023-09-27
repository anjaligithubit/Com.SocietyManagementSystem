package genericsUtils;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepo.LoginPage;
import com.crm.ObjectRepo.LogoutPage;

public class BaseClass 
{
public DataBaseUtility dLib=new DataBaseUtility();
public ExcelUtility eLib=new ExcelUtility();
public FileUtility fLib=new FileUtility();
public WebDriverUtility wLib=new WebDriverUtility();
public JavaUtility jLib=new JavaUtility();
public static  WebDriver driver;
public  static WebDriver sdriver;
@BeforeSuite(alwaysRun = true)
public void configBS() throws Throwable {
	dLib.connectToDB();
	System.out.println("--- connect to db----");
}
//@Parameters("BROWSER")
@BeforeClass(alwaysRun = true)
public void configBC() throws Throwable {
	String BROWSER=fLib.getPropertyKeyValue("browser");
	if(BROWSER.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
		System.out.println("--- launch the driver---");
	}
	else if(BROWSER.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
		System.out.println("--- launch the driver---");
	}
	else{
System.out.println("invalid browser");

		}
	sdriver=driver;
	wLib.maximixeTheBrowser(driver);
}
@BeforeMethod(alwaysRun = true)
public void configBM() throws Throwable {
	String URL=fLib.getPropertyKeyValue("url");
	String USERNAME=fLib.getPropertyKeyValue("username");
	String PASSWORD=fLib.getPropertyKeyValue("password");
    driver.get(URL);
    wLib.implicityWait(driver, 10);
	LoginPage lp=new LoginPage(driver);
	lp.loginMethod(USERNAME, PASSWORD);
	System.out.println("--- login to application ------"); 
}
@AfterMethod(alwaysRun = true)
public void configAM() throws Throwable {
	LogoutPage logout=new LogoutPage(driver);
	logout.logoutMethod();
	System.out.println("---- logout from the application ----");
}
@AfterClass(alwaysRun = true)
public void configAC() {
	wLib.closeBrowser(driver);
	System.out.println("--- close the browser ----");
}
@AfterSuite(alwaysRun = true)
public void configAS() throws Throwable {
	dLib.closeDB();
	System.out.println("--- close db connection ----");
}

}

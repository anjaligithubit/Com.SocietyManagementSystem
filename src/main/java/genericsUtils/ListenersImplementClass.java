package genericsUtils;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementClass implements ITestListener
{
ExtentReports report;
ExtentTest test;
	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("./Extentreport/report.html");
		htmlReport.config().setDocumentTitle("SDET-51");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setReportName("society-management-system");
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("os", "windows-11");
		report.setSystemInfo("Base-browser", "chrome");
		report.setSystemInfo("base-url", "http://rmgtestingserver/domain/Society_Management_System/admin/");
		report.setSystemInfo("reporter-name", "Anjali");
		
	}

	@Override
	public void onTestFailure(ITestResult result)
{
//		TakesScreenshot ts=(TakesScreenshot) BaseClass.sdriver;
//		File src = ts.getScreenshotAs(OutputType.FILE);
//		File dest=new File("./screenshot/failedScript.png");
//		try {
//			FileUtils.copyFile(src, dest);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
	TakesScreenshot ts=(TakesScreenshot)BaseClass.driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	System.out.println("result of the  test is"+"   "+ result.getStatus());
	String name=result.getName();
	Date date=Calendar.getInstance().getTime();
	String today=date.toString().replaceAll(":", "-");
	File dest=new File("./screenshot/failedScript"+name+today+".png");
try {
	FileUtils.copyFile(src, dest);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//		String methodName=result.getMethod().getMethodName();
//	String failedScript = WebDriverUtility.takeScreenShot(BaseClass.sdriver, methodName);
//		test.addScreenCaptureFromPath(failedScript);
//		test.log(Status.FAIL, result.getThrowable());
//		test.log(Status.FAIL, methodName+"------- failed");
//		Reporter.log(methodName+"------- failed");
//		
		
	
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, result.getThrowable());
		test.log(Status.SKIP, methodName+"----- skipped");
		Reporter.log(methodName+"------  skipped");
	}

	@Override
	public void onTestStart(ITestResult result) {
	
		String methodName = result.getMethod().getMethodName();
		test=report.createTest(methodName);
		Reporter.log(methodName+"-------> execution starts");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"------>passed");
		Reporter.log(methodName+"------->testscript executed successfully");
			}

	
}

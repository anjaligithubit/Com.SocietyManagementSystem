package com.sms.genericUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImpClass implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result)
	{
		//actual testscripts execution starts from here
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		Reporter.log(methodName+"-->Execution starts");
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"---passed");
		Reporter.log(methodName+"-->TestScript executed successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
//		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
//		File src = ts.getScreenshotAs(OutputType.FILE);
//		File dst = new File("./Screenshot/failedTC.png");
//		try {
//			FileUtils.copyFile(src, dst);
//		} 
//		catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		String methodName = result.getMethod().getMethodName();
		try
		{
			String failedScript = WebdriverUtility.takeScreenshot(BaseClass.sdriver, methodName);
			test.addScreenCaptureFromPath(failedScript);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, methodName+"---failed");
		Reporter.log(methodName+"-->TestScript failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, result.getThrowable());
		test.log(Status.SKIP, methodName+"----skipped");
		Reporter.log(methodName+"--->TestScript skipped");
	}

	@Override
	public void onStart(ITestContext context) 
	{
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./Extentreport/report.html");
		htmlreport.config().setDocumentTitle("SDET-51");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("SMS");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("Base-URL", "http://rmgtestingserver/domain/society_management_system/admin/");
		report.setSystemInfo("Reporter Name", "Subhadip");
	}

	@Override
	public void onFinish(ITestContext context) {
		
		report.flush();
	}
	
}

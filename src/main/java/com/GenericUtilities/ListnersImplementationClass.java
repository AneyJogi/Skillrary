package com.GenericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.internal.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ListnersImplementationClass implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		//execution starts here
		String Methodname = result.getMethod().getMethodName();
		test = report.createTest(Methodname);
		Reporter.log(Methodname+"------>Testscript execution started");
	}

	public void onTestSuccess(ITestResult result) {
		String Methodname = result.getMethod().getMethodName();
		test.log(Status.PASS,Methodname+"------> Passed");
		Reporter.log(Methodname+"------>Testscript execution Successfull");
	}

	public void onTestFailure(ITestResult result) {
	 
		String FScript=result.getMethod().getMethodName();
		String FS=FScript+new JavaUtility().formatSystemDate();
	    EventFiringWebDriver edriver= new EventFiringWebDriver(BaseClass.sdriver);
		File src=edriver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./Screenshot/"+FS+".png");
		 
		try 
		{
			FileUtils.copyFile(src, dst);
	    }
		catch (IOException e)
		{
						e.printStackTrace();
		}
		
		String absolutepath = dst.getAbsolutePath();
		test.addScreenCaptureFromPath(absolutepath);

		test.log(Status.FAIL,result.getThrowable());
		Reporter.log("------>Testscript execution failed");

//		try
//		{
//			String screenshotname= WebDriverUtility.getScreenShot(BaseClass.sdriver, result.getMethod().getMethodName();)
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
		
	}

	public void onTestSkipped(ITestResult result) {
		String Methodname= result.getMethod().getMethodName();
		test.log(Status.SKIP, Methodname+"----->Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log("Testscript execution skipped");
		
	}

	public void onStart(ITestContext context) {
		//create html report
		ExtentSparkReporter htmlreport= new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("OnlineShoppingApplication");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("Emart");
		
		report= new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base_Browser", "chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Base_Url", "http://rmgtestingserver/domain/Online_Shopping_Application/");
		report.setSystemInfo("Reporter Name", "Aney Jogi");
	
	} 

	public void onFinish(ITestContext context) {
		//consolidate the report
		report.flush();
	
	}

}
 
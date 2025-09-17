package com.clientname.projectname.genricutil.ListenerImplUtil;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IRetryAnalyzer;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.clientname.projectname.genricutil.BaseClaseUtil.BaseClass;

public class ListenerImplimentation implements ITestListener,ISuiteListener,IRetryAnalyzer {
	ExtentReports report;
	ExtentTest test;
	

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onStart(suite);
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/Report.html");
		spark.config().setDocumentTitle("DocumentTitle");
		spark.config().setReportName("ReportName");
		spark.config().setTheme(Theme.STANDARD);
		 report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "windows");
		
		
		
		ISuiteListener.super.onStart(suite);
		
	
		

		
	}

	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		String methodName = result.getMethod().getMethodName();
		 test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS,methodName );
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL,methodName );
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
		String screenshot = ts.getScreenshotAs(OutputType.BASE64);
		 test.addScreenCaptureFromBase64String(screenshot, result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP,methodName );
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
		
	}
	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onFinish(suite);
		report.flush();
		System.out.println("isuit test finish ");
	}
	int count = 0;
	int LimitCount = 0;
	@Override
	public boolean retry(ITestResult result) {
		if (count < LimitCount) {
			count++;
			return true;
		}
		return false;
	}


}

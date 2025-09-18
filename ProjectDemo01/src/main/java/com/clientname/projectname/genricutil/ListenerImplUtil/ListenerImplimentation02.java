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
import com.clientname.projectname.genricutil.JavaUtility.ObjectGetterSetterUtil;

public class ListenerImplimentation02 implements ITestListener , ISuiteListener,IRetryAnalyzer {

	ExtentTest test ;
	ExtentReports report;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onStart(suite);
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/seconReport.html");
		spark.config().setDocumentTitle("Document Title");
		spark.config().setReportName("ReportName");
		spark.config().setTheme(Theme.STANDARD);
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Os", "Windows");
		
		
		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onFinish(suite);
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		String name = result.getMethod().getMethodName();
		test = report.createTest(name);
		ObjectGetterSetterUtil.setTest(test);
		test.log(Status.INFO, name+" Start");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		String name = result.getMethod().getMethodName();
		test.log(Status.PASS, name);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		String name = result.getMethod().getMethodName();
		test.log(Status.FAIL, name);
		TakesScreenshot ts = (TakesScreenshot)ObjectGetterSetterUtil.getDriver();
		String string = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(string, name);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		String name = result.getMethod().getMethodName();
		test.log(Status.SKIP, name);
	}

}

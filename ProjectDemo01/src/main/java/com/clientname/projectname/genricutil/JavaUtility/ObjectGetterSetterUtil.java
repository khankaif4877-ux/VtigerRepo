package com.clientname.projectname.genricutil.JavaUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class ObjectGetterSetterUtil {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(WebDriver driverInstance) {
		driver.set(driverInstance);

	}

	public static ExtentTest getTest() {
		return test.get();
	}

	public static void setTest(ExtentTest testInstance) {
		test.set(testInstance);

	}

}

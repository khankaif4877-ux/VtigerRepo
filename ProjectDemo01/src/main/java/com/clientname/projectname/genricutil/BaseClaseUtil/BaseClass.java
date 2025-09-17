package com.clientname.projectname.genricutil.BaseClaseUtil;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.clientname.projectname.genricutil.DataBaseUtil.DataBaseUtility;
import com.clientname.projectname.genricutil.FileUtil.ExcelUtil;
import com.clientname.projectname.genricutil.FileUtil.FileUtility;
import com.clientname.projectname.genricutil.WebDriverUtil.WebDriverUtil;

public class BaseClass {
	WebDriver driver;
	public static WebDriver sdriver;

	public DataBaseUtility db = new DataBaseUtility();
	public WebDriverUtil wdu = new WebDriverUtil();
	public FileUtility fu = new FileUtility();
	public ExcelUtil eu = new ExcelUtil();

	@BeforeSuite
	public void beforeSuite() {
//		db.getConnection();

	}

	@BeforeClass
//	@Parameters("browser")
	public void beforeClass() throws IOException {
	String 	browser = "chrome";
		WebDriver driver = null;
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();

		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();

		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();

		} else if (browser.equals("safari")) {
			driver = new SafariDriver();

		} else {
			driver = new ChromeDriver();
		}
		this.driver = driver;
		sdriver=driver;
		wdu.implicitWait(driver, 20);
		driver.manage().window().maximize();
		driver.get(fu.readDataFromProperty("url"));
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("loginmethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("logoutmethod");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

	@AfterSuite
	public void afterSuite() {
//		db.closeConnection();
	}

}

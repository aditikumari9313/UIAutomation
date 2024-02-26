package base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class BaseTest {

	public static WebDriver driver;
	public static String Url = "http://www.globalsqa.com/demo-site/draganddrop/";

	public BaseTest(WebDriver driver) {
		this.driver = driver;

	}

	public static  ExtentTest test;
	public static  ExtentReports report;

	public void takeScreenshot(File destFile) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, destFile);

	}

	@BeforeSuite
	public  void initializeBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\aditi\\eclipse-workspace\\UIAutomationWinJit-main\\UIAutomationWinJit-main\\DriverUtil\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@AfterSuite
	public  void closebroswer() {

		driver.quit();
	}

	@BeforeClass
	public  void startTest() {
		report = new ExtentReports();
		test = report.createTest(
				"C:\\Users\\aditi\\eclipse-workspace\\UIAutomationWinJit-main\\UIAutomationWinJit-main\\ExtentReports");
	}

	@AfterClass
	public  void endTest() {
		report.flush();
	}
}

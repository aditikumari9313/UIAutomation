package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import base.BaseTest;

public class DropDownPage extends BaseTest {

	public DropDownPage(WebDriver driver) {
		super(driver);

	}

	public static String CountryDropDown = "//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//p//select";
	public static String SamplePagePath="//span[@class='link_span'][normalize-space()='Sample Page Test']";

	public static void dropdownMenu(WebDriver driver) {

		WebElement CountryOption = driver.findElement(By.xpath(CountryDropDown));
		Select sc = new Select(CountryOption);
		sc.selectByVisibleText("India");
		test.log(Status.PASS, "Country selected");
	}

	public static void scrollDown(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");

	}
	
	public static void samplePageClick(WebDriver driver) {
		
		WebElement SamplePage = driver.findElement(By.xpath(SamplePagePath));
		SamplePage.click();
		Set<String> windowhandles=driver.getWindowHandles();

		Iterator<String> it=windowhandles.iterator();
		String parentwindows=it.next();
		String childwindows=it.next();
		driver.switchTo().window(childwindows);
		scrollDown(driver);
		test.log(Status.PASS, "Sample Page opned");
	}
}
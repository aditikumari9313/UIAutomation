package pages;

import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;

import base.BaseTest;

public class LandingPage extends BaseTest {

	public LandingPage(WebDriver driver) {
		super(driver);

	}

	public static String sourceFrame="//iFrame[@class='demo-frame lazyloaded']";
	public static String SourceOneXpath = "//li[1]";
	public static String SourceTwoXpath = "//li[2]";
	public static String TragetXpath = "//div[@id='trash']";
	public static String DropDown = "//span[@class='link_span'][normalize-space()='DropDown Menu']";


	public static void dragAndDrop(WebDriver driver) {

		
	    driver.switchTo().frame(sourceFrame);
		WebElement sourceOne = driver.findElement(By.xpath(SourceOneXpath));
		WebElement sourceTwo = driver.findElement(By.xpath(SourceTwoXpath));
		WebElement Traget = driver.findElement(By.xpath(TragetXpath));
		Actions act = new Actions(driver);
		act.dragAndDrop(sourceOne, Traget).build().perform();
		act.dragAndDrop(sourceTwo, Traget).build().perform();
		test.log(Status.PASS, "drag and drop completed");
		

	}

	public static void dropdownMenu(WebDriver driver) {

		WebElement DropDownMenu = driver.findElement(By.xpath(DropDown));
		DropDownMenu.click();
		Set<String> windowhandles = driver.getWindowHandles();

		Iterator<String> it = windowhandles.iterator();
		String parentwindows = it.next();
		String childwindows = it.next();
		driver.switchTo().window(childwindows);
		test.log(Status.PASS, "Drop down menu page switched");

	}

}
package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import base.BaseTest;

public class SamplePage extends BaseTest {

	public SamplePage(WebDriver driver) {
		super(driver);

	}

	public static String namePath = "//input[@class='name']";
	public static String emailPath = "//input[@class='email']";
	public static String experiencePath = "//select[@id='g2599-experienceinyears']";
	public static String checkboxOne = "//input[@value='Functional Testing']";
	public static String checkboxTwo = "//input[@value='Automation Testing']";
	public static String education = "//label[normalize-space()='Graduate']";
	public static String comment = "//textarea[@id='contact-form-comment-g2599-comment']";
	public static String submit = "//button[normalize-space()='Submit']";
	public static String confirmationMessage = "//div[@class='content_bgr']//h3[1]";

	public static void samplePage(WebDriver driver, String name, String email) {

		WebElement nameFeild = driver.findElement(By.xpath(namePath));
		nameFeild.sendKeys(name);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();
		WebElement emailFeild = driver.findElement(By.xpath(emailPath));
		emailFeild.sendKeys(email);
		WebElement experienceFeild = driver.findElement(By.xpath(experiencePath));
		Select sc = new Select(experienceFeild);
		sc.selectByVisibleText("7-10");
		WebElement checkboxFun = driver.findElement(By.xpath(checkboxOne));
		checkboxFun.click();
		WebElement checkboxAut = driver.findElement(By.xpath(checkboxTwo));
		checkboxAut.click();
		WebElement educationButton = driver.findElement(By.xpath(education));
		educationButton.click();
		WebElement commentBox = driver.findElement(By.xpath(comment));
		commentBox.sendKeys("ok");
		WebElement submitButton = driver.findElement(By.xpath(submit));
		submitButton.click();
		test.log(Status.PASS, "form submitted");
	}

	public static void confirmation(WebDriver driver) {
		Set<String> windowhandles = driver.getWindowHandles();

		Iterator<String> it = windowhandles.iterator();
		String parentwindows = it.next();
		String childwindows = it.next();
		driver.switchTo().window(childwindows);
		driver.findElement(By.id(childwindows));
		WebElement confirmationText = driver.findElement(By.xpath(confirmationMessage));
		if (confirmationText.isDisplayed()) {
			test.log(Status.PASS, "form submitted successfully");
		} else {

			test.log(Status.FAIL, "form not submitted");

		}

	}
	
}
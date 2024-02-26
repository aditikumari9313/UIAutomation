package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.DropDownPage;
import pages.LandingPage;
import pages.SamplePage;

public class FormSubmissionTest extends BaseTest {

	public FormSubmissionTest(WebDriver driver) {
		super(driver);

	}

	@Test(priority = 1)
	public void landingPageScenario() {

		LandingPage.dragAndDrop(driver);
		LandingPage.dropdownMenu(driver);
	}

	
	@Test(priority = 2)
	public void dropDownPageScenario() {

		landingPageScenario();
		DropDownPage.dropdownMenu(driver);
		DropDownPage.scrollDown(driver);
		DropDownPage.samplePageClick(driver);

	}

	@Test(priority = 3)
	@Parameters({ "name", "email" })
	public void SamplePageScenario(String name, String email) {

		dropDownPageScenario();
		SamplePage.samplePage(driver, name, email);
		SamplePage.confirmation(driver);
	}
	
}

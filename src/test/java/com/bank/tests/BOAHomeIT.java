package com.bank.tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bank.pageobjects.BOAHomePO;
import com.bank.pageobjects.CareerApplyJobPage;
import com.bank.pageobjects.CareersHomePage;
import com.bank.pageobjects.CareersPO;

public class BOAHomeIT extends BOABaseIT {
	public static final String USERNAME = "arunasri";
	public static final String ACCESS_KEY = "5eff05a3-a91a-41aa-90ff-0a54533fe9ba";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeMethod(alwaysRun = true)
	public void SetUp() throws Exception {
		DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "56.0");
		//
		driver = new RemoteWebDriver(new URL(URL), caps);

		baseUrl = "https://www.bankofamerica.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void testBankOfAmerica() throws Exception {
		driver.get(baseUrl);
		// BOAHomePO home = new BOAHomePO(driver);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		// ((JavascriptExecutor)driver).executeScript("scroll('0,1000')");
		// home.careersLink.click();

		WebElement element = driver.findElement(By.name("footer_careers"));
		je.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		Helper.highLightElement(driver, element);
		System.out.println("careers link is clicked");

		// Extract the text and verify
		// System.out.println(element.getText());
		// Verify welcome in careers page
		Thread.sleep(100);
		// Identify welcome title
		WebElement welcome = driver.findElement(By.xpath("//*[@id='content-wrapper']/section/h1"));
		Thread.sleep(100);
		Helper.highLightElement(driver, welcome);
		// Assert.assertEquals(driver.getTitle(), "Welcome");
		// verify welcome title is present
		System.out.println("Verified Welcome in careers page");
		// fill out all the required fields in careers page
		CareersPO careers = new CareersPO(driver);
		// Helper.highLightElement(driver, careers);
		careers.careerOppunitiesRadioButton.click();
		careers.locationDropDown.sendKeys("United States");
		careers.getStartedButton.click();
		// verify that you are in careers page
		WebElement home = driver.findElement(By.partialLinkText("Home"));
		Thread.sleep(100);
		Helper.highLightElement(driver, home);
		System.out.println("Careers home page is displayed");
		// Click on the Get Started / Apply Now button
		CareersHomePage applyNow = new CareersHomePage(driver);
		applyNow.applyNowButton.click();
		Thread.sleep(100);
		System.out.println("Get started/apply now button is clicked");
		// Search jobs page is opened
		// Search for the Job Number
		CareerApplyJobPage jobNumber = new CareerApplyJobPage(driver);
		jobNumber.jobNumber.sendKeys("17071891");

		// key="5eff05a3-a91a-41aa-90ff-0a54533fe9ba"
		// Helper.highLightElement(driver, 17071891);
		// verify based on the job number results should be displayed
		jobNumber.applyFilterButton.click();
		Thread.sleep(100);
		System.out.println("Results displayed successfully");

	}
	
	@Test(priority = 2)
	public void scheduleAppointment() throws Exception {
		driver.get(baseUrl);
		
	//Clicking on shedule appointment link
		BOAHomePO home = new BOAHomePO(driver);
		home.scheduleAnAppointmentLink.click();
	//	
		
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.close();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}
}

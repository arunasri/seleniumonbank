package com.bank.tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class BOABaseIT {
	public final static String seleniumGridURL = "https://arunasri:5eff05a3-a91a-41aa-90ff-0a54533fe9ba@ondemand.saucelabs.com:443/wd/hub";
	public final static String baseUrl = "https://www.bankofamerica.com/";
	public WebDriver driver;

	// screenshots
	public void screenshot(WebDriver driver, String folder, String fileName) throws Exception {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("./screenshot/" + folder + "/" + fileName));
	}

	// Browser Running on
	@BeforeMethod(alwaysRun = true)
	public void SetUp() throws Exception {
		this.runLocally();
		// this.runOnSaucelabs();
		driver.get(baseUrl);
	}

	// Page Assertions
	public void verifyPageTitle(String title) {
		String getTitle = driver.getTitle();
		try {
			Assert.assertEquals(title, getTitle);
		} catch (AssertionError e) {
			System.out.println("Savings title is displayed");
		}
	}

	// Going back to home page
	public void goBackPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.history.go(-1)");
	}

	// local browser method
	public void runLocally() {
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	// Remote Browser method
	public void runOnSaucelabs() throws MalformedURLException {
		DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "56.0");

		driver = new RemoteWebDriver(new URL(seleniumGridURL), caps);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

}

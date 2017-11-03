package com.bank.tests;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;

public class BOABaseIT {
	public String seleniumGridURL = "https://arunasri:5eff05a3-a91a-41aa-90ff-0a54533fe9ba@ondemand.saucelabs.com:443/wd/hub";
	public WebDriver driver;
	public String baseUrl;
	
	public void screenshot(WebDriver driver, String folder, String fileName) throws Exception {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("./screenshot/" + folder + "/" + fileName));
	}

	@BeforeMethod(alwaysRun = true)
	public void SetUp() throws Exception {
		DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "56.0");
		//
		driver = new RemoteWebDriver(new URL(seleniumGridURL), caps);

		baseUrl = "https://www.bankofamerica.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

}

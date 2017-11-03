package com.bank.tests;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BOABaseIT {
	public void screenshot(WebDriver driver, String folder, String fileName) throws Exception {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("./screenshot/"+folder+"/"+fileName));
	}

}

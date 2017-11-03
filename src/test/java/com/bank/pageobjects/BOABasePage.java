package com.bank.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BOABasePage {
	
	public BOABasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	} 

}

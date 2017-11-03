package com.bank.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CareersHomePage extends BOABasePage {
	 public CareersHomePage(WebDriver driver) {
		 super(driver);
	 }	 
	
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "/us")
	public WebElement careerUSPage;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Get started/Apply now >")
	public WebElement applyNowButton;

}

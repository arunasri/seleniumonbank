package com.bank.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ZipcodeSearch extends BOABasePage {
	public ZipcodeSearch(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.ID, using = "findLocTextBox")
	public WebElement zipcodeTextField;
	@FindBy(how = How.ID, using = "findLink")
	public WebElement findLocationButton;
	@FindBy(how = How.ID, using = "locTable")
	public WebElement locationResults;
	
}

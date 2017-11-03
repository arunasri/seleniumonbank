package com.bank.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CareersPO extends BOABasePage{
	public CareersPO(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.ID, using = "content-wrapper")
	public WebElement welcomeTitle;	
	@FindBy(how = How.ID, using = "rd-career")
	public WebElement careerOppunitiesRadioButton;
	@FindBy(how = How.ID, using = "rd-campus")
	public WebElement campusRadioButton;
	@FindBy(how = How.ID, using = "sel-country-list")
	public WebElement locationDropDown;
	@FindBy(how = How.ID, using = "btn-get-started")
	public WebElement getStartedButton;
	
	
}

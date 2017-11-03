package com.bank.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CareerApplyJobPage extends BOABasePage {
	public CareerApplyJobPage(WebDriver driver) {
		super(driver);
	}	
	
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Search Jobs")
	public WebElement searchJobsLogo;
	@FindBy(how = How.ID, using = "ui-accordion-1-header-1")
	public WebElement locationHeader;
	@FindBy(how = How.NAME, using = "ctl00$PlhContentWrapper$tbxKeyword")
	public WebElement jobNumber;
	@FindBy(how = How.NAME, using = "ctl00$PlhContentWrapper$btnSubmit")
	public WebElement applyFilterButton;
	
}

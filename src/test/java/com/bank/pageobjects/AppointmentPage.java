package com.bank.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AppointmentPage extends BOABasePage {
	public AppointmentPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.NAME, using = "everyday_banking_topic")
	public WebElement everydayBankingLink;

}

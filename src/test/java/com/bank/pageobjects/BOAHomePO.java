package com.bank.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BOAHomePO extends BOABasePage{
	public BOAHomePO(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Bank of America")
	public WebElement bofLogoLink;
	@FindBy(how = How.LINK_TEXT, using = "Careers")
	public WebElement careersLink;
	@FindBy(how =How.NAME, using = "popular_meet_face_to_face")
	public WebElement scheduleAnAppointmentLink;

}

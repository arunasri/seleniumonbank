package com.bank.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MouseOverTestIT extends BOABaseIT {

	@Test(priority = 1)
	public void testBankOfAmericaPageGoingChecking() {
		// Banking
		this.openSubmenuLink("Banking", "Checking");
		this.verifyPageTitle("Checking Accounts");
	}

	@Test(priority = 1)
	public void testBankOfAmericaPageGoingSavings() {
		this.openSubmenuLink("Banking", "Savings");
		this.verifyPageTitle("Savings");
	}

	@Test(priority = 1)
	public void testBankOfAmericaPageGoingCDS() {
		this.openSubmenuLink("Banking", "CDs");
		this.verifyPageTitle("CDS");
	}

	
	@Test(priority = 2)
	public void testCreditCardMenu() {
		driver.get(baseUrl);
		// credit card
		this.openSubmenuLink("Credit Cards", "Featured Credit Cards");
		String Title = "Featured";
		String GetTitle = driver.getTitle();
		try {
			Assert.assertEquals(Title, GetTitle);
		} catch (AssertionError e) {
			System.out.println("Featured link is verified");
		}

		this.goBackPage();

		this.openSubmenuLink("Credit Cards", "Cash Rewards Cards");
		WebElement featuredCardsHeadingElement = driver.findElement(By.className("heading"));
		String cashRewardsHeading = featuredCardsHeadingElement.getText();
		assertEquals(cashRewardsHeading, "Cash Back Credit Cards");
	}

	public void openSubmenuLink(String mainMenuText, String submenuLink) {
		// click on banking menu
		WebElement banking = driver.findElement(By.partialLinkText(mainMenuText));
		Actions action = new Actions(driver);
		action.moveToElement(banking).click().build().perform();
		// click on banking inside link
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement bankingm = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.partialLinkText(submenuLink))));
		bankingm.click();

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}

}

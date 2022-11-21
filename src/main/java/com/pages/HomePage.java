package com.pages;

import com.microsoft.playwright.Page;

public class HomePage extends BasePage {

public HomePage(Page page) {
	super(page);
}

public void openApplication() {
	page.navigate("https://the-internet.herokuapp.com/");
	page.locator("//a[contains(.,'Checkboxes')]").click();
	page.locator("(//input[@type='checkbox'])[1]").click();
}

public void openComputerDatabase() {
	page.navigate("https://computer-database.gatling.io/computers");
	page.click("//a[contains(.,'Add a new computer')]");
	page.locator("//input[@id='name']").fill("HP");
	page.locator("//input[@id='introduced']").fill("2021-08-22");
	page.locator("//input[@id='discontinued']").fill("2022-03-10");
	page.locator("//select[@id='company']").selectOption("5");
}

}

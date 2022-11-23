package com.pages;

import com.microsoft.playwright.Page;

public class Login extends BasePage {
public Login(Page page) {
	super(page);
}

public void login() {

	// Go to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
	page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	// Click [placeholder="Username"]
	page.locator("[placeholder=\"Username\"]").click();

	// Fill [placeholder="Username"]
	page.locator("[placeholder=\"Username\"]").fill("Admin");

	// Click [placeholder="Password"]
	page.locator("[placeholder=\"Password\"]").click();

	// Fill [placeholder="Password"]
	page.locator("[placeholder=\"Password\"]").fill("admin123");

	// Click button:has-text("Login")
	page.locator("button:has-text(\"Login\")").click();

}

public void logout(){


	// Click text=Geeta Collings
	page.locator("text=Geeta Collings").click();

	// Click text=Logout
	page.locator("text=Logout").click();

	// Click h5:has-text("Login")
	page.locator("h5:has-text(\"Login\")").click();
}
}


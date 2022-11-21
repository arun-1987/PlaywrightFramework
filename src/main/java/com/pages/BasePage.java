package com.pages;


import com.microsoft.playwright.Page;


public class BasePage {

Page page;

public BasePage(Page page) {
	this.page = page;
}


public boolean isPageChecked(String locator) {
	return page.isChecked(locator);
}

}

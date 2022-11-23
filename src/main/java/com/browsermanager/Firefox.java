package com.browsermanager;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class Firefox implements IBrowserType{
@Override
public Browser getBrowserType() {
	Playwright playwright = Playwright.create();
	return playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
}
}

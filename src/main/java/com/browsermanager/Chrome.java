package com.browsermanager;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class Chrome implements IBrowserType {


@Override
public Browser getBrowserType() {
	Playwright playwright = Playwright.create();
	return playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
}




}

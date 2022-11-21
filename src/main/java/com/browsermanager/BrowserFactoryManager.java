package com.browsermanager;

import com.helper.LoggerHelper;
import com.microsoft.playwright.*;
import org.apache.logging.log4j.Logger;


public class BrowserFactoryManager {
private static Logger logger = LoggerHelper.getLogger(BrowserFactoryManager.class);
private String browserType;

Browser browser;


public BrowserFactoryManager(String browserType) {
	this.browserType = browserType;
}

public Browser launchBrowser() {
	logger.info("Running launchBrowser...");
	Playwright playwright = Playwright.create();
	switch (browserType.toLowerCase()) {
		case "chrome":
			browser = new Chrome().getBrowserType();
			break;
		default:
			System.out.println("Pass the correct browserType.... Suggestions include chrome,firefox");
			break;
	}
	logger.info("Browser object of type : " + browserType.toLowerCase() + " created successfully...");
	return browser;
}

public void quitBrowser() {
	logger.info("Running quit browser...");
	browser.close();
}


}

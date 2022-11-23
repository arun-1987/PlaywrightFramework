package com.browsermanager;

import com.helper.LoggerHelper;
import com.microsoft.playwright.*;
import org.apache.logging.log4j.Logger;


public class BrowserFactoryManager {
private static Logger logger = LoggerHelper.getLogger(BrowserFactoryManager.class);
private String browserType;

IBrowserType ibrowserType;
private Browser browser;

public BrowserFactoryManager(String browserType) {
	this.browserType = browserType;
}

public Browser launchBrowser() {
	logger.info("Running launchBrowser...");
	switch (browserType.toLowerCase()) {
		case "chrome":
			ibrowserType = new Chrome();
			break;
		case "firefox":
			ibrowserType = new Firefox();
			break;
		default:
			System.out.println("Pass the correct browserType.... Suggestions include chrome,firefox");
			break;
	}
	logger.info("Browser object of type : " + browserType.toLowerCase() + " created successfully...");
	this.browser= ibrowserType.getBrowserType();
	return browser;
}

public void quitBrowser() {
	logger.info("Running quit browser...");
	browser.close();
}


}

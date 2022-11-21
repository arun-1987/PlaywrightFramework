package com.testbase;
import com.browsermanager.BrowserFactoryManager;
import com.helper.LoggerHelper;
import com.microsoft.playwright.*;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseTest {
private static List<BrowserFactoryManager> playwrightThreadPool = Collections.synchronizedList(new ArrayList<>());
private static ThreadLocal<BrowserFactoryManager> browserFactoryThread;
private static Logger logger = LoggerHelper.getLogger(BaseTest.class);

public Browser browser;
public Page page;


@Parameters({"browser"})
@BeforeTest(alwaysRun = true)
public void beforeTest(String browserType) {
	logger.info("Running beforeTest....");
	instantiateBrowser(browserType);
}


@AfterTest
public void afterTest() {
	logger.info("Running afterTest....");
	page.close();
}

@AfterSuite
public void afterSuite() {
	logger.info("Running afterSuite....");
	playwrightThreadPool.forEach(browser -> browser.quitBrowser());
}


/**
 * Function to instantiate browser Type
 *
 * @param browserType
 */
public void instantiateBrowser(String browserType) {
	logger.info("Running instantiateBrowser....");
	browserFactoryThread = ThreadLocal.withInitial(
			() -> {
				BrowserFactoryManager browserFactoryManager = new BrowserFactoryManager(browserType);
				playwrightThreadPool.add(browserFactoryManager);
				return browserFactoryManager;
			}
	);
	browser = browserFactoryThread.get().launchBrowser();
	page = browser.newPage();
	logger.info("New Page created successfully....");
}


}

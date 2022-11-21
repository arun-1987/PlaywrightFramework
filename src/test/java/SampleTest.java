import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.pages.HomePage;
import com.testbase.BaseTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SampleTest extends BaseTest {

@Test
public void checkBoxTest() throws InterruptedException {
	HomePage homePage = new HomePage(page);
	homePage.openApplication();
	Thread.sleep(15000);
	assertThat(homePage.isPageChecked("(//input[@type='checkbox'])[1]")).isEqualTo(true);
}

@Test
public void handleModelWindow() throws InterruptedException {
	HomePage homePage = new HomePage(page);
	Thread.sleep(15000);
	homePage.openComputerDatabase();
}

}

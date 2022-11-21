import com.pages.HomePage;
import com.testbase.BaseTest;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FirstTest extends BaseTest{


	@Test
	public void checkBoxTest(){
		HomePage homePage = new HomePage(page);
		homePage.openApplication();
		assertThat(homePage.isPageChecked("(//input[@type='checkbox'])[1]")).isEqualTo(true);
	}

	@Test
	public void handleModelWindow(){
		HomePage homePage = new HomePage(page);
		homePage.openComputerDatabase();
	}

}

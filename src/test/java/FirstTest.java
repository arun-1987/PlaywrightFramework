import com.pages.HomePage;
import com.pages.Login;
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
		Login login = new Login(page);
		login.login();
		assertThat(page.url()).isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		login.logout();
		assertThat(page.url()).isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

}

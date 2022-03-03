package Fredrick.Li.Personal.Cloud.Storage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonalCloudStorageApplicationTests {
	@LocalServerPort
	public static WebDriver driver;
	protected int port;
	public String baseUrl;

	@BeforeAll
	public static void beforeAll(){
		WebDriverManager.chromedriver().setup();
	}
	@AfterAll
	public static void afterAll(){
		driver.quit();
		driver = null;
	}
	@BeforeEach
	public void beforeEach(){
		baseUrl = "http://localhost:" + this.port;
		driver = new ChromeDriver();
	}

	@Test
	public void LoginTest(){
		driver.get(baseUrl + "/login");
		Assertions.assertEquals("Login", driver.getTitle());
	}

	public void SignupTest(){
		String firstName = "Fredrick";
		String lastname = "Li";
		String username = "fl123";
		String password = "123456";

		driver.get(baseUrl + "/signup");
		SignupPage signupPage = new SignupPage(driver);
		signupPage.signUp(firstName, lastname, username, password);
		driver.get(baseUrl + "/login");
		LoginPage loginPage = new LoginPage();
		loginPage.login(username, password);

		Assertions.assertEquals("Home", driver.getTitle());


	}

}

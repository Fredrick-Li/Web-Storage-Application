package Fredrick.Li.Personal.Cloud.Storage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserAccessTest {
    private static WebDriver driver;
    @LocalServerPort
    private int port;

    String baseUrl;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
        driver = null;
    }

    @BeforeEach
    public void beforeEach() {
        baseUrl = "http://localhost:" + this.port;
    }

    @Test
    public void testPageAccess() {
        driver.get(baseUrl + "/login");
        Assertions.assertEquals("Login", driver.getTitle());

        driver.get(baseUrl + "/signup");
        Assertions.assertEquals("Sign Up", driver.getTitle());

        // should redirect to login page
        driver.get(baseUrl + "/home");
        Assertions.assertEquals("Login", driver.getTitle());
    }

    public void signupAccessTest(){
        driver.get(baseUrl + "/signup");
        SignupPage signupPage = new SignupPage(driver);
        signupPage.signUp("parry", "li", "parryyoyoyo", "123456");
        driver.get(baseUrl + "/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("parryyoyoyo", "123456");
        HomePage homePage = new HomePage(driver);
        homePage.logout();

        //should be redirected to login page
        driver.get(baseUrl + "/home");
        Assertions.assertEquals("Login", driver.getTitle());

    }
}

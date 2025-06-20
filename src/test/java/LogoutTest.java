package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.LogoutPage;
import org.openqa.selenium.By;

import java.time.Duration;

public class LogoutTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private final String baseUrl = "http://localhost:8080/";
    private By signInButton = By.xpath("/html/body/div/form/div/button");

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    @Tag("logout")
    public void testLogoutAfterLogin() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Testas12345", "TestukasRudnosiukas");


        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.logout();


        Assertions.assertTrue(driver.getPageSource().contains(".form-group"));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

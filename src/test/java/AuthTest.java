package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuthTest {
    private WebDriver driver;
    private final String baseUrl = "http://localhost:8080/";

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    @Order(1)
    @Tag("auth")
    public void testLoginPositive() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Testas12345", "TestukasRudnosiukas");

        Assertions.assertTrue(driver.getPageSource().contains("Testas12345"));
    }

    @Test
    @Order(2)
    @Tag("auth")
    public void testLoginNegative() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Testukas111", "wrongpass");

        Assertions.assertTrue(driver.getPageSource().contains("neteisingi"));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

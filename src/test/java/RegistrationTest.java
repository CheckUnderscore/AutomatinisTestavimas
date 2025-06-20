package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegistrationPage;

import java.time.Duration;
import java.util.UUID;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegistrationTest {

    private WebDriver driver;
    private final String baseUrl = "http://localhost:8080/";

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


    @Test
    @Order(1)
    @Tag("registration")
    public void testPositiveRegistration() {
        driver.findElement(By.cssSelector("a[href]")).click();

        RegistrationPage regPage = new RegistrationPage(driver);

        String username = "Testas" + UUID.randomUUID().toString().substring(0, 5);
        regPage.register(username, "Testas123!", "Testas123!");

        Assertions.assertTrue(driver.getPageSource().contains(username));
    }

    @Test
    @Order(1)
    @Tag("registration")
    public void testNegativeRegistration() {
        driver.findElement(By.cssSelector("a[href]")).click();

        RegistrationPage regPage = new RegistrationPage(driver);

        String username = "Testas" + UUID.randomUUID().toString().substring(0, 5);
        regPage.register(username, "Testas123!", "");

        Assertions.assertTrue(driver.getPageSource().contains("Įvesti slaptažodžiai nesutampa"));
    }
}

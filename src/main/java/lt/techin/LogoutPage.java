package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {

    private WebDriver driver;
    private By logoutLink = By.cssSelector("body > nav > div > ul.nav.navbar-nav.navbar-right > a");


    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logout() {
        driver.findElement(logoutLink).click();
    }
}

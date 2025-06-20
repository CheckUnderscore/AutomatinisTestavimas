package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;

    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By passwordConfirmField = By.name("passwordConfirm");
    private By saveButton = By.xpath("//*[@id='userForm']/button");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForm(String username, String password, String passwordConfirm) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(passwordConfirmField).sendKeys(passwordConfirm);

    }

    public void submitForm() {
        driver.findElement(saveButton).click();
    }

    public void register(String username, String password, String passwordConfirm) {
        fillForm(username, password, passwordConfirm);
        submitForm();
    }
}

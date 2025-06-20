package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PageEntry {
    private WebDriver driver;

    private By number1 = By.name("sk1");
    private By number2 = By.name("sk2");
    private By sign = By.name("zenklas");
    private By saveButton = By.xpath("//*[@id='number']/input[3]");

}

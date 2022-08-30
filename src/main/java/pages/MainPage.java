package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver driver;
    private final By logInButton = By.cssSelector("a[data-qa-id='login']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLogInPage() {
        driver.findElement(logInButton).click();
    }
}

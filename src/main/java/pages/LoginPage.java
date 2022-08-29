package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By logInButton = By.id("logIn");
    private final By error = By.cssSelector("p[data-qa-id='error-display']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private void waitForVisibility(WebElement element) throws Error {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogInButton() {
        driver.findElement(logInButton).click();
        new HomePage(driver);
    }

    public void logIn(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLogInButton();
    }

    public WebElement error() {
        return driver.findElement(error);
    }

    public void waitForError() {
        waitForVisibility(error());
    }

    public String getErrorText() {
        waitForError();
        return driver.findElement(error).getText();
    }
}

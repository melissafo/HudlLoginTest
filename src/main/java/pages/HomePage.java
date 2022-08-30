package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private final WebDriver driver;
    private final By userMenu = By.cssSelector("div.hui-globalusermenu");
    private final By webNav = By.cssSelector("div#ssr-webnav");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    private void waitForVisibility(WebElement element) throws Error {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public String getUrl() {
        waitForVisibility(webNav());
        return driver.getCurrentUrl();
    }

    public WebElement userMenu() {
        return driver.findElement(userMenu);
    }

    public void userMenuIsDisplayed() {
        waitForVisibility(webNav());
        userMenu().isDisplayed();
    }

    public WebElement webNav() {
        return driver.findElement(webNav);
    }
}

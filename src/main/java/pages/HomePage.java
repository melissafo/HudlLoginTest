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

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    private void waitForVisibility(WebElement element) throws Error {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement userMenu() {
        return driver.findElement(userMenu);
    }

    public void waitForUserMenu() {
        waitForVisibility(userMenu());
    }

    public WebElement getWebNav() {
        return driver.findElement(webNav);
    }

    public void waitForWebNav() {
        waitForVisibility(getWebNav());
    }
}

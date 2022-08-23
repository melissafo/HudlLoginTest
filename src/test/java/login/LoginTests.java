package login;

import base.BaseTests;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import utility.ReadConfig;

public class LoginTests extends BaseTests {

    String email = ReadConfig.getProperty("user.email");
    String password = ReadConfig.getProperty("user.password");
    String homePageUrl = "https://www.hudl.com/home";
    String errorMessage = "We didn't recognize that email and/or password.Need help?";
    String invalidEmail = "test@4069343.com";
    String invalidPassword = "V6$ho*Bg847!";

    @Test
    public void navigateToHomePageAfterValidLogIn() {
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        HomePage homePage = loginPage.clickLogInButton();
        homePage.waitForWebNav();
        String url = homePage.getUrl();
        Assert.assertEquals(homePageUrl, url);
    }

    @Test
    public void homePageUserMenuExistsAfterValidLogIn() {
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        HomePage homePage = loginPage.clickLogInButton();
        homePage.waitForWebNav();
        homePage.waitForUserMenu();
        WebElement userMenu = homePage.userMenu();
        Assert.assertTrue(userMenu.isEnabled());
    }

    @Test
    public void errorDisplayedWhenLogInWithNoEmail() {
        loginPage.setEmail(email);
        loginPage.clickLogInButton();
        loginPage.waitForError();
        Assert.assertEquals(errorMessage,loginPage.getErrorText());
    }

    @Test
    public void errorDisplayedWhenLogInWithNoPassword() {
        loginPage.setPassword(password);
        loginPage.clickLogInButton();
        loginPage.waitForError();
        Assert.assertEquals(errorMessage,loginPage.getErrorText());
    }

    @Test
    public void errorDisplayedWhenLogInWithNoEmailNoPassword() {
        loginPage.clickLogInButton();
        loginPage.waitForError();
        Assert.assertEquals(errorMessage,loginPage.getErrorText());
    }

    @Test
    public void errorDisplayedWhenLogInWithInvalidEmailValidPassword() {
        loginPage.setEmail(invalidEmail);
        loginPage.setPassword(password);
        loginPage.clickLogInButton();
        loginPage.waitForError();
        Assert.assertEquals(errorMessage,loginPage.getErrorText());
    }

    @Test
    public void errorDisplayedWhenLogInWithValidEmailInvalidPassword() {
        loginPage.setEmail(email);
        loginPage.setPassword(invalidPassword);
        loginPage.clickLogInButton();
        loginPage.waitForError();
        Assert.assertEquals(errorMessage,loginPage.getErrorText());
    }
}

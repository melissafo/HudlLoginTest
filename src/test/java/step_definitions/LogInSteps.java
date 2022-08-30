package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.MainPage;
import utility.ReadConfig;

public class LogInSteps {

    private final WebDriver driver = Hooks.driver;
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    MainPage mainPage = new MainPage(driver);

    String email = ReadConfig.getProperty("user.email");
    String password = ReadConfig.getProperty("user.password");
    String homePageUrl = "https://www.hudl.com/home";
    String errorMessage = "We didn't recognize that email and/or password.Need help?";
    String invalidEmail = "test@4069343.com";
    String invalidPassword = "V6$ho*Bg847!";

    @Given("the user is on the log in page")
    public void the_user_is_on_the_log_in_page() {
        mainPage.navigateToLogInPage();
    }

    @When("the user logs in with a valid email and password")
    public void the_user_logs_in_with_a_valid_email_and_password() {
        loginPage.logIn(email, password);
    }

    @Then("the user is taken to the Home page")
    public void the_user_is_taken_to_the_home_page() {
        String url = homePage.getUrl();
        Assert.assertEquals(homePageUrl, url);
    }

    @Then("the user menu is displayed")
    public void the_user_menu_is_displayed() {
        homePage.userMenuIsDisplayed();
    }

    @When("the user logs in with  a valid password and no email")
    public void the_user_logs_in_with_a_valid_password_and_no_email() {
        loginPage.logIn("", password);
    }

    @Then("the user sees a helpful error message")
    public void the_user_sees_a_helpful_error_message() {
        Assert.assertEquals(errorMessage,loginPage.getErrorText());
    }

    @When("the user logs in with a valid email and no password")
    public void the_user_logs_in_with_a_valid_email_and_no_password() {
        loginPage.logIn(email, "");
    }

    @When("the user logs in with a no email and no password")
    public void the_user_logs_in_with_a_no_email_and_no_password() {
        loginPage.logIn("", "");
    }

    @When("the user logs in with an invalid email and a valid password")
    public void the_user_logs_in_with_an_invalid_email_and_a_valid_password() {
        loginPage.logIn(invalidEmail, password);
    }

    @When("the user logs in with a valid email and an invalid password")
    public void the_user_logs_in_with_a_valid_email_and_an_invalid_password() {
        loginPage.logIn(email, invalidPassword);
    }
}

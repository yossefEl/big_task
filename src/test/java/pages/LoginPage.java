package pages;

import helpers.CoockiesHelper;
import helpers.enums.FlashMessageType;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import static helpers.Locators.*;
import static helpers.SeleniumHelper.*;

public class LoginPage extends BasePage {

    public LoginPage(RemoteWebDriver driver) {
        super(driver, "users/sign_in");
    }


    public void loginWithCookies() {
        CoockiesHelper.usePrexisitngToken(driver);
        reloadCurrent();
        sleep(2);
    }


    private void fillLogin(String usr, String pass) {
        findAndFillInputField(usernameInputLocator, usr);
        findAndFillInputField(passwordInputLocator, pass);
        sleep(1);
        checkRememberMe();
        submitForm();
    }

    public void loginWithRandomData() {
        final String password = generatePassword();
        final String username = generateEmail();
        fillLogin(username, password);
        Assert.assertTrue(isFlashMessageSameAs(FlashMessageType.WARNING, "Invalid email address or password."));
        sleep(4);
    }

    public void successfulLogin() {
        fillLogin(getConfigs().goodUsername, getConfigs().goodPassword);
        sleep(2);//Waiting for the load of the page and avoid suspicious activity
        Assert.assertTrue(isFlashMessageSameAs(FlashMessageType.INFO, "You are now logged in."));
        sleep(4);
    }


    private void checkRememberMe() {
        final WebElement rememberMeCheckbox = waitVisibilityAndFindElement(rememberMeLoginLocator);
        rememberMeCheckbox.click();
    }

    public void submitForm() {
        final WebElement loginForm = waitVisibilityAndFindElement(loginFormLocator);
        loginForm.submit();
    }


}


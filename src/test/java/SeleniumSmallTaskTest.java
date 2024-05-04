import helpers.SeleniumHelper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static helpers.SeleniumHelper.waitForVisibilityOfElement;
import static helpers.SeleniumHelper.waitVisibilityAndFindElement;

public class SeleniumSmallTaskTest {

    private WebDriver driver;
    final String goodPassword = "SuperSecretPassword!";
    final String wrongPassword = "SuperSecretPassword";
    final String goodUsername = "tomsmith";
    final String wrongUsername = "theFamousJohnDoe";


    @Before
    public void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();
        SeleniumHelper.initialize(driver, 10,"http://the-internet.herokuapp.com");
    }


    @Test
    public void testSuccessfulLogin() {
        openPage("/login");
        login(goodUsername, goodPassword);
        SeleniumHelper.sleep(1);
        Assert.assertTrue(hasMessage("You logged into a secure area!", SeleniumHelper.flashMessageLocator));
    }


    @Test
    public void testLogout() {
        openPage("/login");
        login(goodUsername, goodPassword);
        logout();
        SeleniumHelper.sleep(1);
        Assert.assertTrue(hasMessage("You logged out of the secure area!", SeleniumHelper.flashMessageLocator));
    }

    @Test
    public void testLoginWithWrongPassword() {
        openPage("/login");
        login(goodUsername, wrongPassword);
        SeleniumHelper.sleep(1);
        Assert.assertTrue(hasMessage("Your password is invalid!", SeleniumHelper.flashMessageLocator));

    }

    @Test
    public void testLoginWithWrongUsername() {
        openPage("/login");
        login(wrongUsername, goodPassword);
        SeleniumHelper.sleep(1);
        Assert.assertTrue(hasMessage("Your username is invalid!", SeleniumHelper.flashMessageLocator));
    }


    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    //helper methods
    private void openPage(String path) {
        this.driver.get(SeleniumHelper.url(path));
    }

    private void login(String username, String password) {
        final WebElement usernameField = waitVisibilityAndFindElement(SeleniumHelper.usernameInputLocator);
        usernameField.sendKeys(username);
        final WebElement passwordField = waitVisibilityAndFindElement(SeleniumHelper.passwordInputLocator);
        passwordField.sendKeys(password);
        final WebElement loginForm = waitVisibilityAndFindElement(SeleniumHelper.loginFormLocator);
        loginForm.submit();
    }

    private void logout() {
        final WebElement logoutLink = waitForVisibilityOfElement(SeleniumHelper.findElementByHref("/logout"));
        logoutLink.click();
    }

    private boolean hasMessage(String message, By locator) {
        final WebElement messageBlock = waitVisibilityAndFindElement(locator);
        return messageBlock != null && messageBlock.getText().contains(message);
    }

}

package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import static helpers.CoockiesHelper.gbcConsent;
import static helpers.CoockiesHelper.gbcConsentValue;
import static helpers.Locators.*;
import static helpers.SeleniumHelper.waitVisibilityAndFindElement;

public class HomePage extends BasePage {
    public HomePage(RemoteWebDriver driver) {
        super(driver, "");
    }


    public void agreeGbcConsent() {
        getJavascriptExecutor().executeScript("localStorage.setItem('" + gbcConsent + "','+" + gbcConsentValue + "')");
    }


    public void atLeast4Class() {
        Assert.assertTrue(isElementVisible(By.xpath(atLeast4Locator)));
    }


    public void atLeast6Class() {
        Assert.assertTrue(isElementVisible(By.xpath(atLeastL6Locator)));
    }

    public void atLeast8Class() {
        Assert.assertTrue(isElementVisible(By.xpath(atLeast8Locator)));
    }


    public void explicitWait() {
        final WebElement bigTitle = waitVisibilityAndFindElement(By.xpath(atLeast8Locator + "//h1"));
        Assert.assertEquals("Convert Anything to PDF", bigTitle.getText());
    }


    //    helper
    boolean isElementVisible(By by) {
        return !driver.findElements(by).isEmpty();
    }


}

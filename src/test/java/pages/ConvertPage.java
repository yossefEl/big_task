package pages;

import helpers.Locators;
import helpers.SeleniumHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import static helpers.SeleniumHelper.waitVisibilityAndFindElement;

public class ConvertPage extends BasePage {
    public ConvertPage(RemoteWebDriver driver) {
        super(driver, "pdf-tools/pdf-converter");
    }

    public void scroll2LogosSection() {
        final WebElement logosSection = waitVisibilityAndFindElement(Locators.logosSectionLocator);
        SeleniumHelper.scrollToElement(logosSection);
        final WebElement title = logosSection.findElement(new By.ByClassName("heading-style-h3"));
        Assert.assertEquals("Trusted by the World's Leading Organizations", title.getText());
    }

}

package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators {


    public static final By usernameInputLocator = By.id("Email");
    public static final By passwordInputLocator = By.id("Password");
    public static final By rememberMeLoginLocator = By.id("user_remember_me");

    public static final By currentPasswordInputLocator = By.id("user_current_password");
    public static final By newPasswordInputLocator = By.id("user_password");
    public static final By confirmPasswordInputLocator = By.id("user_password_confirmation");
    public static final By profileSettingsLocator = By.id("My Account");
    public static final By editPageDropTarget = By.className("icon-embed-medium");
    public static final By editPageDownloadButtonLocator = By.id("apryse-download");
    public static final By loginFormLocator = By.xpath("//form[@id='new_user']");
    public static final By pdfToolsDropDownLocator = By.xpath("//div[@class='header__dropdown-btn']");

    public static final By pdfConverterH2Locator = By.xpath("//section[@class='section_header-tool']//h1[@class='heading-style-h2']");
    public static final By editPageUploadFileLocator = By.xpath("//input[@type='file' and @class='file-upload_input w-file-upload-input']");

    public static final By editPageDragAndDropSourceLocator = By.xpath("//img[@class='icon-1x1-medium margin-right margin-small']");
    public static final By logosSectionLocator = By.xpath("//section[@class='section_logos']");
    public static final String atLeast4Locator = "//main[@class='main-wrapper']//section[@class='section_hero-home']//div[@class='padding-global']//div[@class='container-large']//div[@class='hero-home_component']";
    public static final String atLeastL6Locator = atLeast4Locator + "//div[@class='padding-section-medium']//div[@class='text-align-center']";
    public static final String atLeast8Locator = atLeastL6Locator + "//div[@class='max-width-xlarge align-center']//div[@class='margin-bottom margin-small']";
    public static By businessAdrTextAreaLocator = By.xpath("//textarea[@class='form-control form-input text optional']");

    public static WebElement findElementByHref(WebDriver driver, String href) {
        return driver.findElement(By.xpath("//a[@href='" + href + "']"));
    }

    public static By flashMessageLocator(String alertType) {
        return By.xpath("//div[@class='flash-messages']//div[@class='alert alert-dismissable alert-" + alertType + "']");
    }

    public static By saveBillingInfoButtonLocator(String dir) {
        return By.xpath("//div[@class='profile__" + dir + "-panel']//div[@class='profile__actions-panel']//input[@type='submit']");
    }

}

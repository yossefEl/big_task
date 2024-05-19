package helpers;

import config.SeleniumConfigs;
import helpers.enums.FlashMessageType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static helpers.Locators.flashMessageLocator;

public class SeleniumHelper {


    static final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    public static String url = "";
    private static RemoteWebDriver driver;
    private static SeleniumConfigs configs;

    public static SeleniumConfigs getConfigs() {
        return configs;
    }

    public static void setConfigs(SeleniumConfigs configs) {
        SeleniumHelper.configs = configs;
    }

    public static JavascriptExecutor getJavaScriptExecutor() {
        return driver;
    }

    public static void initialize(RemoteWebDriver webDriver, int seconds, String testingUrl) {
        driver = webDriver;
        configs.waitDuration = seconds;
        url = testingUrl;
    }


    public static void setWaitDuration(int seconds) {
        configs.waitDuration = seconds;
    }


    public static WebElement waitVisibilityAndFindElement(By locator) {
        return waitForVisibilityOfElement(driver.findElement(locator));
    }

    public static WebElement waitForVisibilityOfElement(WebElement element) {
        final WebDriverWait wait = new WebDriverWait(driver, configs.waitDuration);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }


    public static String url(String path) {
        return url + "/" + path;
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            System.out.println("Exception occurred");
        }
    }

    public static ChromeOptions getOptions() {
        final ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-agent=" + configs.HEADERS_AGENT);
        options.setCapability("browserName", "chrome");
        options.setCapability("browserVersion", "124.0.6367.202");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", configs.DOWNLOAD_FOLDER);
        prefs.put("download.prompt_for_download", true);
        prefs.put("download.directory_upgrade", true);
        options.setExperimentalOption("prefs", prefs);
        return options;
    }

    public static void openPage(String path) {
        if (!path.startsWith("http")) {
            driver.get(url(path));
        } else {
            driver.get(path);
        }
    }

    public static void openNewTab(String url) {
        getJavaScriptExecutor().executeScript("window.open('" + url + "')");
    }


    public static void switchToTab(int index) {
        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(index));
        } catch (Exception e) {
            System.out.println("Exception occurred, stack: " + e);
        }
    }

    public static void closeCurrentTab() {
        getJavaScriptExecutor().executeScript("window.close()");
    }

    public static void hoverOverElement(WebElement locator) {
        Actions action = new Actions(driver);
        action.moveToElement(locator).perform();
    }

    static private String getRandomStringOfLength(int length) {
        final StringBuilder email = new StringBuilder();
        for (int i = 0; i < length; i++) {
            email.append(chars.charAt((int) Math.floor(Math.random() * chars.length())));
        }

        return email.toString();
    }

    public static String generateEmail() {
        return getRandomStringOfLength(12) + "@gmail.com";
    }

    public static String generatePassword() {
        return getRandomStringOfLength(9);
    }

    public static boolean isFlashMessageSameAs(FlashMessageType type, String message) {
        final WebElement messageElement = waitVisibilityAndFindElement(flashMessageLocator(type.getType()));
        return messageElement.getText().contains(message);
    }

    public static void findAndFillInputField(By locator, String value) {
        final WebElement element = waitVisibilityAndFindElement(locator);
        element.clear();
        element.sendKeys(value);
        sleep(1);
    }

    public static void findAndClickElement(By locator) {
        final WebElement element = waitVisibilityAndFindElement(locator);
        element.click();
    }


    public static void navigateBack() {
        driver.navigate().back();
        sleep(1);
    }

    public static void navigateForward() {
        driver.navigate().forward();
        sleep(1);
    }

    public static void scrollToElement(WebElement element) {
        getJavaScriptExecutor().executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void uploadFile(WebElement target, String filePath) {
        {
            driver.setFileDetector(new LocalFileDetector());
            String currentDir = System.getProperty("user.dir");
            File file = new File(currentDir + filePath);
            target.sendKeys(file.getAbsolutePath());
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.urlMatches("https://www.printfriendly.com/pdf-viewer/.*"));

        }
    }


}

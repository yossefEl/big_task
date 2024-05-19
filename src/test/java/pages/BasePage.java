package pages;

import helpers.SeleniumHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;

import static helpers.SeleniumHelper.sleep;

abstract public class BasePage {
    protected final RemoteWebDriver driver;
    private String path;

    public BasePage(RemoteWebDriver driver, String path) {
        this.driver = driver;
        this.path = path;
    }


    public JavascriptExecutor getJavascriptExecutor() {
        return (JavascriptExecutor) driver;
    }

    public void reloadCurrent() {
        driver.navigate().refresh();
        sleep(2);//Waiting for the load of the page and avoid suspicious activity
    }

    public String getPath() {
        return path;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void openPage() {
        SeleniumHelper.openPage(path);
        sleep(2);
    }


}

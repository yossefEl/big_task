package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class SeleniumHelper {


//    String usrnameInputLocator="username";

    private  static WebDriver driver;
    private static int waitDuration = 10;
    public static String url ="";

    public static By usernameInputLocator=By.id("username");
    public static By passwordInputLocator=By.id("password");
    public static By loginFormLocator= By.id("login");
    public static By flashMessageLocator=By.id("flash");

    public static WebElement findElementByHref(String href){
        return driver.findElement(By.xpath("//a[@href='"+href+"']"));
    }

    public static void initialize(WebDriver webDriver, int seconds, String testingUrl) {
        driver=webDriver;
        waitDuration=seconds;
        url = testingUrl;
    }
    public static void setWaitDuration(int seconds) {
        waitDuration = seconds;
    }


    public static WebElement waitVisibilityAndFindElement( By locator) {
        return waitForVisibilityOfElement(driver.findElement(locator));
    }

    public static WebElement waitForVisibilityOfElement(WebElement element){
        final WebDriverWait wait = new WebDriverWait(driver, waitDuration);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }


    public static  String url(String path){
        return url+"/"+path;
    }

    public static void sleep(int seconds) {
        try{
            Thread.sleep(seconds * 1000L);
        }
        catch (InterruptedException e){
            System.out.println("Exception occurred");
        }
    }
}

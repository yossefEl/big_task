package tests;

import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class GoogleSearchTest {
    public WebDriver driver;
    public WebDriverWait wait;
    protected Boolean isJsSupported;
    
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        if(!Boolean.getBoolean("openBrowser")) {
            options.addArguments("--headless");
        }

        options.addArguments("--disable-gpu");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-default-apps");
        options.addArguments("--start-maximized");
        options.addArguments("--no-sandbox");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--lang=en");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10);

        isJsSupported = driver instanceof JavascriptExecutor;
    }
    
    private final By queryInputLocator = By.name("q");
    private final By searchButtonLocator = By.name("btnK");
    private final By resultLocator = By.xpath("//div[@class='footer-block']");

    @Test
    public void testSearch() {
        this.driver.get("https://www.inf.elte.hu/en/");
        
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(resultLocator));
        WebElement resultElement = this.driver.findElement(resultLocator);
        
        Assert.assertTrue(resultElement.getText().contains("2021 ELTE Faculty of Informatics"));
    }
    

    
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}

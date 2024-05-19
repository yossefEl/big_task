import config.SeleniumConfigs;
import helpers.SeleniumHelper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;

import static helpers.CoockiesHelper.isUserSignedIn;
import static helpers.SeleniumHelper.*;

public class BigSeleniumTaskTest {

    private RemoteWebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private ConvertPage convertPage;
    private CompressPage compressPage;
    private EditPage editPage;


    @Before
    public void setup() throws MalformedURLException {
        final String sepc = "http://selenium:4444/wd/hub";

        SeleniumHelper.setConfigs(SeleniumConfigs.loadConfigs());
        ChromeOptions options = getOptions();
        driver = new RemoteWebDriver(new URL(sepc), options);
        System.out.println("Config loaded: SeleniumConfigs:" + SeleniumHelper.getConfigs());
        driver.manage().window().maximize();
        initialize(driver, 10, getConfigs().getFullTargerLink());
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        convertPage = new ConvertPage(driver);
        compressPage = new CompressPage(driver);
        editPage = new EditPage(driver);
    }


    @Test
    public void testing() {
        //  PLEASE SET A COOKIE IN the [config/configs.json] class
        //  before running the test so that loginWithCookies can work properly
        homePage.openPage();
        sleep(3);
        homePage.agreeGbcConsent();
        loginPage.loginWithCookies();

        homePage.reloadCurrent();
        if (isUserSignedIn(driver)) {
            profilePage.openPage();
            profilePage.logout();
            loginPage.openPage();
        }
        loginPage.loginWithRandomData();
        loginPage.successfulLogin();

        profilePage.fillBusinessAdrTextArea();
        profilePage.changePassword(getConfigs().goodPassword, getConfigs().changePasswordTemp);
        profilePage.changePassword(getConfigs().changePasswordTemp, getConfigs().goodPassword);
        profilePage.hoverTest();

        //equivalent to because this was the previous page homePage.openPage();
        homePage.openPage();
        homePage.atLeast4Class();
        homePage.atLeast6Class();
        homePage.atLeast8Class();
        homePage.explicitWait();

        for (String path : getConfigs().pagesPaths2Visit) {
            System.out.println("Visiting: " + path);

            try {
                openPage(path);
                sleep(2);
            } catch (Exception e) {
                System.out.println("Error occurred while opening the page: " + path);
            }


            switch (path) {

                case "pdf-tools/pdf-converter":
                    Assert.assertEquals("Free PDF Converter - Convert PDFs Easily - PrintFriendly", convertPage.getPageTitle());
                    convertPage.scroll2LogosSection();
                    sleep(3);
                    break;

                case "pdf-tools/compress-pdf":
                    Assert.assertEquals("Compress PDF Documents Online For Free - PrintFriendly", compressPage.getPageTitle());
                    Assert.assertEquals("Compress PDF", compressPage.getH2Title());
                    sleep(2);
                    break;

                case "pdf-tools/edit-pdf":
                    editPage.openPage();
                    System.out.println("Edit page is being visited");
                    Assert.assertEquals("Free PDF Editor to Edit PDFs Online - PrintFriendly", editPage.getPageTitle());
                    editPage.dragAndDrop();
                    sleep(5);
                    editPage.testUploadFile();
                    editPage.downloadFile();
                    break;
            }
        }
        navigateBack();
        sleep(2);
        profilePage.openPage();
        profilePage.logout();
    }


    @After
    public void tearDown() {
        driver.quit();
    }


}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import static helpers.Locators.pdfConverterH2Locator;
import static helpers.SeleniumHelper.waitVisibilityAndFindElement;

public class CompressPage extends BasePage {
    public CompressPage(RemoteWebDriver driver) {
        super(driver, "pdf-tools/compress-pdf");
    }


    public String getH2Title() {
        final WebElement h2 = waitVisibilityAndFindElement(pdfConverterH2Locator);
        if (h2 == null) {
            return "";
        }
        return h2.getText();
    }

}

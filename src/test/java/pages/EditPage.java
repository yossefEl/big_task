package pages;

import helpers.Locators;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import static helpers.SeleniumHelper.*;

public class EditPage extends BasePage {


    public EditPage(RemoteWebDriver driver) {
        super(driver, "pdf-tools/edit-pdf");
    }


    public void testUploadFile() {
        final WebElement fileUploadLocator = driver.findElement(Locators.editPageUploadFileLocator);
        uploadFile(fileUploadLocator, getConfigs().FILE_UPLOAD_TEST);
        sleep(5);
    }

    public void downloadFile() {
        final WebElement downloadButton = waitVisibilityAndFindElement(Locators.editPageDownloadButtonLocator);
        Assert.assertEquals("Download", downloadButton.getText());
        downloadButton.click();
        sleep(5);
    }


    public void dragAndDrop() {
        final WebElement source = waitVisibilityAndFindElement(Locators.editPageDragAndDropSourceLocator);
        final WebElement target = driver.findElement(Locators.editPageDropTarget);
        Actions builder = new Actions(driver);
        builder.dragAndDrop(source, target).build().perform();
        sleep(5);
    }
}



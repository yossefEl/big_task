package pages;

import helpers.SeleniumHelper;
import helpers.enums.FlashMessageType;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import static helpers.CoockiesHelper.isUserSignedIn;
import static helpers.Locators.*;
import static helpers.SeleniumHelper.*;

public class ProfilePage extends BasePage {


    public ProfilePage(RemoteWebDriver driver) {
        super(driver, "users/edit");
    }

    public void fillBusinessAdrTextArea() {
        findAndFillInputField(businessAdrTextAreaLocator, getConfigs().businessAdr());
        sleep(3);
        findAndClickElement(saveBillingInfoButtonLocator("right"));
        Assert.assertTrue(isFlashMessageSameAs(FlashMessageType.SUCCESS, "Reciept Information updated successfully"));
        sleep(3);
    }


    public void changePassword(String currentPassword, String newPassword) {
        Assert.assertTrue(isUserSignedIn(driver));
        findAndFillInputField(currentPasswordInputLocator, currentPassword);
        findAndFillInputField(newPasswordInputLocator, newPassword);
        findAndFillInputField(confirmPasswordInputLocator, newPassword);
        sleep(2);
        findAndClickElement(saveBillingInfoButtonLocator("left"));
        sleep(3);

    }


    public void hoverTest() {
        final WebElement pdfToolsDropDown = waitVisibilityAndFindElement(pdfToolsDropDownLocator);
        Assert.assertFalse(isDropDownExpanded(pdfToolsDropDown));

        SeleniumHelper.hoverOverElement(pdfToolsDropDown);
        System.out.println("Hovered");

        Assert.assertTrue(isDropDownExpanded(pdfToolsDropDown));
        sleep(2);
    }

    private boolean isDropDownExpanded(WebElement element) {
        if (element == null) return false;
        final String attribue = element.getAttribute("aria-expanded");
        final boolean isExpanded = attribue != null && attribue.equals("true");
        System.out.println("isDropDownExpanded(pdfToolsDropDown) = " + isExpanded);
        return isExpanded;
    }


    public void logout() {
        final WebElement profileOptions = waitVisibilityAndFindElement(profileSettingsLocator);
        hoverOverElement(profileOptions);
        final WebElement logoutButton = waitForVisibilityOfElement(findElementByHref(driver, "/users/sign_out"));
        logoutButton.click();
        sleep(3);
    }

}

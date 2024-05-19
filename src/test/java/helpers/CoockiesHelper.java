package helpers;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import static helpers.SeleniumHelper.getConfigs;
import static helpers.SeleniumHelper.sleep;

public class CoockiesHelper {
    public static final String gbcConsent = "gbc_consent";
    public static final String gbcConsentValue = "[{\"id\":1,\"defaultValue\":\"DENIED\",\"selected\":true},{\"id\":2,\"defaultValue\":\"DENIED\",\"selected\":true},{\"id\":3,\"defaultValue\":\"DENIED\",\"selected\":true},{\"id\":4,\"defaultValue\":\"DENIED\",\"selected\":true},{\"id\":5,\"defaultValue\":\"DENIED\",\"selected\":true},{\"id\":6,\"defaultValue\":\"DENIED\",\"selected\":true},{\"id\":7,\"defaultValue\":\"DENIED\",\"selected\":true}]";

    public static boolean isUserSignedIn(WebDriver driver) {
        final Cookie cookie = retrievedUserSignedInCookie(driver);
        final Cookie pfProSessionCookie = retrievedPfProSessionCookie(driver);
        return pfProSessionCookie != null && cookie != null && cookie.getValue().equals("true");
    }

    public static Cookie retrievedPfProSessionCookie(WebDriver driver) {
        return driver.manage().getCookieNamed("_pf-pro_session");
    }

    private static Cookie retrievedUserSignedInCookie(WebDriver driver) {
        return driver.manage().getCookieNamed("user_signed_in");
    }


    public static void usePrexisitngToken(WebDriver driver) {
        Cookie pfProSessionCookie = new Cookie.Builder("_pf-pro_session", SeleniumHelper.getConfigs().COOKIE_AUTH_TOKEN)
                .domain(getConfigs().TARGET_WEBSITE)
                .path("/")
                .isHttpOnly(true)
                .build();

        Cookie userSignedInCookie = new Cookie.Builder("user_signed_in", "true")
                .domain(getConfigs().TARGET_WEBSITE)
                .path("/")
                .build();

        driver.manage().addCookie(pfProSessionCookie);
        driver.manage().addCookie(userSignedInCookie);

        driver.navigate().refresh();
        sleep(2);
    }


}

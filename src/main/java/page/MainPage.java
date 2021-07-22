package page;

import base.DriverHolder;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import waiter.WaitCondition;

public class MainPage {

    private static final By USERNAME = By.cssSelector("input[id='username-field']");

    private static final By PASSWORD = By.cssSelector("input[id='password-field']");

    private static final By OTP_CODE = By.cssSelector("input[id='otp-field']");

    private static final By LOGIN_BUTTON = By.cssSelector("input[id='login-form-submit']");

    public MainPage enterCredential() {
        WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(USERNAME).sendKeys("user");
        waitCondition.waitForVisibilityOfElementLocatedBy(PASSWORD).sendKeys("user");
        waitCondition.waitForVisibilityOfElementLocatedBy(OTP_CODE).sendKeys("1234");

        return this;
    }

    public ProfilePage clickLoginButton() {
        WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(LOGIN_BUTTON).click();

        return new ProfilePage();
    }

    public MainPage checkMainPageTitle() {

        Assertions.assertEquals(DriverHolder.getDriverThread().getTitle(), "Login Page");

        return this;
    }
}

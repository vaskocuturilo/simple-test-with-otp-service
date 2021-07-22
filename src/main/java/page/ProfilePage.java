package page;

import org.openqa.selenium.By;
import waiter.WaitCondition;

public class ProfilePage {

    private static final By LOGOUT_BUTTON = By.cssSelector("a[href='index.html']");

    public MainPage clickLogoutButton() {
        WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(LOGOUT_BUTTON).click();

        return new MainPage();
    }
}

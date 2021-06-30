package page;

import base.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.net.URISyntaxException;

import static api.ServiceHelper.getOneTimePassword;

public class LoginPage extends PageObject {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "username-field")
    @CacheLookup
    private WebElement loginField;

    @FindBy(how = How.ID, using = "password-field")
    @CacheLookup
    private WebElement passwordField;

    @FindBy(how = How.ID, using = "otp-field")
    @CacheLookup
    private WebElement oneTimePasswordField;

    @FindBy(how = How.ID, using = "login-form-submit")
    @CacheLookup
    private WebElement loginButton;

    public void enterCredential() {
        this.loginField.clear();
        this.loginField.sendKeys("user");

        this.passwordField.clear();
        this.passwordField.sendKeys("user");
        try {
            this.oneTimePasswordField.clear();
            this.oneTimePasswordField.sendKeys(getOneTimePassword());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e.getMessage());
        }
        this.loginButton.click();
    }
}

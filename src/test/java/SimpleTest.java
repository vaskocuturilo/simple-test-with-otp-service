
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URISyntaxException;
import java.time.Duration;

import static api.ServiceHelper.getOneTimePassword;

public class SimpleTest {
    WebDriver webDriver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @Test
    public void testSimpleUsingOneTimePassword() throws URISyntaxException {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.navigate().to("https://test-engineer.site/test-room/");
        Assertions.assertEquals(webDriver.getTitle(), "Login Page");

        //Email field
        webDriver.findElement(By.id("username-field")).clear();
        webDriver.findElement(By.id("username-field")).sendKeys("user");

        //Password field
        webDriver.findElement(By.id("password-field")).clear();
        webDriver.findElement(By.id("password-field")).sendKeys("user");

        //One time password field
        webDriver.findElement(By.id("otp-field")).clear();
        webDriver.findElement(By.id("otp-field")).sendKeys(getOneTimePassword());

        //Submit button
        webDriver.findElement(By.id("login-form-submit")).click();

        Assertions.assertEquals(webDriver.getTitle(), "Profile Page");

    }

    @AfterEach
    public void tearDown() {
        webDriver.manage().deleteAllCookies();
        webDriver.quit();
    }
}

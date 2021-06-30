package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseClass {

    private final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private static final int DELAY = 10;

    protected WebDriver driver;

    @BeforeEach
    public void start() {
        if (webDriverThreadLocal.get() != null) {
            driver = webDriverThreadLocal.get();
            return;
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://test-engineer.site/test-room/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DELAY));
        webDriverThreadLocal.set(driver);
    }

    @AfterEach
    public void stop() {
        if (driver != null) {
            driver.close();
        }
    }
}

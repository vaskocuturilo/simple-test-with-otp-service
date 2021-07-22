package base;

import browsers.Chrome;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

import static page.AbstractPages.*;

public class BasePagesRunner {

    private static final int DELAY = 10;

    @BeforeAll
    public static void start() {
        final Chrome chrome = new Chrome();
        final DesiredCapabilities capabilities = new DesiredCapabilities();
        DriverHolder.setDriverThread(chrome.createDriver(capabilities));
        DriverHolder.getDriverThread().manage().timeouts().implicitlyWait(Duration.ofSeconds(DELAY));
        DriverHolder.getDriverThread().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(DELAY));
        DriverHolder.getDriverThread().manage().timeouts().setScriptTimeout(Duration.ofSeconds(DELAY));
        navigateWebBrowser().to("https://test-engineer.site/test-room/");
    }

    @AfterAll
    public static void stop() {
        clearLocalStorage();
        closeWebBrowser();
    }

}

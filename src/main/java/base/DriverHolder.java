package base;

import org.openqa.selenium.WebDriver;

public class DriverHolder {
    /**
     * The value DRIVER_THREAD.
     */
    private static final ThreadLocal<WebDriver> DRIVER_THREAD = new ThreadLocal<>();

    /**
     * The constructor.
     */
    private DriverHolder() {
    }

    /**
     * Gets thread driver.
     *
     * @return the thread driver
     */
    public static WebDriver getDriverThread() {
        return DRIVER_THREAD.get();
    }

    /**
     * Sets thread driver.
     *
     * @param webDriverValue the web driver value
     */
    public static void setDriverThread(final WebDriver webDriverValue) {
        DRIVER_THREAD.set(webDriverValue);
    }

}

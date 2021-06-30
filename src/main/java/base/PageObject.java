package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject extends BaseClass {

    public PageObject(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

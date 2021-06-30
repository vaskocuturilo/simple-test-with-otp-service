import base.BaseClass;
import org.junit.jupiter.api.Test;
import page.LoginPage;

public class SimplePageObjectTest extends BaseClass {
    @Test
    public void testSimplePageObject() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterCredential();
    }
}

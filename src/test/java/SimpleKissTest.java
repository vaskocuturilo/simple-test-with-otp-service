import base.BasePagesRunner;
import org.junit.jupiter.api.Test;
import page.MainPage;

public class SimpleKissTest extends BasePagesRunner {

    @Test()
    public void testSimpleTest() {
        new MainPage()
                .enterCredential()
                .clickLoginButton()
                .clickLogoutButton()
                .checkMainPageTitle();
    }
}

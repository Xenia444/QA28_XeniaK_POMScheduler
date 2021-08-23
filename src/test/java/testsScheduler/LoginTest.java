package testsScheduler;

import config.ConfigScheduler;
import org.testng.annotations.Test;
import pageScheduler.LoginScreen;

public class LoginTest extends ConfigScheduler {
    @Test
    public void login() {
       new LoginScreen(driver).inputEmail("janny@gmail.com");
       new LoginScreen(driver).inputPassword("098Ja6543@!");
       new LoginScreen(driver).confirmLogin();
    }
}

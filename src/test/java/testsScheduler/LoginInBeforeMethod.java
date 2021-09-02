package testsScheduler;

import config.ConfigScheduler;
import dto.AuthDto;
import org.testng.annotations.*;
import pagesScheduler.HomeScreen;
import pagesScheduler.SplashScreen;


public class LoginInBeforeMethod extends ConfigScheduler {

    @BeforeTest
    public void preCondition() {
        new SplashScreen(driver)
                .checkVersion("0.0.3")
                .loginWithDto(AuthDto.builder().email("janny@gmail.com").password("098Ja6543@!").build())
                .skipWizard();
    }

    @Test
    public void test() {
        new HomeScreen(driver).isFabAddPresent();
    }

    @AfterTest
    public void postcondition() {
        new HomeScreen(driver).openMenu().logout();
        logger.info("Logout");
    }
}

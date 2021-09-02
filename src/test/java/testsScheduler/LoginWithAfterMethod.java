package testsScheduler;

import config.ConfigScheduler;
import dto.AuthDto;
import dto.AuthTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pagesScheduler.HomeScreen;
import pagesScheduler.LoginScreen;


public class LoginWithAfterMethod extends ConfigScheduler {

    @Test
    public void loginTest() {
        boolean isFabButtonPresent = new LoginScreen(driver)
                .fillEmail("janny@gmail.com")
                .fillPassword("098Ja6543@!")
                .clickLoginButton()
                .skipWizard()
                .isFabAddPresent();

        Assert.assertTrue(isFabButtonPresent);
        logger.info("Test passed");
    }

    @Test
    public  void  loginWithDto() {
        AuthTest testA = new AuthTest()
                .withEmail("janny@gmail.com")
                .withPassword("098Ja6543@!");
        AuthTest testB = new AuthTest()
                .withEmail("janny@gmail.com");

        AuthDto dto = AuthDto.builder()
                .email("janny@gmail.com")
                .password("098Ja6543@!")
                .build();

        boolean isFabPresent = new LoginScreen(driver)
                .loginWithDto(dto)
                .skipWizard()
                .isFabAddPresent();

        Assert.assertTrue(isFabPresent);
        logger.info("Test passed");
    }

    @AfterMethod
    public void postcondition() {
        new HomeScreen(driver).openMenu().logout();
        logger.info("Logout");
    }


}

package testsScheduler;

import config.ConfigScheduler;
import dto.AuthTest;
import dto.Authdto;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageScheduler.SplashScreen;

public class LoginTest extends ConfigScheduler {


    @Test
    public void loginTest() {
       boolean isFabButtonPresent = new SplashScreen(driver)
               .checkVersion("0.0.3")
               .fillEmail("janny@gmail.com")
               .fillPassword("098Ja6543@!")
               .clickLoginButton()
               .skipWizard()
               .isFabAddPresent();

        Assert.assertTrue(isFabButtonPresent);
    }

    @Test
    public  void  loginWithDto() {
        AuthTest testA = new AuthTest()
                .withEmail("janny@gmail.com")
                .withPassword("098Ja6543@!");
        AuthTest testB = new AuthTest()
                .withEmail("janny@gmail.com");

        Authdto dto = Authdto.builder()
                .email("janny@gmail.com")
                .password("098Ja6543@!")
                .build();

        boolean isFabPresent = new SplashScreen(driver)
                .checkVersion("0.0.3")
                .loginWithDto(dto)
                .skipWizard()
                .isFabAddPresent();

        Assert.assertTrue(isFabPresent);
    }

    @Test
    public void loginNegativeWithDto() {
        Authdto dto = Authdto.builder()
                .email("janny@gmail.com")
                .password("098Ja654321")
                .build();

        boolean isLoginPage = new SplashScreen(driver)
                .checkVersion("0.0.3")
                .loginNegativeWithDto(dto)
                .confirmError()
                .isLoginButtonPresent();

        Assert.assertTrue(isLoginPage);

    }



}

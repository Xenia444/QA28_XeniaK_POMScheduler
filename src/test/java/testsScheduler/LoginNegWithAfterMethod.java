package testsScheduler;

import config.ConfigScheduler;
import dto.AuthDto;
import org.testng.Assert;
import org.testng.annotations.*;
import pagesScheduler.LoginScreen;

public class LoginNegWithAfterMethod extends ConfigScheduler {

    @Test
    public void loginNegativeWithDto() {
        AuthDto dto = AuthDto.builder()
                .email("janny@gmail.com")
                .password("098Ja654321")
                .build();

        boolean isLoginPage = new LoginScreen(driver)
                .loginNegativeWithDto(dto)
                .confirmError()
                .isLoginButtonPresent();

        Assert.assertTrue(isLoginPage);
        logger.info("Test passed");
    }

    @Test
    public void negativeLoginTest() {
        AuthDto dto = AuthDto.builder()
                .email("janny@gmail.com")
                .password("098Ja654321")
                .build();

        String error = new LoginScreen(driver)
                .fillFormLogin(dto)
                .errorLogin()
                .errorMessage();

        Assert.assertEquals(error, "Wrong email or password");
        logger.info("Test passed");

        new LoginScreen(driver).confirmError();
    }

    @AfterMethod
    public void postcondition() {
        new LoginScreen(driver).cleanTheFields();
        logger.info("Cleaned");
    }

}

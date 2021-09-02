package testsScheduler;

import config.ConfigScheduler;
import config.MyDataProvider;

import dto.AuthDto;


import org.testng.annotations.Test;
import pagesScheduler.LoginScreen;

public class LoginDataProvider extends ConfigScheduler {

    @Test(dataProvider = "validLoginData", dataProviderClass = MyDataProvider.class)
    public void loginWithDto(String email, String password) {

        AuthDto dto = AuthDto.builder().email(email).password(password).build();

//        new SplashScreen(driver)
//                .checkVersion("0.0.3")

        new LoginScreen(driver)
                .loginWithDto(dto)
                .skipWizard()
                .openMenu()
                .logout();

        logger.info("Test passed");
    }
}

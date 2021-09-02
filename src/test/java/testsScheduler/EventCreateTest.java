package testsScheduler;

import config.ConfigScheduler;
import dto.AuthDto;
import dto.EventDto;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pagesScheduler.HomeScreen;
import pagesScheduler.LoginScreen;

public class EventCreateTest extends ConfigScheduler {

    @Test
    public void evenCreationTest() {
        boolean isEventCreated = new LoginScreen(driver)
                .loginWithDto(AuthDto.builder().email("janny@gmail.com").password("098Ja6543@!").build())
                .skipWizard()
                .initCreationEvent()
                .fillCreationEditForm("Event", "ABC", 3, 30)
                .confirmCreationEvent().isFabAddPresent();

        Assert.assertTrue(isEventCreated);
        logger.info("Test passed");

    }


    @Test
    public void evenCreationTestWithDto() {
        boolean isEventCreated = new LoginScreen(driver)
                .loginWithDto(AuthDto.builder().email("janny@gmail.com").password("098Ja6543@!").build())
                .skipWizard().initCreationEvent()
                .fillCreationEditForm(EventDto.builder().title("Event").type("DEF").breaks(3).wage(30).build())
                .confirmCreationEvent()
                .isFabAddPresent();

        Assert.assertTrue(isEventCreated);
        logger.info("Test passed");
    }

    @AfterMethod
    public void postcondition() {
        new HomeScreen(driver).openMenu().logout();
        logger.info("logout");
    }

}

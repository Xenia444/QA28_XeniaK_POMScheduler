package testsScheduler;

import config.ConfigScheduler;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesScheduler.SplashScreen;

public class LaunchAppTest extends ConfigScheduler {

    @Test
    public void launchTest() {
        String version = new SplashScreen(driver).getCurrentVersion();
        Assert.assertEquals(version,"0.0.3");
    }

//    @Test
//    public void logoIsPresent() {
//        Assert.assertTrue(new SplashScreen(driver).viewLogo.isDisplayed());
//    }
}

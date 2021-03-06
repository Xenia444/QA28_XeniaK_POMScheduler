package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class ConfigScheduler {
    protected AppiumDriver<MobileElement> driver;
    protected Logger logger = LoggerFactory.getLogger(ConfigScheduler.class);

    @BeforeClass(alwaysRun = true)
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Nexus_5_API_26");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        capabilities.setCapability("appPackage", "com.example.svetlana.scheduler");
        capabilities.setCapability("appActivity", ".presentation.splashScreen.SplashScreenActivity");

        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("app", "/home/ksu/Documents/Applications_Android/v.0.0.3.apk");

        driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("Scheduler app runs on an Android emulator.");
    }

    @BeforeMethod(alwaysRun = true)
    public void startLogger(Method m, Object[] p) {
        logger.info("Start method: " + m.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void endOfLogger(Method m) {
        logger.info("End of method: " + m.getName());
        logger.info("==================================================================");
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}

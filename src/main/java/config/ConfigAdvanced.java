package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ConfigAdvanced {
    protected AppiumDriver<MobileElement> driver;
    protected Logger logger = LoggerFactory.getLogger(ConfigAdvanced.class);

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Nexus_5_API_26");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        capabilities.setCapability("appPackage", "com.h6ah4i.android.example.advrecyclerview");
    //    capabilities.setCapability("appActivity", ".launcher.MainActivity");

        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("app", "/home/ksu/Documents/Applications_Android/AdvancedRecyclerView.apk");

        driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("Advanced Recycler app runs on an Android emulator.");
    }

    @BeforeMethod(alwaysRun = true)
    public void startLogger(Method m, Object[] p) {
        logger.info("Start method: " + m.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void endOfLogger(Method m) {
        logger.info("End of method: " + m.getName());
        logger.info( "==================================================================");
    }

//    @AfterSuite
//    public void tearDown() {
//        driver.quit();
//    }
}

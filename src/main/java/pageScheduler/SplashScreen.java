package pageScheduler;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SplashScreen extends BaseScreen {
    public SplashScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/app_version_res']")
    MobileElement versionTextView;

    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/splash_logo_img']")
    public MobileElement viewLogo;

    public String getCurrentVersion() {
        return versionTextView.getText();
    }

    public LoginScreen checkVersion(String version) {
        shouldHave(versionTextView, version, 15);
        return new LoginScreen(driver);
    }

}

package pageScheduler;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginScreen extends BaseScreen {
    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/log_email_input']")
    MobileElement email;

    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/log_password_input']")
    MobileElement password;

    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/login_btn']")
    MobileElement loginButton;

    public void inputEmail(String emailAddress) {
        email.click();
        email.clear();
        email.sendKeys(emailAddress);
    }

    public void inputPassword(String passWord) {
        password.click();
        password.clear();
        password.sendKeys(passWord);
    }

    public void confirmLogin() {
        driver.navigate().back();
        loginButton.click();
    }
}

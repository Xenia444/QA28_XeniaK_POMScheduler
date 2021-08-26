package pageScheduler;

import dto.Authdto;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginScreen extends BaseScreen {
    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/log_email_input']")
    MobileElement emailEditText;

    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/log_password_input']")
    MobileElement passwordEditText;

    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/login_btn']")
    MobileElement loginButton;

    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/alertTitle']")
    MobileElement errorAlert;

    @FindBy(how = How.XPATH, using = "//*[@resource-id='android:id/button1']")
    MobileElement errorOkButton;

    public LoginScreen fillEmail(String email) {
        type(emailEditText, email);
        return this;
    }

    public LoginScreen fillPassword(String password) {
        type(passwordEditText, password);
        return this;
    }

    public WizardScreen clickLoginButton() {
        hideKeyboard();
        loginButton.click();
        return new WizardScreen(driver);
    }

    public WizardScreen loginWithDto(Authdto auth) {
        type(emailEditText, auth.getEmail());
        type(passwordEditText, auth.getPassword());
        hideKeyboard();
        loginButton.click();
        return new WizardScreen(driver);
    }

    public LoginScreen loginNegativeWithDto(Authdto auth) {
        type(emailEditText, auth.getEmail());
        type(passwordEditText, auth.getPassword());
        hideKeyboard();
        loginButton.click();
        return this;
    }

    public LoginScreen confirmError() {
        if(isDisplayedWithoutException(errorAlert)) {
            errorOkButton.click();
        }
        return this;
    }

    public boolean isLoginButtonPresent() {
        should(loginButton, 10);
        return true;
    }
}

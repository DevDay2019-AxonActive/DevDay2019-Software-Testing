package pages.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


public class AndroidLoginScreen {
    AppiumDriver<MobileElement> driver;
    @AndroidFindBy(id="com.aavn.devday.booklibrary:id/btn_login")
    AndroidElement btnLogin;

    @AndroidFindBy(id="com.aavn.devday.booklibrary:id/edt_username")
    AndroidElement txtUser;

    @AndroidFindBy(id="com.aavn.devday.booklibrary:id/edt_password")
    AndroidElement txtPass;

    public AndroidLoginScreen(AppiumDriver<MobileElement> driver)
    {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void login_with(String username, String password) {
        txtUser.sendKeys(username);
        txtPass.sendKeys(password);
        btnLogin.click();
    }
}

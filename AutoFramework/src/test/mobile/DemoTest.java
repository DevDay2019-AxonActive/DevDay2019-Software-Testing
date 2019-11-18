package test.mobile;

import pages.mobile.AndroidHomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.mobile.AndroidLoginScreen;

public class DemoTest extends AbstractMobileBaseTest {

    @Test()
    public void test_login_successfully()
    {
        //Create Login Screen object
        objLogin = new AndroidLoginScreen(driver);

        //login to application
        objLogin.login_with("", "");

        //Create Home Screen object
        objHome = new AndroidHomeScreen(driver);

        //Create Home Screen is reach
        Assert.assertTrue(objHome.getSearch().isDisplayed());
    }
}
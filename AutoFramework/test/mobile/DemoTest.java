package mobile;

import pages.mobile.AndroidHomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.mobile.AndroidLoginScreen;

public class DemoTest extends AbstractMobileBaseTest {

    @Test()
    public void test_login_successfully() throws InterruptedException
    {
        //Create Login Screen object
        objLogin = new AndroidLoginScreen(driver);

        //login to application
        objLogin.login_with("simple", "simple");

        //Create Home Screen object
        objHome = new AndroidHomeScreen(driver);
        Thread.sleep(10000);

        //Create Home Screen is reach
        Assert.assertTrue(objHome.getSearch().isDisplayed());
    }
}
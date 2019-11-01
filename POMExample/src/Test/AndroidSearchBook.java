package Test;

import PageFactory.AndroidHomeScreen;
import org.testng.annotations.Test;
import PageFactory.AndroidLoginScreen;
import Utilities.VerifyUtil;

public class AndroidSearchBook extends AbstractMobileBaseTest {

    @Test()
    public void test_Home_Page_Appear_Correct()
    {
        //Create Login Page object
        objLogin = new AndroidLoginScreen(driver);

        //login to application
        objLogin.clickLogin();

        objHome = new AndroidHomeScreen(driver);

        VerifyUtil.verifyElementPresent(objHome.getSearch());
    }
}
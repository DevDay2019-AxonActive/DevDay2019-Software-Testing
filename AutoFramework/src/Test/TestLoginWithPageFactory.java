package Test;

import org.testng.annotations.Test;
import PageFactory.HomePage;
import PageFactory.LoginPage;
import Utilities.VerifyUtil;

public class TestLoginWithPageFactory extends AbstractBaseTest
{
	/**
	 * This test go to http://demo.guru99.com/V4/
	 * Verify login page title as guru99 bank
	 * Login to application
	 * Verify the home page using Dashboard message
	 */
	@Test(priority=1)
	public void test_Home_Page_Appear_Correct()
	{
    	//Create Login Page object
    	objLogin = new LoginPage(driver);

    	//login to application
    	objLogin.loginToGuru99("mgr123", "mgr!23");

    	// go the next page
    	objHomePage = new HomePage(driver);

    	//Verify home page
    	VerifyUtil.verifyElementPresent(objHomePage.getHomePageDashboardUserName());
	}
}

package web;

import org.testng.annotations.Test;

import pages.web.HomePage;
import pages.web.LoginPage;
import pages.web.SearchResultPage;
import utilities.OperatingSystemUtil;
import utilities.VerifyUtil;

public class DemoTest extends AbstractBaseTest
{
    @Test(priority=1)
    public void test_search_book_successfully() throws InterruptedException
    {
        objHomePage = new HomePage(driver);
        objSearchResultPage = new SearchResultPage(driver);
        objLoginPage = new LoginPage(driver);

        objLoginPage.setUserName("simple");
        objLoginPage.setPassword("simple");
        objLoginPage.clickLogin();
        Thread.sleep(5000);

        // Input keyword to search
        objHomePage.setTxtSearch("Rails AntiPatterns");
        OperatingSystemUtil.pressEnterKeyOnKeyBoard();
        Thread.sleep(10000);

        // Verify result is shown
       VerifyUtil.verifyElementDisplay(objSearchResultPage.getSearchResult());
    }

}
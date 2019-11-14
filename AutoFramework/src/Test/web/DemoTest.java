package Test.web;

import org.testng.annotations.Test;

import PageFactory.web.HomePage;
import PageFactory.web.SearchResultPage;
import Utilities.OperatingSystemUtil;
import Utilities.VerifyUtil;

public class DemoTest extends AbstractBaseTest
{
    @Test(priority=1)
    public void search_function() throws InterruptedException
    {
        objHomePage = new HomePage(driver);
        objSearchResultPage = new SearchResultPage(driver);
        // Input keyword to search
        objHomePage.setTxtSearch("Rails AntiPatterns");

        OperatingSystemUtil.pressEnterKeyOnKeyBoard();
        Thread.sleep(10000);

        // Verify result is shown
       VerifyUtil.verifyElementDisplay(objSearchResultPage.getSearchResult());
    }

}
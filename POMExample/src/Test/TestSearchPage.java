/*
 * TestSearchPage.java
 *
 * Copyright by CRIF AG
 * Zürich
 * All rights reserved.
 */
package Test;

import org.testng.annotations.Test;

import PageFactory.HomePage;
import Utilities.OperatingSystemUtil;
import Utilities.VerifyUtil;

/**
 *
 *
 * @author vnalinh
 * @version $Revision:  $
 */
public class TestSearchPage extends AbstractBaseTest
{
    /**
     * Method description
     *
     * @throws InterruptedException
     */
    @Test(priority=1)
    public void SearchFunction() throws InterruptedException
    {
        objHomePage = new HomePage(driver);
        // Input keyword to search
        objHomePage.setTxtSearch("Rails AntiPatterns");



        OperatingSystemUtil.pressEnterKeyOnKeyBoard();
        Thread.sleep(50000);

        // Verify result contains book that has name contain "Rails AntiPatterns"
        int numberOfBooks = objSearchResultPage.getNumberOfResultNameContainKeyword("Rails AntiPatterns");
        VerifyUtil.verifyEqual(numberOfBooks, 2);
    }

}


/*
 * Changes:
 * $Log: $
 */
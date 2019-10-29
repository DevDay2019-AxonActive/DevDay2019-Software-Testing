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

/**
 *
 *
 * @author vnalinh
 * @version $Revision:  $
 */
public class TestSearchPage extends AbstractBaseTest
{
    @Test(priority=1)
    public void SearchFunction()
    {
        objHomePage = new HomePage(driver);
        // Input keyword to search
        objHomePage.setTxtSearch("Dac Nhan Tam");
        OperatingSystemUtil.pressEnterKeyOnKeyBoard();

        // Verify result is returned correctly

    }

}


/*
 * Changes:
 * $Log: $
 */
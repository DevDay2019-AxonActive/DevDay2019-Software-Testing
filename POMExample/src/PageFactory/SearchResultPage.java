/*
 * SearchResult.java
 *
 * Copyright by CRIF AG
 * Zürich
 * All rights reserved.
 */
package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.OperatingSystemUtil;

/**
 *
 *
 * @author vnalinh
 * @version $Revision:  $
 */
public class SearchResultPage
{
    /**
     * All WebElements are identified by @FindBy annotation
     */
    WebDriver driver;
    @FindBy(css="div[class='ng-star-inserted']")
    WebElement divSearchResult;



    /**
     * Method description
     *
     * @return divSearchResult
     */
    public WebElement getSearchResult()
    {
        return divSearchResult;
    }

    /**
     * Method description
     *
     * @param strKeyword
     * @return numberOfRecord
     */
    public int getNumberOfResultNameContainKeyword(String strKeyword)
    {
        int numberOfRecord = 0;
        numberOfRecord = OperatingSystemUtil.findElements(getSearchResult(), "xpath",
                                                          "//div[@class='ng-star-inserted']//div[@class='col summary d-flex flex-column style-scope div']/h1/strong[contains(text(),'" + strKeyword + "')]").size();

        return numberOfRecord;
    }
}


/*
 * Changes:
 * $Log: $
 */
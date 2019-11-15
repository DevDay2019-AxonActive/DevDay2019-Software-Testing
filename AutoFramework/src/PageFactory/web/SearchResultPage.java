package PageFactory.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchResultPage
{

    /**
     * All WebElements are identified by @FindBy annotation
     */
    WebDriver driver;
    @FindBy(css="div[class='ng-star-inserted']")
    WebElement divSearchResult;

    /**
     * Constructor
     *
     * @param driver
     */
    public SearchResultPage(WebDriver driver)
    {
        this.driver = driver;
        //This initElements method will create  all WebElements
        PageFactory.initElements(driver, this);
    }

    /**
     * Method description
     *
     * @return divSearchResult
     */
    public WebElement getSearchResult()
    {
        return divSearchResult;
    }
}

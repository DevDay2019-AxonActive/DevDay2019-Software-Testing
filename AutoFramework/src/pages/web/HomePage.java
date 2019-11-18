package pages.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{

	WebDriver driver;

	@FindBy(xpath="//table//tr[@class='heading3']")
	WebElement headingUsername;

	@FindBy(css="input[id='mat-input-0']")
    WebElement txtSearch;

	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}

    public WebElement getTxtSearch()
    {
        return txtSearch;
    }

    public void setTxtSearch(String strSearchKey)
    {
        txtSearch.sendKeys(strSearchKey);
    }
}

package PageFactory.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage
{
	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	WebDriver driver;
	@FindBy(name="uid")
	WebElement txtUsername;

	@FindBy(name="password")
	WebElement txtPassword;

	@FindBy(name="btnLogin")
	WebElement btnLogin;

	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	//Set user name in textbox
	public void setUserName(String strUserName)
	{
		txtUsername.sendKeys(strUserName);
	}

	//Set password in password textbox
	public void setPassword(String strPassword)
	{
	    txtPassword.sendKeys(strPassword);
	}

	//Click on login button
	public void clickLogin()
	{
	    btnLogin.click();
	}

	/**
	 * This POM method will be exposed in test case to login in the application
	 * @param strUserName: input username
	 * @param strPasword: input password
	 */
	public void loginToGuru99(String strUserName,String strPasword)
	{
		//Fill user name
		this.setUserName(strUserName);
		//Fill password
		this.setPassword(strPasword);
		//Click Login button
		this.clickLogin();
	}
}

package web;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.web.HomePage;
import pages.web.LoginPage;
import pages.web.SearchResultPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractBaseTest
{
    static WebDriver driver;
    HomePage objHomePage;
    SearchResultPage objSearchResultPage;
    LoginPage objLoginPage;
    static StringBuffer verificationErrors;

    @BeforeMethod
    public void setUp()
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://localhost:4200/");
        verificationErrors = new StringBuffer();
        verificationErrors.setLength(0);
    }

    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }

    public static WebDriver getDriver()
    {
        return driver;
    }

    public static StringBuffer getVerificationErrors()
    {
        return verificationErrors;
    }
}

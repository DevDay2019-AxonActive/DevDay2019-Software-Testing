package Test.web;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import PageFactory.web.HomePage;
import PageFactory.web.LoginPage;
import PageFactory.web.SearchResultPage;

public class AbstractBaseTest
{
    static WebDriver driver;
    LoginPage objLogin;
    HomePage objHomePage;
    SearchResultPage objSearchResultPage;
    static StringBuffer verificationErrors;

    @BeforeMethod
    public void setUp()
    {
        String projectDir = System.getProperty("user.dir");
        System.setProperty("webdriver.gecko.driver", projectDir + "/conf/GeckoDriverServer/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://85.214.44.228:4200/");
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

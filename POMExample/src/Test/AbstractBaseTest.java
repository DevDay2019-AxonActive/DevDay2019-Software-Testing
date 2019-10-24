package Test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import PageFactory.HomePage;
import PageFactory.LoginPage;

public class AbstractBaseTest
{
    static WebDriver driver;
    LoginPage objLogin;
    HomePage objHomePage;
    static StringBuffer verificationErrors;

    @BeforeMethod
    public void setUp()
    {
        String projectDir = System.getProperty("user.dir");
        System.setProperty("webdriver.gecko.driver", projectDir + "/conf/GeckoDriverServer/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/V4/");
        verificationErrors = new StringBuffer();
        verificationErrors.setLength(0);
    }

    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }

    /**
     * Gets the driver
     *
     * @return Returns the driver
     */
    public static WebDriver getDriver()
    {
        return driver;
    }

    /**
     * Gets the verificationErrors
     *
     * @return Returns the driver
     */
    public static StringBuffer getVerificationErrors()
    {
        return verificationErrors;
    }
}
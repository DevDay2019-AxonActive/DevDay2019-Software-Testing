package Test;

import PageFactory.AndroidLoginScreen;
import PageFactory.AndroidHomeScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class AbstractMobileBaseTest {
    static AppiumDriver<MobileElement> driver;
    AndroidLoginScreen objLogin;
    AndroidHomeScreen objHome;
    static StringBuffer verificationErrors;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException {
        // Prepare Appium session
        DesiredCapabilities capabilities = DesiredCapabilities.android();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "xxxx");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "xxxxx");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.APP, "apk path");
        // Initialize driver
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

        verificationErrors = new StringBuffer();
        verificationErrors.setLength(0);
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

    /**
     * Gets the driver
     *
     * @return Returns the driver
     */
    public static AppiumDriver<MobileElement> getDriver()
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

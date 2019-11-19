package mobile;

import pages.mobile.AndroidLoginScreen;
import pages.mobile.AndroidHomeScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public abstract class AbstractMobileBaseTest {
    static AppiumDriver<MobileElement> driver;
    AndroidLoginScreen objLogin;
    AndroidHomeScreen objHome;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException {

        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("conf/appium.properties");
            // load a properties file
            prop.load(input);

            // Prepare Appium session
            DesiredCapabilities capabilities = DesiredCapabilities.android();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.get("PLATFORM_VERSION"));
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.get("DEVICE_NAME"));
            capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            capabilities.setCapability(MobileCapabilityType.APP, prop.get("APP"));
            // Initialize driver
            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

    public static AppiumDriver<MobileElement> getDriver()
    {
        return driver;
    }

}

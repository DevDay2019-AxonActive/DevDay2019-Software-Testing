package Utilities;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Test.web.AbstractBaseTest;

public class VerifyUtil extends AbstractBaseTest
{

    public static void verifyElementDisplay (WebElement element)
    {
        try
        {
            Assert.assertTrue(element.isDisplayed());
        }
        catch (AssertionError ae)
        {
            getVerificationErrors().append(ae);
        }

    }
}

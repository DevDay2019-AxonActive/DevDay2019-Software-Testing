package Utilities;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Test.AbstractBaseTest;

public class VerifyUtil extends AbstractBaseTest
{

    /**
     * Method description
     *
     * @param element
     * @return boolean isDisplayed
     */
    public static boolean isElementDisplayed(WebElement element)
    {
        return element.isDisplayed();
    }

    /**
     * Method description
     *
     * @param element
     */
    public static void verifyElementPresent (WebElement element)
    {
        try
        {
            Assert.assertTrue(isElementDisplayed(element));
        }
        catch (AssertionError ae)
        {
            getVerificationErrors().append(ae);
        }

    }
    public static boolean verifyEqual(Object objectExpected, Object objectDetected)
    {
        boolean testResult = false;
        try
        {
            Assert.assertEquals(objectDetected, objectExpected, objectExpected + " not equals to " + objectDetected);
            testResult = true;
        }
        catch (AssertionError e)
        {
            getVerificationErrors().append(e);
        }
        System.out.println(objectExpected+ " is equal to " + objectDetected);
        return testResult;
    }
}

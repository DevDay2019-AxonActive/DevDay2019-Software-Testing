package Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Test.web.AbstractBaseTest;

public class OperatingSystemUtil extends AbstractBaseTest
{
    public static void pressEnterKeyOnKeyBoard()
    {
        try
        {
            Robot robot = new Robot();
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(1000);
        }
        catch (AWTException awte)
        {
            getVerificationErrors().append(awte);
        }
    }
    public static List<WebElement> findElements(WebElement webElement, String bySelector, String strValue)
    {
        List<WebElement> listSubElements = new ArrayList<WebElement>();
        String strCookedValue = "." + strValue;
        try
        {
            if ("tagName".equalsIgnoreCase(bySelector))
            {
                listSubElements = webElement.findElements(By.tagName(strValue));
            }
            else if ("css".equalsIgnoreCase(bySelector))
            {
                listSubElements = webElement.findElements(By.cssSelector(strValue));
            }
            else if ("xpath".equalsIgnoreCase(bySelector))
            {
                listSubElements = webElement.findElements(By.xpath(strCookedValue));
            }
        }
        catch (NoSuchElementException nse)
        {
            getVerificationErrors().append(nse);
        }
        catch (NullPointerException npe)
        {
            getVerificationErrors().append(npe);
        }
        return listSubElements;
    }

    public static void waitForElement(WebElement element)
    {
        if (element == null)
        {
            NoSuchElementException nse = new NoSuchElementException("Cannot find webElement. Throw NoSuchElementException.");
            throw nse;
        }
        try
        {
            long startTime = System.currentTimeMillis();
            int glbTimeOut = 30;
            WebDriverWait wait = new WebDriverWait(getDriver(), glbTimeOut);
            wait.until(ExpectedConditions.visibilityOf(element));
            long endTime = System.currentTimeMillis();
            long elapsedTime = TimeUnit.MILLISECONDS.toSeconds(endTime - startTime);
        }
        catch (StaleElementReferenceException sele)
        {
            getVerificationErrors().append(sele);
        }
        catch (InvalidElementStateException iese)
        {
            getVerificationErrors().append(iese);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }
}
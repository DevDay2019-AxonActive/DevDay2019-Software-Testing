package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import web.AbstractBaseTest;

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
}
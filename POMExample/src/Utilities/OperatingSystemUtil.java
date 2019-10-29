/*
 * OperatingSystemUtil.java
 *
 * Copyright by CRIF AG
 * Zürich
 * All rights reserved.
 */
package Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import Test.AbstractBaseTest;

/**
 *
 *
 * @author vnalinh
 * @version $Revision:  $
 */
public class OperatingSystemUtil extends AbstractBaseTest
{
    /**
     * pressEnterKeyOnKeyBoard
     *
     */
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


/*
 * Changes:
 * $Log: $
 */
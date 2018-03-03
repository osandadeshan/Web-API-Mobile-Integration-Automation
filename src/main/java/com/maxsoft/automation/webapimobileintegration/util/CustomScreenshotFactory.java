package com.maxsoft.automation.webapimobileintegration.util;

import com.thoughtworks.gauge.screenshot.ICustomScreenshotGrabber;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


/**
 * Created by Osanda on 03/02/2018.
 */


public class CustomScreenshotFactory implements ICustomScreenshotGrabber {

    // Return a screenshot byte array
    public byte[] takeScreenshot() {
        try {
            return ((TakesScreenshot) AndroidDriverSetup.androidDriver).getScreenshotAs(OutputType.BYTES);
        } catch (Exception ex) {
            return ((TakesScreenshot) WebDriverSetup.webDriver).getScreenshotAs( OutputType.BYTES );
        }
    }


}

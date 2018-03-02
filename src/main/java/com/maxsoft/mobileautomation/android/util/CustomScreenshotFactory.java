package com.maxsoft.mobileautomation.android.util;

import com.thoughtworks.gauge.screenshot.ICustomScreenshotGrabber;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static com.maxsoft.mobileautomation.android.util.AndroidDriverSetup.androidDriver;
import static com.maxsoft.mobileautomation.android.util.WebDriverSetup.webDriver;


/**
 * Created by Osanda on 5/25/2017.
 */


public class CustomScreenshotFactory implements ICustomScreenshotGrabber {

    // Return a screenshot byte array
    public byte[] takeScreenshot() {
        try {
            return ((TakesScreenshot) androidDriver).getScreenshotAs(OutputType.BYTES);
        } catch (Exception ex) {
            return ((TakesScreenshot) webDriver).getScreenshotAs( OutputType.BYTES );
        }
    }


}

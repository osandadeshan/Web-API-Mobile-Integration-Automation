package com.maxsoft.automation.webapimobileintegration.pages.android;

import com.maxsoft.automation.webapimobileintegration.common.AndroidAppBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;
import static com.maxsoft.automation.webapimobileintegration.util.AndroidDriverSetup.androidDriver;


/**
 * Created by Osanda on 03/02/2018.
 */


public class BasePage extends AndroidAppBase {

    private WebElement TOOL_BAR;

    public BasePage() {
        PageFactory.initElements(androidDriver, this);
    }

    public void pageTitleEquals(String pageTitle) throws IOException {
        TOOL_BAR = androidDriver.findElement(By.id("com.pearsoned.smartflashcards:id/toolbar"));
        isElementAccessibilityIdTextEquals(TOOL_BAR, pageTitle);
    }


}

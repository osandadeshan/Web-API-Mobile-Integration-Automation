package com.maxsoft.automation.webapimobileintegration.common;

import com.maxsoft.automation.webapimobileintegration.util.WebDriverSetup;
import com.thoughtworks.gauge.Step;
import org.testng.Assert;
import java.io.IOException;


/**
 * Created by Osanda on 03/02/2018.
 */


public class WebAppStepDefinitions {

    private WebAppBase webAppBaseObj = new WebAppBase();

    @Step("Launch the web application")
    public void openWebApp() throws IOException {
        WebDriverSetup.setupDriver();
    }

    @Step("Web page title is <pageTitle>")
    public void pageTitleEquals(String pageTitle){
        Assert.assertEquals(webAppBaseObj.getPageTitle(), pageTitle);
    }

    @Step("Quit from the web application")
    public void quitWebApp() {
        WebDriverSetup.tearDown();
    }


}

package com.maxsoft.automation.webapimobileintegration.util;

import com.maxsoft.automation.webapimobileintegration.common.CommonBase;
import com.maxsoft.automation.webapimobileintegration.common.WebAppBase;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.io.IOException;


/**
 * Created by Osanda on 03/02/2018.
 */


public class WebDriverSetup {

    private static final String CHROME = "chrome";
    private static final String IE = "ie";
    private static final String FIREFOX = "firefox";
    private static final String DEFAULT = CHROME;
    private static final String CURRENT_DIRECTORY = System.getProperty("user.dir");
    private static final String GECKO_DRIVER_PROPERTY_NAME = System.getenv("gecko_driver_property_name");
    private static final String GECKO_DRIVER_PATH = System.getenv("gecko_driver_path");
    private static String BROWSER = System.getenv("browser");
    public static WebDriver webDriver;

    private static CommonBase commonBaseObj = new CommonBase();
    private static WebAppBase webAppBaseObj = new WebAppBase();

    public static void setupDriver() throws IOException {
        setup();
    }

    public static void setup() {
        // Uses chrome webDriver by default
        if (BROWSER == null) {
            BROWSER = DEFAULT;
        }
        if (BROWSER.toLowerCase().equals(CHROME)) {
            ChromeDriverManager.getInstance().setup();
            webDriver = new ChromeDriver();
        }
        else if (BROWSER.toLowerCase().equals(IE)) {
            InternetExplorerDriverManager.getInstance().setup();
            webDriver = new InternetExplorerDriver();
        }
        else {
            FirefoxDriverManager.getInstance().setup();
            webDriver = new FirefoxDriver();
        }
        webDriver.manage().window().maximize();
        webAppBaseObj.isBrowserAlive();
    }

    public static void tearDown() {
        Boolean hasQuit;
        webDriver.quit();
        hasQuit = webDriver.toString().contains("(null)");
        if (hasQuit == Boolean.TRUE){
            commonBaseObj.printText(BROWSER + " web browser has stopped successfully");
        } else {
            commonBaseObj.printText("An error occurred while stopping the "+BROWSER+" web browser");
        }
    }


}

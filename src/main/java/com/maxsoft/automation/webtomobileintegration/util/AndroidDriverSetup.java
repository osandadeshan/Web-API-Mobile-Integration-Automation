package com.maxsoft.automation.webtomobileintegration.util;

import com.maxsoft.automation.webtomobileintegration.common.Base;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.io.IOException;
import java.net.URL;


/**
 * Created by Osanda on 4/26/2017.
 */


public class AndroidDriverSetup {

    public static final String APPIUM_HOST = System.getenv("appium_host");
    public static final String APPIUM_PORT = System.getenv("appium_port");
    public static final String APPIUM_VERSION = System.getenv("appium_version");
    public static final String AUTOMATION_NAME = System.getenv("automation_name");
    public static final String PLATFORM = System.getenv("testing_platform");
    public static final String PROJECT_ROOT = System.getProperty("user.dir");
    private static final String APP_NAME = System.getenv("app_name");
    public static final String SAUCE_LABS_USERNAME = System.getenv("sauce_labs_username");
    public static final String SAUCE_LABS_ACCESS_KEY = System.getenv("sauce_labs_access_key");
    private static final String SAUCE_LABS_HOST = System.getenv("sauce_labs_host");
    private static final String SAUCE_LABS_CONNECTION_STRING = "http://" + SAUCE_LABS_USERNAME + ":" + SAUCE_LABS_ACCESS_KEY + "@" + SAUCE_LABS_HOST;
    private static final String APP_HOSTED_URL = System.getenv("app_hosted_url");
    public static final String APPIUM_SERVER_URL = "http://" + APPIUM_HOST + ":" + APPIUM_PORT + "/wd/hub";
    // Android properties
    public static AndroidDriver androidDriver;
    public static final String ANDROID = "Android";
    public static final String ANDROID_APP_PACKAGE = System.getenv("android_app_package");
    private static final String ANDROID_APP_ACTIVITY = System.getenv("android_app_activity");
    private static final String ANDROID_APK_PATH = System.getenv("android_app_path");
    public static final String ANDROID_VERSION = System.getenv("android_version");
    public static final String ANDROID_DEVICE_NAME = System.getenv("android_device_name");

    private static Base baseObj = new Base();

        public static void setupDriver() throws IOException {
            prepareAndroidForAppium();
        }

        public static AndroidDriver prepareAndroidForAppium() throws IOException {
                // Set APK file path
                File app = new File(PROJECT_ROOT + ANDROID_APK_PATH);
                baseObj.printText("Installing APK file from the path " + PROJECT_ROOT + ANDROID_APK_PATH);
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                        // Mandatory capabilities
                        capabilities.setCapability("deviceName", ANDROID_DEVICE_NAME);
                        capabilities.setCapability("platformName", ANDROID);
                        // Install APK file from the above path
                        try {
                            capabilities.setCapability("app", app.getAbsolutePath());
                            baseObj.printText("Successfully installed " + APP_NAME + " in the device!");
                        } catch (Exception ex) {
                            baseObj.printText("Installing " + APP_NAME + " failed!\n" + ex.getMessage());
                        }
                        // Set Android version desired capability. Set your mobile device's OS version.
                        capabilities.setCapability(CapabilityType.VERSION, ANDROID_VERSION);
                        // Set Android appPackage desired capability.
                        capabilities.setCapability("appPackage", ANDROID_APP_PACKAGE);
                        // Set Android appActivity desired capability.
                        capabilities.setCapability("appActivity", ANDROID_APP_ACTIVITY);

                        androidDriver =  new AndroidDriver(new URL(APPIUM_SERVER_URL), capabilities);
            return androidDriver;
        }

        public static void tearDown() {
            Boolean hasQuit;
                androidDriver.quit();
                hasQuit = androidDriver.toString().contains("(null)");
                if (hasQuit == Boolean.TRUE){
                    baseObj.printText("Android Driver has stopped successfully!");
                } else {
                    System.out.println(hasQuit);
                    baseObj.printText("An error occurred while stopping the Android Driver!");
                }
        }


}

package com.maxsoft.automation.webapimobileintegration.common;

import com.maxsoft.automation.webapimobileintegration.pages.android.BasePage;
import com.maxsoft.automation.webapimobileintegration.util.AndroidDriverSetup;
import com.maxsoft.automation.webapimobileintegration.util.ToastMessage;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.io.IOException;
import java.util.List;


/**
 * Created by Osanda on 03/02/2018.
 */


public class AndroidAppStepDefinitions {

    private AndroidAppBase androidAppBaseObj = new AndroidAppBase();
    private BasePage basePageObj = new BasePage();

    @Step("Testing mobile platform information")
    public void platformInfo(){
        Gauge.writeMessage("Targeted Platform: Android");
        Gauge.writeMessage("Targeted Android Version: v" + AndroidDriverSetup.ANDROID_VERSION);
        Gauge.writeMessage("Targeted Android Device: " + AndroidDriverSetup.ANDROID_DEVICE_NAME);
        Gauge.writeMessage("Targeted Android App Package Name: " + AndroidDriverSetup.ANDROID_APP_PACKAGE);
        Gauge.writeMessage("Targeted Appium Host: " + AndroidDriverSetup.APPIUM_HOST);
        Gauge.writeMessage("Targeted Appium Port: " + AndroidDriverSetup.APPIUM_PORT);
    }

    @Step("Launch the mobile application")
    public void openMobileApp() throws IOException {
        AndroidDriverSetup.setupDriver();
    }

    @Step("Verify that the toast message is <toastMessage>")
    public void verifyToastMessage(String toastMessage) throws Exception {
        //Assert.assertTrue(ToastMessage.getToastMessage().contains(toastMessage), "Invalid Toast Message");
        Assert.assertEquals(ToastMessage.getToastMessageContent(), toastMessage, "Invalid toast message!");
    }

    @Step("Page title is <pageTitle>")
    public void pageTitleEquals(String pageTitle) throws IOException {
        basePageObj.pageTitleEquals(pageTitle);
    }

    @Step("Swipe the device screen horizontally right to left")
    public void swipeRightToLeftHorizontally() throws InterruptedException {
        androidAppBaseObj.swipeRightToLeftHorizontally();
    }

    @Step("Swipe the device screen horizontally left to right")
    public void swipeLeftToRightHorizontally() throws InterruptedException {
        androidAppBaseObj.swipeLeftToRightHorizontally();
    }

    @Step("Swipe the device screen vertically top to bottom")
    public void swipeTopToBottomVertically() throws InterruptedException {
        androidAppBaseObj.swipeTopToBottomVertically();
    }

    @Step("Swipe the device screen vertically bottom to top")
    public void swipeBottomToTopVertically() throws InterruptedException {
        androidAppBaseObj.swipeBottomToTopVertically();
    }

    @Step("Scroll down to the bottom of the screen")
    public void scrollDownToBottom() throws InterruptedException {
        androidAppBaseObj.scrollDown();
    }

    @Step("Scroll to the text of <text>")
    public void scrollTo(String text) throws InterruptedException {
        androidAppBaseObj.scrollTo(text);
    }

    @Step("Navigate back from the device")
    public void navigateBackFromDevice() throws InterruptedException {
        androidAppBaseObj.navigateBackFromDevice();
    }

    @Step("Verify the webview contains <text>")
    public void isWebViewTextEquals(String text) throws InterruptedException {
        androidAppBaseObj.isWebViewTextEquals(text);
    }

    @Step("Verify the webview contains the following text <table>")
    public void isWebViewTextEquals(Table table) throws InterruptedException {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            androidAppBaseObj.isWebViewTextEquals(row.getCell(columnNames.get(0)));
        }
    }

    @Step("Tap on <text>")
    public void tapOnVisibleText(String text){
        androidAppBaseObj.scrollAndTap(text);
    }

    @Step("Press Enter button on the Keyboard")
    public void pressKeyboardEnter() {
        androidAppBaseObj.pressKeyboardEnter();
    }

    @Step("Hide keyboard")
    public void hideKeyboard() {
        androidAppBaseObj.hideKeyboard();
    }

    @Step("Show keyboard")
    public void showKeyboard() {
        androidAppBaseObj.hideKeyboard();
    }

    @Step("Quit from the mobile application")
    public void quitMobileApp() {
        AndroidDriverSetup.tearDown();
    }


}

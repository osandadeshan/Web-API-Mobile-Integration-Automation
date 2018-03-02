package com.maxsoft.automation.webtomobileintegration.common;

import com.maxsoft.automation.webtomobileintegration.util.AndroidDriverSetup;
import com.maxsoft.automation.webtomobileintegration.util.WebDriverSetup;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.maxsoft.automation.webtomobileintegration.util.ToastMessage;
import java.io.IOException;
import java.util.List;


/**
 * Created by Osanda on 4/29/2017.
 */


public class CommonStepDefinitions {

    @FindBy(id = "com.pearsoned.smartflashcards:id/toolbar")
    private WebElement TOOL_BAR;

    private AndroidBase androidBaseObj = new AndroidBase();
    private Base baseObj = new Base();

    @Step("Testing platform information")
    public void platformInfo(){
        Gauge.writeMessage("Targeted Platform: Android");
        Gauge.writeMessage("Targeted Android Version: v" + AndroidDriverSetup.ANDROID_VERSION);
        Gauge.writeMessage("Targeted Android Device: " + AndroidDriverSetup.ANDROID_DEVICE_NAME);
        Gauge.writeMessage("Targeted Android App Package Name: " + AndroidDriverSetup.ANDROID_APP_PACKAGE);
        Gauge.writeMessage("Targeted Appium Host: " + AndroidDriverSetup.APPIUM_HOST);
        Gauge.writeMessage("Targeted Appium Port: " + AndroidDriverSetup.APPIUM_PORT);
    }

    // Use this method to save strings in data store
    @Step("Save the strings inside data stores <table>")
    public void saveToDataStore(Table table){
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            baseObj.saveToDataStore(row.getCell(columnNames.get(0)),row.getCell(columnNames.get(1)), row.getCell(columnNames.get(2)));
        }
    }

    // Use this method to read strings from data store
    @Step("Read the strings from data stores <table>")
    public void readValueFromDataStore(Table table){
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            baseObj.readFromDataStore(row.getCell(columnNames.get(0)),row.getCell(columnNames.get(1)));
        }
    }

    @Step("Launch the mobile application")
    public void openMobileApp() throws IOException {
        AndroidDriverSetup.setupDriver();
    }

    @Step("Launch the web application")
    public void openWebApp() throws IOException {
        WebDriverSetup.setupDriver();
    }

    @Step("Verify that the toast message is <toastMessage>")
    public void verifyToastMessage(String toastMessage) throws Exception {
        //Assert.assertTrue(ToastMessage.getToastMessage().contains(toastMessage), "Invalid Toast Message");
        Assert.assertEquals(ToastMessage.getToastMessageContent(), toastMessage, "Invalid toast message!");
    }

    @Step("Wait <seconds> seconds")
    public void wait(int seconds) throws Exception {
       Thread.sleep(seconds*1000);
    }

    @Step("Verify that the page title is <pageTitle>")
    public void verifyPageTitle(String pageTitle) throws IOException {
        androidBaseObj.isElementAccessibilityIdTextEquals(TOOL_BAR, pageTitle);
    }

    @Step("Swipe the device screen horizontally right to left")
    public void swipeRightToLeftHorizontally() throws InterruptedException {
        androidBaseObj.swipeRightToLeftHorizontally();
    }

    @Step("Swipe the device screen horizontally left to right")
    public void swipeLeftToRightHorizontally() throws InterruptedException {
        androidBaseObj.swipeLeftToRightHorizontally();
    }

    @Step("Swipe the device screen vertically top to bottom")
    public void swipeTopToBottomVertically() throws InterruptedException {
        androidBaseObj.swipeTopToBottomVertically();
    }

    @Step("Swipe the device screen vertically bottom to top")
    public void swipeBottomToTopVertically() throws InterruptedException {
        androidBaseObj.swipeBottomToTopVertically();
    }

    @Step("Scroll down to the bottom of the screen")
    public void scrollDownToBottom() throws InterruptedException {
        androidBaseObj.scrollDown();
    }

    @Step("Scroll to the text of <text>")
    public void scrollTo(String text) throws InterruptedException {
        androidBaseObj.scrollTo(text);
    }

    @Step("Navigate back from the device")
    public void navigateBackFromDevice() throws InterruptedException {
        androidBaseObj.navigateBackFromDevice();
    }

    @Step("Verify the webview contains <text>")
    public void isWebViewTextEquals(String text) throws InterruptedException {
        androidBaseObj.isWebViewTextEquals(text);
    }

    @Step("Verify the webview contains the following text <table>")
    public void isWebViewTextEquals(Table table) throws InterruptedException {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            androidBaseObj.isWebViewTextEquals(row.getCell(columnNames.get(0)));
        }
    }

    @Step("Tap on <text>")
    public void tapOnVisibleText(String text){
        androidBaseObj.scrollAndTap(text);
    }

    @Step("Press Enter button on the Keyboard")
    public void pressKeyboardEnter() {
        androidBaseObj.pressKeyboardEnter();
    }

    @Step("Hide keyboard")
    public void hideKeyboard() {
        androidBaseObj.hideKeyboard();
    }

    @Step("Show keyboard")
    public void showKeyboard() {
        androidBaseObj.hideKeyboard();
    }

    @Step("Quit from the mobile application")
    public void quitMobileApp() {
        AndroidDriverSetup.tearDown();
    }

    @Step("Quit from the web application")
    public void quitWebApp() {
        WebDriverSetup.tearDown();
    }


}

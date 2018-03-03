package com.maxsoft.automation.webapimobileintegration.common;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.maxsoft.automation.webapimobileintegration.util.AndroidDriverSetup;
import com.maxsoft.automation.webapimobileintegration.util.FileOperator;
import java.io.IOException;
import java.util.*;
import java.util.List;
import static com.maxsoft.automation.webapimobileintegration.util.AndroidDriverSetup.androidDriver;


/**
 * Created by Osanda on 03/02/2018.
 */


public class AndroidAppBase extends CommonBase {

    private final String WEBVIEW = System.getenv("webview");
    private final String NATIVE_APP = System.getenv("native_app");
    private WebElement element;
    private Dimension size;
    private List<WebElement> elements;
    private List <String> elementNameList = new ArrayList();


    public AndroidDriver androidDriver(){
        return androidDriver;
    }

    public void isAndroidDriverAlive(){
        Boolean hasQuit;
        hasQuit = androidDriver.toString().contains("(null)");
        if (hasQuit == Boolean.FALSE){
            printText("Android driver has launched successfully");
        } else {
            printText("An error occurred while launching the Android driver");
        }
    }

    protected void waitForElementClickable(WebElement element) throws IOException {
        WebDriverWait wait = new WebDriverWait(androidDriver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForElementVisible(WebElement element) throws IOException {
        WebDriverWait wait = new WebDriverWait(androidDriver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void tap(WebElement element) throws IOException {
        waitForElementVisible(element);
        element.click();
    }

    protected void setTextAs(WebElement element, String text) throws IOException {
        waitForElementClickable(element);
        element.clear();
        element.sendKeys(text);
    }

    protected void clearText(WebElement element) throws IOException {
        waitForElementClickable(element);
        element.clear();
    }

    protected WebElement getElementByReplacingXpath(WebElement element, String textToBeReplaced, String replacementText) throws IOException {
        String modifiedXpath = element.getAttribute("xpath").replace(textToBeReplaced, replacementText);
        WebDriverWait wait = new WebDriverWait(androidDriver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(modifiedXpath)));
        return androidDriver.findElement(By.xpath(modifiedXpath));

    }

    protected void replaceXpathAndTapElement(WebElement element, String textToBeReplaced, String replacementText) throws IOException {
        String modifiedXpath = element.getAttribute("xpath").replace(textToBeReplaced, replacementText);
        WebDriverWait wait = new WebDriverWait(androidDriver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(modifiedXpath)));
        androidDriver.findElement(By.xpath(modifiedXpath)).click();
    }

    protected void hideKeyboard(){
        try {
            androidDriver.hideKeyboard();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void isFailed(WebElement element, String expectedPageTitle) throws IOException {
        waitForElementVisible(element);
        Assert.assertTrue(element.isDisplayed(), "Page title locator is invalid.");
        Assert.assertTrue(element.getAttribute("name").equals(expectedPageTitle), "Expected result is not obtained");
    }

    protected void isSuccess(WebElement element, String expectedPageTitle) throws IOException {
        waitForElementVisible(element);
        Assert.assertTrue(element.isDisplayed(), "Page title locator is invalid.");
        Assert.assertTrue(element.getAttribute("name").equals(expectedPageTitle), "Expected result is not obtained");
    }

    protected void isElementAttributeValueEquals(WebElement element, String attributeName, String attributeValue) throws IOException {
        waitForElementVisible(element);
        Assert.assertTrue(element.isDisplayed(), "Element cannot be found.");
        Assert.assertEquals(element.getAttribute(attributeName), attributeValue, "Element's attribute "+attributeName+" is mismatched.");
    }

    protected void isPageTitleEquals(WebElement element, String expectedPageTitle) throws IOException {
        waitForElementVisible(element);
        Assert.assertTrue(element.isDisplayed(), "Page title locator is invalid.");
        Assert.assertEquals(element.getAttribute("name"), expectedPageTitle, "Page title mismatched.");
    }

    protected void isElementNameEquals(WebElement element, String elementText) throws IOException {
        waitForElementVisible(element);
        Assert.assertTrue(element.isDisplayed(), "Element cannot be found.");
        Assert.assertEquals(element.getAttribute("name"), elementText, "Element text mismatched.");
    }

    protected void isElementValueEquals(WebElement element, String attributeValue) throws IOException {
        waitForElementVisible(element);
        Assert.assertTrue(element.isDisplayed(), "Element cannot be found.");
        Assert.assertEquals(element.getAttribute("value"), attributeValue, "Element's value is mismatched.");
    }

    protected void isElementLabelEquals(WebElement element, String attributeValue) throws IOException {
        waitForElementVisible(element);
        Assert.assertTrue(element.isDisplayed(), "Element cannot be found.");
        Assert.assertEquals(element.getAttribute("label"), attributeValue, "Element's value is mismatched.");
    }

    protected void isElementAccessibilityIdTextEquals(WebElement element, String elementText) throws IOException {
        waitForElementVisible(element);
        waitForElementVisible(element);
        Assert.assertEquals(element.getAttribute("name"), elementText, "Element text mismatched.");
    }

    protected void isElementTextEquals(WebElement element, String elementText) throws IOException {
        waitForElementVisible(element);
        String actualTextInElement = element.getAttribute("text");
        Assert.assertEquals(actualTextInElement, elementText, "Element text mismatched.");
    }

    protected void isTextEquals(WebElement element, String buttonText) throws IOException {
        waitForElementVisible(element);
        isElementNameEquals(element, buttonText);
    }

    protected void isLabelTextEquals(String visibleText) {
        androidDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\""+visibleText+"\"]"));
    }

    protected void isElementVisible(WebElement element) throws IOException {
        waitForElementVisible(element);
        Assert.assertTrue(element.isDisplayed(), "Element cannot be found.");
    }

    protected void isElementNotVisible(WebElement element) throws IOException {
        try {
            Assert.assertFalse(element.isDisplayed(), "Element has found.");
            Assert.fail("\"" + element.getText() + "\"" + " Element has found");
        } catch (NoSuchElementException ex){
            ex.printStackTrace();
        }
    }

    protected void isTextVisible(WebElement element, String elementText) throws IOException {
        try{
            scrollTo(elementText);
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
            Assert.fail("\"" + elementText + "\"" + " Not found");
        }
    }

    protected void isTextNotVisible(WebElement element, String elementText) throws IOException {
        try{
            scrollTo(elementText);
            Assert.fail("\"" + elementText + "\"" + " Element has found");
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
        }
    }

    public void saveToScenarioDataStore(String variableNameOfValueToBeStoredInDataStore, String valueToBeStoredInDataStore) {
        // Adding value to the Data Store
        DataStore scenarioStore = DataStoreFactory.getScenarioDataStore();
        scenarioStore.put(variableNameOfValueToBeStoredInDataStore, valueToBeStoredInDataStore);
    }

    protected String getTextByScenarioDataStoreName(String variableNameOfValueStoredInDataStore) {
        // Fetching Value from the Data Store
        DataStore scenarioStore = DataStoreFactory.getScenarioDataStore();
        return (String) scenarioStore.get(variableNameOfValueStoredInDataStore);
    }

    protected void scrollDown() {
        Dimension size = androidDriver.manage().window().getSize();
        int startY = (int) (size.height * 0.7);
        int endY = (int) (size.height * 0.2);
        int startX = size.height / 2;
        androidDriver.swipe(startX, startY, startX, endY, 800);
    }

    protected void scrollTo(String visibleText) {
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))");
    }

    protected void scrollAndTap(String visibleText) {
        try {
            androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
        } catch (Exception ex){
            androidDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\""+visibleText+"\"]")).click();
        }
    }

    protected void tapMobileKeyboardEnter() {
        TouchAction touchAction = new TouchAction(androidDriver);
        touchAction.tap(750, 1150).perform();
    }

    protected void isWebViewTextEquals(String text) {
        Assert.assertTrue(androidDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@content-desc=\""+ text +"\"]")).isDisplayed(), "\"" + text + "\" cannot be found in webview");
    }

    protected void swipeToElement(WebElement element, int duration) throws IOException {
        int topY = element.getLocation().getY();
        int bottomY = topY + element.getSize().getHeight();
        int centerX = element.getLocation().getX() + (element.getSize().getWidth()/2);
        androidDriver.swipe(centerX, bottomY, centerX, topY, duration);
    }

    protected void swipeLeftToRightHorizontally() throws InterruptedException {
        //Get the size of screen.
        size = androidDriver.manage().window().getSize();
        System.out.println(size);
        //Find swipe start and end point from screen's with and height.
        //Find startx point which is at right side of screen.
        int startx = (int) (size.width * 0.90);
        //Find endx point which is at left side of screen.
        int endx = (int) (size.width * 0.10);
        //Find vertical point where you wants to swipe. It is in middle of screen height.
        int starty = size.height / 2;
        System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);
        //Swipe from Left to Right.
        androidDriver.swipe(endx, starty, startx, starty, 500);
        freeze(2);
    }

    protected void swipeRightToLeftHorizontally() throws InterruptedException {
        //Get the size of screen.
        size = androidDriver.manage().window().getSize();
        System.out.println(size);
        //Find swipe start and end point from screen's with and height.
        //Find startx point which is at right side of screen.
        int startx = (int) (size.width * 0.99);
        //Find endx point which is at left side of screen.
        int endx = (int) (size.width * 0.01);
        //Find vertical point where you wants to swipe. It is in middle of screen height.
        int starty = size.height / 2;
        System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);
        //Swipe from Right to Left.
        androidDriver.swipe(startx, starty, endx, starty, 500);
        freeze(2);
    }

    protected void swipeTopToBottomVertically() throws InterruptedException {
        //Get the size of screen.
        size = androidDriver.manage().window().getSize();
        System.out.println(size);
        //Find swipe start and end point from screen's with and height.
        //Find startY point which is at bottom side of screen.
        int startY = (int) (size.height * 0.90);
        //Find endY point which is at top side of screen.
        int endY = (int) (size.height * 0.10);
        //Find horizontal point where you wants to swipe. It is in middle of screen width.
        int startX = size.width / 2;
        System.out.println("startY = " + startY + " ,endY = " + endY + " , startX = " + startX);
        //Swipe from Top to Bottom.
        androidDriver.swipe(startX, endY, startX, startY, 500);
        freeze(2);
    }

    protected void swipeBottomToTopVertically() throws InterruptedException {
        //Get the size of screen.
        size = androidDriver.manage().window().getSize();
        System.out.println(size);
        //Find swipe start and end point from screen's with and height.
        //Find startY point which is at bottom side of screen.
        int startY = (int) (size.height * 0.90);
        //Find endY point which is at top side of screen.
        int endY = (int) (size.height * 0.10);
        //Find horizontal point where you wants to swipe. It is in middle of screen width.
        int startX = size.width / 2;
        System.out.println("startY = " + startY + " ,endY = " + endY + " , startX = " + startX);
        //Swipe from Bottom to Top.
        androidDriver.swipe(startX, startY, startX, endY, 500);
        freeze(2);
    }

    protected List<WebElement> getElementsByClassName(String classNameOfElementList, String elementId){
        elements = androidDriver.findElementByClassName(classNameOfElementList).findElements(By.id(elementId));
        return elements;
    }

    protected void printElementsNameList(String classNameOfElementList, String elementId){
        System.out.println("Items found:");
        Gauge.writeMessage("Items found:");
        int i = 1;
        for(WebElement element : getElementsByClassName(classNameOfElementList, elementId)) {
            System.out.println(i + ") " + element.getText());
            Gauge.writeMessage(i + ") " + element.getText());
            elementNameList.add(element.getText());
            i++;
        }
    }

    protected void addElementNamesToList(List<WebElement> webElementList, List <String> listToAddElementNames){
        for(WebElement element : webElementList) {
            listToAddElementNames.add(element.getText());
        }
    }

    protected void IsElementEnable(WebElement element, boolean isEnable) throws IOException {
        if (element.isEnabled() == Boolean.TRUE) {
            System.out.println("Element is enabled");
            Gauge.writeMessage("Element is enabled");
        } else {
            System.out.println("Element is disabled");
            Gauge.writeMessage("Element is disabled");
        }
        Assert.assertEquals(element.isEnabled(), isEnable, "The actual enable/disable status of the element is not match with the expected status.");
    }

    protected void isRadioButtonActive(WebElement element, String textToBeReplaced, String replacementText, Boolean expectedStatus) throws IOException {
        Assert.assertEquals(getElementByReplacingXpath(element, textToBeReplaced, replacementText).getAttribute("checked").toLowerCase(), expectedStatus.toString(), "Radio button's active/en-active status is differ from the expected.");
    }

    protected String getHTMLPageSource(){
        switchContextTo(WEBVIEW);
        return androidDriver.getPageSource();
    }

    protected String getHTMLPageSource(String url){
        switchContextTo(WEBVIEW);
        androidDriver.navigate().to(url);
        return androidDriver.getPageSource();
    }

    protected void saveHTMLPageSource(String filePath){
        String FILE_PATH = AndroidDriverSetup.PROJECT_ROOT.concat(filePath);
        FileOperator.write(getHTMLPageSource().replaceAll("’", "'").replaceAll("é", "e"), FILE_PATH);
    }

    protected void getContextNames(){
        Set<String> contextNames = androidDriver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextNames); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
    }

    protected void switchContextTo(String context){
        if (context.toLowerCase().equals(WEBVIEW.toLowerCase())) {
            androidDriver.context(WEBVIEW); // set context to WEBVIEW_1
        } else {
            androidDriver.context(NATIVE_APP); // set context to NATIVE_APP
        }
    }

    protected void freeze(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void navigateBackFromDevice(){
        androidDriver.navigate().back();
    }

    protected void setDatePickerAndroid(WebElement datePickerAndroid, WebElement dateElement, String date, WebElement datePickerOkButton) throws IOException {
        tap(datePickerAndroid);
        replaceXpathAndTapElement(dateElement, "examDate", date);
        tap(datePickerOkButton);
    }

    protected void setTimePickerAndroid(WebElement timePicker, WebElement amButton, WebElement pmButton, String hour, String minutes, String amPm, WebElement timePickerOkButton) throws IOException {
        tap(timePicker);
        androidDriver.findElementByAccessibilityId(hour).click();
        androidDriver.findElementByAccessibilityId(minutes).click();
        if (amPm.toLowerCase().equals("am")){
            tap(amButton);
        } else if (amPm.toLowerCase().equals("pm")) {
            tap(pmButton);
        }
        tap(timePickerOkButton);
    }

    protected void pressKeyboardEnter() {
        TouchAction touchAction = new TouchAction(androidDriver);
        touchAction.tap(750, 1150).perform();
    }


}

package com.maxsoft.automation.webtomobileintegration.common;

import com.maxsoft.automation.webtomobileintegration.util.WebDriverSetup;
import com.thoughtworks.gauge.Gauge;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * Created by Osanda on 02/09/2018.
 */


public class WebBase {

    protected static String URL = System.getenv("web_application_endpoint");
    private WebDriver webDriver = WebDriverSetup.webDriver;

    public WebBase() {
        PageFactory.initElements( webDriver, this);
    }

    public void printText(String text){
        System.out.println(text);
        Gauge.writeMessage(text);
    }

    protected void waitForElementClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait( webDriver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForElementVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait( webDriver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void setTextAs(WebElement element, String text){
        waitForElementClickable(element);
        element.sendKeys(text);
    }

    protected void clickElement(WebElement element){
        waitForElementClickable(element);
        element.click();
    }

    protected void clickLink(WebElement element){
        waitForElementVisible(element);
        element.click();
    }

    protected String getText(WebElement element){
        waitForElementVisible(element);
        return element.getText();
    }

    protected void freeze(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

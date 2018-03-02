package com.maxsoft.automation.webtomobileintegration.common;

import com.maxsoft.automation.webtomobileintegration.util.WebDriverSetup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;


/**
 * Created by Osanda on 02/09/2018.
 */


public class WebBase {

    protected static final String URL = System.getenv("web_application_endpoint");
    private WebDriver webDriver = WebDriverSetup.webDriver;

    public WebBase() {
        PageFactory.initElements(webDriver, this);
    }

    protected void waitForElementClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(webDriver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForElementVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(webDriver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void setTextAs(WebElement element, String text){
        waitForElementClickable(element);
        element.sendKeys(text);
    }

    protected void clearText(WebElement element){
        waitForElementClickable(element);
        element.clear();
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

    protected void selectFromDropdown(String xpathOfDropdown, String visibleText){
        Select dropdown = new Select(webDriver.findElement(By.xpath(xpathOfDropdown)));
        WebDriverWait wait = new WebDriverWait(webDriver, 15);
        int attempt = 0;
        while (attempt < 5) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathOfDropdown)));
                dropdown.selectByVisibleText(visibleText);
                break;
            } catch (Exception ex) {
                attempt++;
            }
        }
    }

    protected void freeze(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

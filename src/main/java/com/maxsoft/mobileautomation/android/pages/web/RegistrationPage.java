package com.maxsoft.mobileautomation.android.pages.web;

import com.maxsoft.mobileautomation.android.common.WebBase;
import com.maxsoft.mobileautomation.android.util.WebDriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Osanda on 02/09/2018.
 */


public class RegistrationPage extends WebBase {

    public static String REGISTRATION_PAGE_URL = URL.concat("/mercuryregister.php");
    private WebDriver webDriver = WebDriverSetup.webDriver;

    public RegistrationPage() {
        PageFactory.initElements( webDriver, this);
    }

    @FindBy(xpath = "//input[@id='email']")
    WebElement TXT_USERNAME;
    @FindBy(xpath = "//input[@name='password']")
    WebElement TXT_PASSWORD;
    @FindBy(xpath = "//input[@name='confirmPassword']")
    WebElement TXT_CONFIRM_PASSWORD;
    @FindBy(xpath = "//input[@name='register']")
    WebElement BTN_SIGN_IN;

    public void navigateToRegistration(){
        webDriver.get( REGISTRATION_PAGE_URL );
    }

    public void register(String username, String password, String confirmPassword ){
        setTextAs(TXT_USERNAME, username);
        setTextAs(TXT_PASSWORD, password);
        setTextAs(TXT_CONFIRM_PASSWORD, confirmPassword);
        clickElement(BTN_SIGN_IN);
    }

    public void isUserRegistrationSuccess(String username){
        WebElement webElement = webDriver.findElement(By.xpath("//a/font/b[contains(text(),'" +username+ "')]"));
        waitForElementVisible(webElement);
    }


}

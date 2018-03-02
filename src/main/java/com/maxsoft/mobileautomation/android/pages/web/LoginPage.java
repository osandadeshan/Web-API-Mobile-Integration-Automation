package com.maxsoft.mobileautomation.android.pages.web;

import com.maxsoft.mobileautomation.android.common.WebBase;
import com.maxsoft.mobileautomation.android.util.WebDriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Osanda on 02/09/2018.
 */


public class LoginPage extends WebBase {

    public static String LOGIN_PAGE_URL = URL;
    private WebDriver webDriver = WebDriverSetup.webDriver;

    public LoginPage() {
        PageFactory.initElements( webDriver, this);
    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement TXT_USERNAME;
    @FindBy(xpath = "//input[@id='password']")
    WebElement TXT_PASSWORD;
    @FindBy(xpath = "//button[contains(text(),'Sign In')]")
    WebElement BTN_SIGN_IN;

    public void navigateToLogin(){
        webDriver.get( LOGIN_PAGE_URL );
    }

    public void login(String username, String password){
        setTextAs(TXT_USERNAME, username);
        setTextAs(TXT_PASSWORD, password);
        clickElement(BTN_SIGN_IN);
    }


}

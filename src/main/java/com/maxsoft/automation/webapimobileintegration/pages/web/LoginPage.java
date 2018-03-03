package com.maxsoft.automation.webapimobileintegration.pages.web;

import com.maxsoft.automation.webapimobileintegration.common.WebAppBase;
import com.maxsoft.automation.webapimobileintegration.util.WebDriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Osanda on 03/02/2018.
 */


public class LoginPage extends WebAppBase {

    private static final String LOGIN_PAGE_URL = URL;
    private WebDriver webDriver = WebDriverSetup.webDriver;

    public LoginPage() {
        PageFactory.initElements( webDriver, this);
    }

    @FindBy(xpath = "//input[@id='username']")
    private WebElement TXT_USERNAME;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement TXT_PASSWORD;
    @FindBy(xpath = "//button[contains(text(),'Sign In')]")
    private WebElement BTN_SIGN_IN;

    public void navigateToLogin(){
        webDriver.get( LOGIN_PAGE_URL );
    }

    public void login(String username, String password){
        setTextAs(TXT_USERNAME, username);
        setTextAs(TXT_PASSWORD, password);
        clickElement(BTN_SIGN_IN);
    }


}

package com.maxsoft.mobileautomation.android.stepdefinitions.web;

import com.maxsoft.mobileautomation.android.pages.web.LoginPage;
import com.maxsoft.mobileautomation.android.util.WebDriverSetup;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Osanda on 02/09/2018.
 */


public class LoginPageStepDefinitions {

    LoginPage loginPage = PageFactory.initElements(WebDriverSetup.webDriver, LoginPage.class);

    @Step("Navigate to login page")
    public void navigateToLogin(){
        loginPage.navigateToLogin();
    }

    @Step("Login to the application using the username as <username> and password as <password>")
    public void login(String username, String password){
        loginPage.login(username, password);
    }


}
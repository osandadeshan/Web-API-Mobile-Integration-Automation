package com.maxsoft.automation.webtomobileintegration.stepdefinitions.web;

import com.maxsoft.automation.webtomobileintegration.util.WebDriverSetup;
import com.maxsoft.automation.webtomobileintegration.pages.web.LoginPage;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Osanda on 02/09/2018.
 */


public class LoginPageStepDefinitions {

    private LoginPage loginPage = PageFactory.initElements( WebDriverSetup.webDriver, LoginPage.class);

    @Step("Navigate to login page")
    public void navigateToLogin(){
        loginPage.navigateToLogin();
    }

    @Step("Login to the application using the username as <username> and password as <password>")
    public void login(String username, String password){
        loginPage.login(username, password);
    }


}
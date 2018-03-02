package com.maxsoft.automation.webtomobileintegration.stepdefinitions.web;

import com.maxsoft.automation.webtomobileintegration.pages.web.RegistrationPage;
import com.maxsoft.automation.webtomobileintegration.util.WebDriverSetup;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Osanda on 02/09/2018.
 */


public class RegistrationPageStepDefinitions {

    RegistrationPage registrationPage = PageFactory.initElements( WebDriverSetup.webDriver, RegistrationPage.class);

    @Step("Navigate to registration page")
    public void navigateToRegistration(){
        registrationPage.navigateToRegistration();
    }

    @Step("Register to the application using the username as <username> and password as <password>")
    public void register(String username, String password){
        registrationPage.register(username, password, password);
    }

    @Step("Verify the <username> user has successfully registered")
    public void isUserRegistrationSuccess(String username){
        registrationPage.isUserRegistrationSuccess(username);
    }


}
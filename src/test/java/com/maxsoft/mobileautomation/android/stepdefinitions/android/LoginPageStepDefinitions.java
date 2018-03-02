package com.maxsoft.mobileautomation.android.stepdefinitions.android;

import com.maxsoft.mobileautomation.android.pages.android.LoginPage;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;
import java.util.List;
import static com.maxsoft.mobileautomation.android.util.AndroidDriverSetup.androidDriver;


/**
 * Created by Osanda on 4/29/2017.
 */


public class LoginPageStepDefinitions {

    private LoginPage loginPage = PageFactory.initElements(androidDriver, LoginPage.class);

    @Step("Verify that the Login page title is <pageTitle>")
    public void verifyLoginPageTitle(String pageTitle) throws IOException {
        loginPage.isLoginPageTitleEquals(pageTitle);
    }

    @Step("Verify that a user can login into the application using valid username and password <table>")
    public void verifyLogin(Table table) throws IOException {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            loginPage.login(row.getCell(columnNames.get(0)), row.getCell(columnNames.get(1)));
        }
    }

    @Step("Clear text fields in Login page")
    public void clearTextFields() throws IOException {
        loginPage.clearTextFields();
    }

    @Step("Verify that the Create Account button is visible")
    public void isCreateAccountButtonVisible() throws IOException {
        loginPage.isCreateAccountButtonVisible();
    }

    @Step("On Create Account Page")
    public void navigateToCreateAccount() throws IOException {
        loginPage.navigateToCreateAccount();
    }

    @Step("Verify that the login is success")
    public void isLoginSuccess() throws IOException {
        loginPage.isLoginSuccess();
    }

    @Step("Skip the welcome flow")
    public void skipWelcomeFlow() throws IOException {
        loginPage.skipWelcomeFlow();
    }

    @Step("Tap 'Got It' button")
    public void tapGotItButton() throws IOException {
        loginPage.tapGotItButton();
    }

    @Step("Verify that the login is fail")
    public void isLoginFail() throws IOException {
        loginPage.isLoginFail();
    }

    @Step("Verify that the user lands to the <pageTitle> page")
    public void verifyLandingPage(String pageTitle) throws IOException {
        loginPage.isLandingPageTitleEquals(pageTitle);
    }


}

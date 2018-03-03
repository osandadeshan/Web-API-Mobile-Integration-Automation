package com.maxsoft.automation.webapimobileintegration.stepdefinitions.android;

import com.maxsoft.automation.webapimobileintegration.util.AndroidDriverSetup;
import com.maxsoft.automation.webapimobileintegration.pages.android.LoginPage;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;
import java.util.List;


/**
 * Created by Osanda on 03/02/2018.
 */


public class LoginPageStepDefinitions {

    private LoginPage loginPage = PageFactory.initElements(AndroidDriverSetup.androidDriver, LoginPage.class);

    @Step("Login page title is <pageTitle>")
    public void verifyLoginPageTitle(String pageTitle) throws IOException {
        loginPage.isLoginPageTitleEquals(pageTitle);
    }

    @Step("Login into the application using valid username and password <table>")
    public void verifyLogin(Table table) throws IOException {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            loginPage.login(row.getCell(columnNames.get(0)), row.getCell(columnNames.get(1)));
        }
    }

    @Step("Login into the application using valid username and password stored in data stores <table>")
    public void verifyLoginByDataStoreValues(Table table) throws IOException {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            loginPage.loginByDataStoreValues(row.getCell(columnNames.get(0)), row.getCell(columnNames.get(1)), row.getCell(columnNames.get(2)));
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

    @Step("Navigate to Create Account Page")
    public void navigateToCreateAccount() throws IOException {
        loginPage.navigateToCreateAccount();
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


}

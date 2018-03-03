package com.maxsoft.automation.webapimobileintegration.stepdefinitions.web;

import com.maxsoft.automation.webapimobileintegration.pages.web.RegistrationPage;
import com.maxsoft.automation.webapimobileintegration.util.WebDriverSetup;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.List;


/**
 * Created by Osanda on 03/02/2018.
 */


public class RegistrationPageStepDefinitions {

    private RegistrationPage registrationPage = PageFactory.initElements(WebDriverSetup.webDriver, RegistrationPage.class);

    @Step("Navigate to registration page")
    public void navigateToRegistration(){
        registrationPage.navigateToRegistration();
    }

    @Step("Register to the application using the following details <table>")
    public void register(Table table){
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            registrationPage.register(row.getCell(columnNames.get(0)), row.getCell(columnNames.get(1)), row.getCell(columnNames.get(2)),
                    row.getCell(columnNames.get(3)), row.getCell(columnNames.get(4)), row.getCell(columnNames.get(5)), row.getCell(columnNames.get(6)));
        }
    }

    @Step("Register to the application using the following details stored in data stores <table>")
    public void registerByDataStoreValues(Table table){
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            registrationPage.registerByDataStoreValues(row.getCell(columnNames.get(0)), row.getCell(columnNames.get(1)), row.getCell(columnNames.get(2)),
                    row.getCell(columnNames.get(3)), row.getCell(columnNames.get(4)), row.getCell(columnNames.get(5)), row.getCell(columnNames.get(6)), row.getCell(columnNames.get(7)));
        }
    }

    @Step("Message appears after the registration is <message>")
    public void registrationResult(String message){
        Assert.assertEquals(registrationPage.formHeaderTitle(), message);
    }


}
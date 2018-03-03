package com.maxsoft.automation.webapimobileintegration.stepdefinitions.api;

import com.maxsoft.automation.webapimobileintegration.pages.api.PiToken;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.testng.Assert;
import java.util.List;


/**
 * Created by Osanda on 03/02/2018.
 */


public class PiTokenStepDefinitions extends PiToken{

    @Step("Set request payload for PI authentication API <table>")
    public void setRequestBody(Table table){
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            super.setRequestBody(row.getCell(columnNames.get(0)), row.getCell(columnNames.get(1)));
        }
    }

    @Step("Set request payload using data stores for PI authentication API <table>")
    public void setRequestBodyByDataStores(Table table){
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            super.setRequestBodyByDataStores(row.getCell(columnNames.get(0)), row.getCell(columnNames.get(1)), row.getCell(columnNames.get(2)));
        }
    }

    @Step("Invoke PI authentication API")
    public void invokePiTokenApi(){
        super.invokePiTokenApi();
    }

    @Step("Status code for PI authentication API is <statusCode>")
    public void validateStatusCode(String statusCode){
        Assert.assertEquals(super.getStatusCode(), statusCode);
    }

    @Step("JSON Path Assertions for the PI authentication API <table>")
    public void jsonPathAssertions(Table table){
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {;
            Assert.assertEquals(jsonPathValue(row.getCell(columnNames.get(0))), row.getCell(columnNames.get(1)));
        }
    }



}

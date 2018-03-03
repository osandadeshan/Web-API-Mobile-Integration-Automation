package com.maxsoft.automation.webapimobileintegration.common;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import java.util.List;


/**
 * Created by Osanda on 03/02/2018.
 */


public class CommonStepDefinitions {

    private CommonBase commonBaseObj = new CommonBase();

    // Use this method to save strings in data store
    @Step("Save the strings inside data stores <table>")
    public void saveToDataStore(Table table){
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            commonBaseObj.saveToDataStore(row.getCell(columnNames.get(0)),row.getCell(columnNames.get(1)), row.getCell(columnNames.get(2)));
        }
    }

    // Use this method to read strings from data store
    @Step("Read the strings from data stores <table>")
    public void readValueFromDataStore(Table table){
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            commonBaseObj.readFromDataStore(row.getCell(columnNames.get(0)),row.getCell(columnNames.get(1)));
        }
    }

    @Step("Wait <seconds> seconds")
    public void wait(int seconds) throws Exception {
       Thread.sleep(seconds*1000);
    }


}

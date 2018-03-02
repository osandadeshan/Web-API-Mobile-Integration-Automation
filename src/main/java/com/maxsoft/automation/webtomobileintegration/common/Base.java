package com.maxsoft.automation.webtomobileintegration.common;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;


public class Base {

    public void printText(String text){
        System.out.println(text);
        Gauge.writeMessage(text);
    }

    public String getScenarioDataStoreValue(String variableName) {
        try {
            // Fetching Value from the Data Store
            DataStore scenarioStore = DataStoreFactory.getScenarioDataStore();
            String value = (String) scenarioStore.get(variableName);
            printText("Text inside Scenario Data Store [" + variableName + "] is: \"" + value + "\"");
            return value;
        } catch (Exception ex) {
            printText("Failed to read the text inside Scenario Data Store [" + variableName + "]");
            return "";
        }
    }

    public String getSpecificationDataStoreValue(String variableName) {
        try {
            // Fetching Value from the Data Store
            DataStore specDataStore = DataStoreFactory.getSpecDataStore();
            String value = (String) specDataStore.get(variableName);
            printText("Text inside Specification Data Store [" + variableName + "] is: \"" + value + "\"");
            return value;
        } catch (Exception ex) {
            printText("Failed to read the text inside Specification Data Store [" + variableName + "]");
            return "";
        }
    }

    public void saveToScenarioDataStore(String variableName, String textToBeStored) {
        try {
            // Adding value to the Data Store
            DataStore scenarioStore = DataStoreFactory.getScenarioDataStore();
            scenarioStore.put(variableName, textToBeStored);
            printText("\"" + textToBeStored + "\" is successfully saved as a text in Scenario Data Store [" + variableName + "]");
        } catch (Exception ex) {
            printText("\"" + textToBeStored + "\" is failed to save as a text in Scenario Data Store [" + variableName + "]");
        }
    }

    public void saveToSpecificationDataStore(String variableName, String textToBeStored) {
        try {
            // Adding value to the Data Store
            DataStore specDataStore = DataStoreFactory.getSpecDataStore();
            specDataStore.put(variableName, textToBeStored);
            printText("\"" + textToBeStored + "\" is successfully saved as a text in Specification Data Store [" + variableName + "]");
        } catch (Exception ex) {
            printText("\"" + textToBeStored + "\" is failed to save as a text in Specification Data Store [" + variableName + "]");
        }
    }

    public void saveToDataStore(String dataStoreType, String variableName, String textToBeStored){
        if (dataStoreType.toLowerCase().equals("spec") || dataStoreType.toLowerCase().equals("specification")){
            saveToSpecificationDataStore(variableName, textToBeStored);
        } else {
            saveToScenarioDataStore(variableName, textToBeStored);
        }
    }

    public String readFromDataStore(String dataStoreType, String variableName){
        if (dataStoreType.toLowerCase().equals("spec") || dataStoreType.toLowerCase().equals("specification")){
            return getSpecificationDataStoreValue(variableName);
        } else {
            return getScenarioDataStoreValue(variableName);
        }
    }


}

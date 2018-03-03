package com.maxsoft.automation.webapimobileintegration.pages.api;

import java.util.HashMap;
import java.util.Map;
import com.jayway.restassured.response.Response;
import com.maxsoft.automation.webapimobileintegration.common.ApiBase;
import io.restassured.response.ValidatableResponse;
import org.json.JSONObject;

import static com.jayway.restassured.RestAssured.given;


public class PiToken extends ApiBase {

    Map<String,String> requestBody = new HashMap<>();
    private Response response;
    private ValidatableResponse json;
    private static final String PI_TOKEN_ENDPOINT = URL.concat("/tokens");
    JSONObject jsonResponseBody;

    public void setRequestBody(String attributeName, String attributeValue){
        requestBody.put(attributeName, attributeValue);
    }

    public void setRequestBodyByDataStores(String attributeName, String dataStoreType, String variableName){
        if (dataStoreType.toLowerCase().equals("scenario")){
            requestBody.put(attributeName, getScenarioDataStoreValue(variableName));
        } else {
            requestBody.put(attributeName, getSpecificationDataStoreValue(variableName));
        }
    }

    public void invokePiTokenApi(){
        response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(PI_TOKEN_ENDPOINT);
        printText(response.prettyPrint());
    }

    public String getStatusCode(){
        return String.valueOf(response.getStatusCode());
    }

    public String jsonPathValue(String attributeName) {
        jsonResponseBody = new JSONObject(response.body().asString());
        return jsonResponseBody.getString(attributeName);
    }


}

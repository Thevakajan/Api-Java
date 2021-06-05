package com.test.qa.sampleRequest;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.test.qa.utils.APIUtils;
import com.test.qa.utils.Constants;

import java.util.HashMap;

public class PetProject {

    @Test(priority = 1, groups = { "regression"})
    public void testResponseCode(){
        SoftAssert softAssert = new SoftAssert();
        Response response = get(Constants.BASE_URL_WEATHER+Constants.ENDPOINT_WEATHER+Constants.QUERY_PARAMETER);
        softAssert.assertEquals(response.getStatusCode(), 200, Constants.INVALID_CODE_TEXT);
        APIUtils.printResults(response);
        softAssert.assertAll();
    }

    @Test(priority = 2, groups = { "regression", "smoke"})
    public void testPostRequest(){
        SoftAssert softAssert = new SoftAssert();
        String  body = APIUtils.readBody(Constants.BODY_PATH + "petpost.json");
        Response response = given().header(Constants.HEADER_CONTENT_TYPE, Constants.HEADER_CONTENT_VAL_JSON).body(body).when().post(Constants.BASE_URL_PETSTORE +Constants.ENDPOINT_PET);
        softAssert.assertEquals(response.getStatusCode(), 200, Constants.INVALID_CODE_TEXT);
        APIUtils.printResults(response);
        softAssert.assertAll();
    }

    @Test(priority = 3, groups = { "regression", "smoke"})
    public void testGetRequest(){
        SoftAssert softAssert = new SoftAssert();
        Response response = given().header(Constants.HEADER_CONTENT_TYPE, Constants.HEADER_CONTENT_VAL_JSON).when().get(Constants.BASE_URL_PETSTORE +Constants.ENDPOINT_PET+Constants.PET_ID);
        softAssert.assertEquals(response.getStatusCode(), 200, Constants.INVALID_CODE_TEXT);
        softAssert.assertEquals(APIUtils.extractResponse(response, Constants.JSON_KEY_NAME), "doggie", Constants.INVALID_NAME_TEXT);
        softAssert.assertEquals(((HashMap) APIUtils.getObject(response.asString(), Object.class)).get(Constants.JSON_KEY_NAME), "doggie", Constants.INVALID_NAME_TEXT);
        APIUtils.printResults(response);
        softAssert.assertAll();
    }

    @Test(priority = 4, groups = { "regression"})
    public void testPutRequest(){
        SoftAssert softAssert = new SoftAssert();
        String  body = APIUtils.readBody(Constants.BODY_PATH + "petput.json");
        Response response = given().header(Constants.HEADER_CONTENT_TYPE, Constants.HEADER_CONTENT_VAL_JSON).body(body).when().put(Constants.BASE_URL_PETSTORE +Constants.ENDPOINT_PET);
        softAssert.assertEquals(response.getStatusCode(), 200, Constants.INVALID_CODE_TEXT);
        APIUtils.printResults(response);
        softAssert.assertAll();
    }

    @Test(priority = 5, groups = { "regression"})
    public void testGetRequestForUpdatedData(){
        SoftAssert softAssert = new SoftAssert();
        Response response = given().header(Constants.HEADER_CONTENT_TYPE, Constants.HEADER_CONTENT_VAL_JSON).when().get(Constants.BASE_URL_PETSTORE +Constants.ENDPOINT_PET+Constants.PET_ID);
        softAssert.assertEquals(response.getStatusCode(), 200, Constants.INVALID_CODE_TEXT);
        softAssert.assertEquals(APIUtils.extractResponse(response, Constants.JSON_KEY_NAME), "catty", Constants.INVALID_NAME_TEXT);
        softAssert.assertEquals(((HashMap) APIUtils.getObject(response.asString(), Object.class)).get(Constants.JSON_KEY_NAME), "catty", Constants.INVALID_NAME_TEXT);
        APIUtils.printResults(response);
        softAssert.assertAll();
    }

    @Test(priority = 6, groups = { "regression", "smoke"})
    public void testDeleteRequest(){
        SoftAssert softAssert = new SoftAssert();
        Response response = given().header(Constants.HEADER_CONTENT_TYPE, Constants.HEADER_CONTENT_VAL_JSON).when().delete(Constants.BASE_URL_PETSTORE +Constants.ENDPOINT_PET+Constants.PET_ID);
        softAssert.assertEquals(response.getStatusCode(), 200, Constants.INVALID_CODE_TEXT);
        APIUtils.printResults(response);
        softAssert.assertAll();
    }

    @Test(priority = 7, groups = { "regression", "smoke"})
    public void testGetRequestForDeletedData(){
        SoftAssert softAssert = new SoftAssert();
        Response response = given().header(Constants.HEADER_CONTENT_TYPE, Constants.HEADER_CONTENT_VAL_JSON).when().get(Constants.BASE_URL_PETSTORE +Constants.ENDPOINT_PET+Constants.PET_ID);
        softAssert.assertEquals(response.getStatusCode(), 404, Constants.INVALID_CODE_TEXT);
        APIUtils.printResults(response);
        softAssert.assertAll();
    }
}

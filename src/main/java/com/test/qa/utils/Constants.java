package com.test.qa.utils;

import java.io.File;

public class Constants {
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_CONTENT_VAL_JSON = "application/json";
    public static final String BODY_PATH = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"requestbody"+File.separator;

    public static final String BASE_URL_WEATHER = "https://samples.openweathermap.org/";
    public static final String ENDPOINT_WEATHER = "data/2.5/weather";
    public static final String QUERY_PARAMETER = "?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";

    public static final String BASE_URL_PETSTORE = "https://petstore.swagger.io/v2/";
    public static final String ENDPOINT_PET = "pet/";
    public static final String PET_ID = "2000010020";

    public static final String RESPOINSE_CODE_TEXT = "Response Code is ";
    public static final String RESPOINSE_DATA_TEXT = "Data is ";
    public static final String RESPOINSE_TIME_TEXT = "Response Time ";

    public static final String JSON_KEY_NAME = "name";
    public static final String JSON_KEY_ID = "id";

    public static final String RESPONSE_BREAKER = "\n=============================\n";
    public static final String INVALID_CODE_TEXT = "Invalid Code";
    public static final String INVALID_NAME_TEXT = "Invalid Name";
}

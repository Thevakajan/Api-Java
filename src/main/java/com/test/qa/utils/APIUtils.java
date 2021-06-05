package com.test.qa.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class APIUtils {

    public static String readBody(String path) {
        String body = "";
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(path));
            body = new String(encoded, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
    }

    public static void printResults(Response response){
        System.out.println(Constants.RESPONSE_BREAKER);
        System.out.println(Constants.RESPOINSE_CODE_TEXT + response.getStatusCode());
        System.out.println(Constants.RESPOINSE_DATA_TEXT + response.asString());
        System.out.println(Constants.RESPOINSE_TIME_TEXT + response.time());
        System.out.println(Constants.RESPONSE_BREAKER);
    }

    public static String extractResponse(Response response, String key) {
        JSONObject obj = new JSONObject(response.asString());
        return obj.get(key).toString();
    }

    public static Object getObject(String response, Class c) {
        try {
            return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(response, c);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

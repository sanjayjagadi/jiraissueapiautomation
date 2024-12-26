package com.qa.utils;




import com.qa.constants.ApiConstants;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredUtils {

    public static RequestSpecification getRequestSpecification() {
        return RestAssured.given()
                .header("Authorization", ApiConstants.AUTH_HEADER)
                .header("Content-Type", ApiConstants.CONTENT_TYPE)
                .header("User-Agent", ApiConstants.USER_AGENT)
                .header("Accept", ApiConstants.ACCEPT);
    }

    public static Response post(String endpoint, String body) {
        return getRequestSpecification().body(body).post(endpoint);
    }

    public static Response get(String endpoint) {
        return getRequestSpecification().get(endpoint);
    }

    public static Response put(String endpoint, String body) {
        return getRequestSpecification().body(body).put(endpoint);
    }

    public static Response delete(String endpoint) {
        return getRequestSpecification().delete(endpoint);
    }
}


package com.qa.services;




import com.qa.constants.ApiConstants;
import com.qa.utils.RestAssuredUtils;

import io.restassured.response.Response;

public class ApiService {

    public static Response createIssue(String payload) {
        return RestAssuredUtils.post(ApiConstants.BASE_URL, payload);
    }

    public static Response retrieveIssue(String issueId) {
        return RestAssuredUtils.get(ApiConstants.BASE_URL + "/"+ issueId);
    }

    public static Response updateIssue(String issueId, String payload) {
        return RestAssuredUtils.put(ApiConstants.BASE_URL + "/"+ issueId, payload);
    }

    public static Response deleteIssue(String issueId) {
        return RestAssuredUtils.delete(ApiConstants.BASE_URL + "/"+ issueId);
    }
}

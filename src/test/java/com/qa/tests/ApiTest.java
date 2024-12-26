package com.qa.tests;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.services.ApiService;
import com.qa.services.RequestPayload;
import com.qa.utils.ExtentReportUtils;




public class ApiTest {
	private String issueId;

	@BeforeSuite
	public void setupReporting() {
		ExtentReportUtils.getExtentReports(); // Initialize Extent Reports
	}

	@AfterSuite
	public void teardownReporting() {
		ExtentReportUtils.flushReports(); // Finalize and flush reports
	}

	@Test(priority = 1)
	public void createIssueTest() {
		ExtentReportUtils.createTest("Create Issue Test");

		RequestPayload payload = RequestPayload.builder()
				.summary("Dynamic issue creation")
				.description("This issue was created dynamically.")
				.issueTypeName("Task")
				.labels(List.of("bug", "high-priority"))
				.build();
		

		Response response = ApiService.createIssue(RequestPayload.toJson(payload));
		Assert.assertEquals(response.statusCode(), 201);
		issueId = response.jsonPath().getString("id");
		ExtentReportUtils.getTest().pass("Issue created with ID: " + issueId);
		Assert.assertNotNull(issueId, "Issue ID is null!");
		
	}

	@Test(priority = 2, dependsOnMethods = "createIssueTest")
	public void retrieveIssueTest() {
		ExtentReportUtils.createTest("Retrieve Issue Test");

		Response response = ApiService.retrieveIssue(issueId);
		Assert.assertEquals(response.statusCode(), 200);
		ExtentReportUtils.getTest().pass("Issue retrieved successfully:" );
		   Assert.assertEquals(response.statusCode(), 200, "Issue retrieval failed!");
		   
		String retrievedSummary = response.jsonPath().getString("fields.summary");
		Assert.assertEquals(retrievedSummary, "Dynamic issue creation", "Summary mismatch for retrieved issue!");
		  

	}

	@Test(priority = 3, dependsOnMethods = "retrieveIssueTest")
	public void updateIssueTest() {
		ExtentReportUtils.createTest("Update Issue Test");

		RequestPayload payload = RequestPayload.builder()
				.summary("Updated issue summary")
				.description("This issue was updated dynamically.")
				.issueTypeName("Task")
				.labels(List.of("updated", "test-case"))
				.build();

		Response response = ApiService.updateIssue(issueId, RequestPayload.toJson(payload));
		Assert.assertEquals(response.statusCode(), 204);
		ExtentReportUtils.getTest().pass("Issue updated successfully.");
		// Retrieve the updated issue details to verify the update
		Response retrieveResponse = ApiService.retrieveIssue(issueId);
		Assert.assertEquals(retrieveResponse.statusCode(), 200, "Failed to retrieve the updated issue!");

		// Parse the response JSON
		JsonPath jsonPath = retrieveResponse.jsonPath();
		String actualSummary = jsonPath.getString("fields.summary");
		String actualDescription = jsonPath.getString("fields.description");
		String actualIssueType = jsonPath.getString("fields.issuetype.name");


		// Assertions to verify the updated values
		Assert.assertEquals(actualSummary, payload.getSummary(), "Summary did not update correctly!");
		Assert.assertEquals(actualDescription, payload.getDescription(), "Description did not update correctly!");
		Assert.assertEquals(actualIssueType, payload.getIssueTypeName(), "Issue type did not update correctly!");

	}

	@Test(priority = 4, dependsOnMethods = "updateIssueTest")
	public void deleteIssueTest() {
		ExtentReportUtils.createTest("Delete Issue Test");

		Response response = ApiService.deleteIssue(issueId);
		Assert.assertEquals(response.statusCode(), 204);
		ExtentReportUtils.getTest().pass("Issue deleted successfully.");
		  // Attempt to retrieve the deleted issue
	    Response retrieveResponse = ApiService.retrieveIssue(issueId);
	    Assert.assertEquals(retrieveResponse.statusCode(), 404, "Deleted issue still exists!");

	    // Verify the error message (if applicable, depending on API implementation)
	    String errorMessage = retrieveResponse.jsonPath().getString("errorMessages[0]");
	    Assert.assertTrue(
	        errorMessage.contains("Issue does not exist"),
	        "Unexpected error message: " + errorMessage
	    );

	    ExtentReportUtils.getTest().pass("Verified issue no longer exists after deletion.");

	}
}

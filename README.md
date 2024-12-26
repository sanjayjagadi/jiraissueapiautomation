


## jiraIssueAPI Automation framework

This RestAssured automation framework is designed for efficient API testing, 
leveraging the RestAssured library along with best practices to ensure modularity, 
reusability, and scalability. The framework incorporates utilities for reporting, 
payload management, and configuration, enabling comprehensive API test coverage.

## jiraIssueAPI Automation framework-Key Componens

## jiraIssueAPI Automation framework-ConfigReader.java


Handles reading configurations from config.properties.
Centralized configuration management for environment-specific variables.
## jiraIssueAPI Automation framework-ApiConstants.java


Contains reusable API endpoint constants.
Promotes consistency across test suites.
## jiraIssueAPI Automation framework-RequestPayload.java


Manages the dynamic creation of request payloads using pojo class and lombok annotations 
Supports dynamic and static payload structures.

## jiraIssueAPI Automation framework-ApiService.java
  
Encapsulates API interaction logic.
Supports GET, POST, PUT, DELETE, and other HTTP methods.
## jiraIssueAPI Automation framework-RestAssuredUtils.java

Provides reusable utilities for setting up RestAssured specifications and handling requests.

ExtentReportUtils.java
Integrates ExtentReports for generating comprehensive HTML reports.
## jiraIssueAPI Automation framework-ApiTest.java


Contains test cases written using TestNG.
Validates API responses and performs assertions.

config.properties

Centralized configuration file for environment-specific data such
 as base URLs, credentials, and timeout settings.
 ## jiraIssueAPI Automation Setup Instructions

 
                         Clone the Repository

                    
                   
				step 1 - git clone https://github.com/sanjayjagadi/jiraissueapiautomation.git
				step 2 - git fetch 
				step 3   git checkout master
				step 4 - mvn clean install
                step 5 - mvn test
					
## jiraIssueAPI Automation Prerequisites
             

             Java 11 or higher.
            Maven 3.6 or higher.
##  List of Frameworks/Tools Used
      
1.	Java: Programming language for developing test cases.
2.	Maven: Build tool for dependency management and test execution.
3.	TestNG: Test framework for organizing and executing test cases.
4.	Rest-Assured: For API testing, including CRUD operations and payload validation.
5.	Selenium: For UI testing and capturing screenshots of failures.
6.	ExtentReports: For detailed HTML reporting with logs and screenshots.
7.	Apache POI: For Excel-based data-driven testing 
8.	Log4j: For logging test execution details
##  Test Coverage Details
Test Coverage Details
1. API Testing
●	CRUD Operations:
○	Create Issue (POST API): Verifies issue creation functionality and response validation.
○	Retrieve Issue (GET API): Ensures the correct issue details are fetched based on the ID.
○	Update Issue (PUT API): Validates modifications to an existing issue.
○	Delete Issue (DELETE API): Confirms issue deletion and response status.
●	Error Handling:
○	Validates proper error responses for invalid requests (e.g., unauthorized access, incorrect payloads).
  

## jiraIssueAPI Automation- Run Tests

       Install Dependencies
           mvn clean install


    Execute test cases using Maven:
      mvn test

Generate Reports
ExtentReports will be generated in the target/reports folder.
## jiraIssueAPI Automation- Key Achievements

## Modular Design
      
       Encapsulation of API logic in service classes ensures reusability.
## Dynamic Payload Handling
      
      Ability to handle dynamic payloads with JSON support for various scenarios.
##  Enhanced Reporting
    
     Integrated ExtentReports for better visualization of test results.
## Environment Flexibility
      
      Configurations can be easily switched between environments.
## Framework Capabilities
	

          Supports All HTTP Methods
          Comprehensive support for GET, POST, PUT, DELETE, etc.
	  Custom Assertions
           Predefined methods for validating response status, headers, and body.
          Schema Validation
          Validates API responses against predefined JSON schemas.
           Reusable Utilities
          Includes utilities for common API tasks, such as authentication and response parsing.
          Reporting and Debugging
          Generates detailed test execution reports and captures evidence for debugging.
	
	

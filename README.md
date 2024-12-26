

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

                    git clone <repository-url>
                    cd <repository-folder>
## jiraIssueAPI Automation Prerequisites
             

             Java 11 or higher.
            Maven 3.6 or higher.

         

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

package project_management;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestProjectManagement {
    private Response response;
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Given("I am logged in as an admin user")
    public void loggedInAsAdminUser() {
        RestAssured.authentication = RestAssured.basic("zeenwang7", "970227");
    }

    @When("I create a Scrum project with given details")
    public void createScrumProject() {
        String requestBody = "{ \"key\": \"SOF\", \"name\": \"Software Sample\", \"projectTypeKey\": \"software\", \"projectTemplateKey\": \"com.pyxis.greenhopper.jira:gh-scrum-template\", \"description\": \"Example Project description\", \"lead\": \"zeenwang7\", \"assigneeType\": \"PROJECT_LEAD\", \"avatarId\": 10200 }";

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("http://localhost:8080/rest/api/2/project");
    }

    @Then("the project should be created successfully")
    public void verifyProjectCreation() {
        response.then().statusCode(201); // Assuming 201 is the status code for successful creation
    }

    @Test
    public void testCreateScrumProject() {
        loggedInAsAdminUser();
        createScrumProject();
        verifyProjectCreation();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
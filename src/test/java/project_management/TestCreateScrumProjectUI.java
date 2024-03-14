package project_management;
// AdminCreateScrumProjectTest.java

import base.Base;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCreateScrumProjectUI extends Base {
//    private WebDriver driver;
    private String baseUrl;

    @BeforeClass
    public void setUp() {
        baseUrl = "http://localhost:8080/";
        driver.navigate().to(baseUrl);
    }

    @Given("I am logged in as an admin user")
    public void loggedInAsAdminUser() {
        // Navigate to the login page
        driver.get(baseUrl + "/login.jsp");

        // Enter username and password
        WebElement usernameInput = driver.findElement(By.id("login-form-username"));
        WebElement passwordInput = driver.findElement(By.id("login-form-password"));
        WebElement loginButton = driver.findElement(By.id("login-form-submit"));

        usernameInput.sendKeys("zeenwang7");
        passwordInput.sendKeys("970227");

        // Click the login button
        loginButton.click();
    }
    @AfterClass
    public void tearDown() {
        // Close the WebDriver
        driver.quit();
    }
    @Test
    public void testCreateScrumProject() {
        // Navigate to the create project page
        loggedInAsAdminUser();
    }
}

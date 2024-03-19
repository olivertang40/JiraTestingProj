package StepDefs;

import Drivers.DriverFactory;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;

public class CommonSteps {
    private final String baseUrl = "http://localhost:8080/";
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.navigate().to(baseUrl);
    }

    @Given("I am logged in as an admin user with UI")
    public void loggedInAsAdminUser() {
        // Navigate to the login page
        if (driver == null) {
            setUp();
        }
        driver.get(baseUrl + "/login.jsp");

        // Enter username and password
        WebElement usernameInput = driver.findElement(By.id("login-form-username"));
        WebElement passwordInput = driver.findElement(By.id("login-form-password"));
        WebElement loginButton = driver.findElement(By.id("login-form-submit"));

        usernameInput.sendKeys("admin");
        passwordInput.sendKeys("12345");

        // Click the login button
        loginButton.click();
    }
}
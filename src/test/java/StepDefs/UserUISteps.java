package StepDefs;

import Drivers.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserUISteps {
    private WebDriver driver;
    private final String baseUrl = "http://localhost:8080/";

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.navigate().to(baseUrl);
    }

    @Given("I login as an admin")
    public void loggAsAdmin() {
        if (driver == null) {
            setUp();
        }
        driver.get(baseUrl + "/login.jsp");

        WebElement usernameInput = driver.findElement(By.id("login-form-username"));
        WebElement passwordInput = driver.findElement(By.id("login-form-password"));
        WebElement loginButton = driver.findElement(By.id("login-form-submit"));

        usernameInput.sendKeys("sliang");
        passwordInput.sendKeys("gqgx815");

        loginButton.click();
    }

    @When("I create a new user")
    public void iCreateANewUser() {
    }

    @Then("I can see it in user menu")
    public void iCanSeeItInUserMenu() {
    }
}

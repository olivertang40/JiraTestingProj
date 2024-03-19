package StepDefs;

import Drivers.DriverFactory;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    public void i_am_logged_in_as_an_admin_user_with_ui() {
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
    @Given("I am on the project page")
    public void i_am_on_the_project_page() {
        WebElement projectElement = driver.findElement(By.id("browse_link"));
        projectElement.click();
        WebElement allProjectElement = driver.findElement(By.id("project_view_all_link_lnk"));
        allProjectElement.click();
        // Find the link using the xpath
        WebElement testLink = driver.findElement(By.linkText("test"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", testLink);
        // Click the link
        testLink.click();
    }
}
package StepDefs;

import Drivers.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.util.List;

public class CommonSteps {
    private final String baseUrl = "http://localhost:8080/";
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.navigate().to(baseUrl);
    }

    @Given("I am logged in as an admin user with UI with password {string}")
    public void i_am_logged_in_as_an_admin_user_with_ui(String password) {
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
        passwordInput.sendKeys(password);

        // Click the login button
        loginButton.click();
    }
    @Given("I am on the project {string} page")
    public void i_am_on_the_project_page(String projectName) {
        WebElement projectElement = driver.findElement(By.id("browse_link"));
        projectElement.click();
        WebElement allProjectElement = driver.findElement(By.id("project_view_all_link_lnk"));
        allProjectElement.click();
        // Find the link using the xpath
        WebElement testLink = driver.findElement(By.linkText(projectName));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", testLink);
        // Click the link
        testLink.click();
    }

    @Given("I am on the project page on windows")
    public void i_am_on_the_project_page_win() {
        WebElement projectElement = driver.findElement(By.id("browse_link"));
        projectElement.click();
        WebElement allProjectElement = driver.findElement(By.id("project_view_all_link_lnk"));
        allProjectElement.click();
        // Find the link using the xpath
        WebElement testLink = driver.findElement(By.linkText("JiraTest"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", testLink);
        // Click the link
        testLink.click();
    }

    @Then("I Click on the project settings")
    public void i_click_on_the_project_settings() throws InterruptedException {
        // Find the elements using the class name
        WebDriverWait wait = new WebDriverWait(driver, 10); // wait up to 10 seconds
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".aui-icon.aui-icon-small.aui-iconfont-configure"), 1));
        List<WebElement> configureElements = driver.findElements(By.cssSelector(".aui-icon.aui-icon-small.aui-iconfont-configure"));
        // Get the second element
        WebElement projectSettingsElement = configureElements.get(1);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", projectSettingsElement);
        projectSettingsElement.click();
    }
}
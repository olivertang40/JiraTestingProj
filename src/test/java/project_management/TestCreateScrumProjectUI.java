package project_management;
// AdminCreateScrumProjectTest.java

import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class TestCreateScrumProjectUI{
    private String baseUrl ="http://localhost:8080/";
    private WebDriver driver;
    @Before
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
    @When("I create a Scrum project")
    public void createScrumProject() throws InterruptedException {
        WebElement projectElement = driver.findElement(By.id("browse_link"));
        projectElement.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));
        WebElement creatProjectElement = driver.findElement(By.id("project_template_create_link_lnk"));
        creatProjectElement.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));
        WebElement scrumSoftwareDevelopmentElement = driver.findElement(By.cssSelector(".template.selected[data-name='Scrum software development']"));
        scrumSoftwareDevelopmentElement.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));
        WebElement nextButton = driver.findElement(By.cssSelector(".create-project-dialog-create-button.pt-submit-button.aui-button.aui-button-primary"));
        nextButton.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));
        WebElement selectButton = driver.findElement(By.cssSelector(".template-info-dialog-create-button.pt-submit-button.aui-button.aui-button-primary"));
        selectButton.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));
        WebElement nameInput = driver.findElement(By.id("name"));
        nameInput.sendKeys("test");
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));
//        WebElement leadField = driver.findElement(By.id("lead-field"));
//        leadField.sendKeys("zeenwang7@gmail.com");
        WebElement submitButton = driver.findElement(By.cssSelector(".add-project-dialog-create-button.pt-submit-button.aui-button.aui-button-primary"));
        submitButton.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));

    }
    @Then("the project should be created successfully with UI")
    public void verifyProjectCreation() {
        WebElement projectElement = driver.findElement(By.id("browse_link"));
        projectElement.click();
        WebElement allProjectElement = driver.findElement(By.id("project_view_all_link_lnk"));
        allProjectElement.click();
        WebElement scrumElement = driver.findElement(By.xpath("//td[text()='TEST']"));
        assert scrumElement.isDisplayed();
    }
    @After
    @AfterClass
    public void tearDown() {
        // Close the WebDriver
        driver.quit();
    }
    @Test
    public void testCreateScrumProject() throws InterruptedException {
        // Navigate to the create project page
        loggedInAsAdminUser();
        createScrumProject();
        verifyProjectCreation();
    }
}

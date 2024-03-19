package StepDefs;

import Constants.TITLE;
import Constants.URL;
import Drivers.DriverFactory;
import PageObjectModel.HomePO;
import PageObjectModel.ProjectPO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CreateSprintUI {

    private final WebDriver driver;
    private HomePO homePO;
    private ProjectPO projectPO;

    public CreateSprintUI() {
        driver = DriverFactory.getDriver();
    }

    @Given("I logged in as an admin with UI")
    public void iAmloggedAsAdmin() {
        homePO = new HomePO();
        projectPO = new ProjectPO();
        driver.navigate().to(URL.Home.toString());

        // Enter username and password
        WebElement usernameInput = driver.findElement(By.id("login-form-username"));
        WebElement passwordInput = driver.findElement(By.id("login-form-password"));
        WebElement loginButton = driver.findElement(By.id("login"));

        usernameInput.sendKeys("admin");
        passwordInput.sendKeys("admin12345");

        // Click the login button
        loginButton.click();
    }

    @When("I click projects button")
    public void iClickUserManagementButton() {
        homePO.clickProjectsBtn();
    }

    @And("I click JIRATest project")
    public void iClickJIRATestProject(){
        homePO.clickJiraTestProject();
    }

    @Then("I should view backlog page")
    public void iShouldViewBacklogPage() {
        Assert.assertEquals(driver.getTitle(),
                TITLE.JIR_BOARD.toString());
        projectPO.clickBacklogBtn();
    }


    @When("I click create a new Sprint")
    public void iClickCreateANewSprint() {
        projectPO.clickCreateSprint();
    }

    @And("I click confirm create")
    public void iClickConfirmCreate() {
        projectPO.clickConfirm();
    }

    @Then("The sprint should be created successfully with UI")
    public void theSprintShouldBeCreatedSuccessfullyWithUI() {
        WebElement sprintTitle = projectPO.sprintTitle;
        Assert.assertEquals(sprintTitle.getText(),"JIR Sprint 1");
    }



}

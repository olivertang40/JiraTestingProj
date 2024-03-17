package StepDefs;

import Constants.TITLE;
import Constants.URL;
import Drivers.DriverFactory;
import PageObjectModel.AdminPO;
import PageObjectModel.HomePO;
import PageObjectModel.ProjectPO;
import ProjectManagement.TestCreateScrumProjectUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SpringManageUI {

    private final WebDriver driver;
    private HomePO homePO;
    private ProjectPO projectPO;

    public SpringManageUI() {
        driver = DriverFactory.getDriver();
    }

    @Given("I am logged in as an admin user with UI")
    public void iVisitTheHomePage() {
        TestCreateScrumProjectUI testCreateScrumProjectUI = new TestCreateScrumProjectUI();
        testCreateScrumProjectUI.loggedInAsAdminUser();
        homePO = new HomePO();
        projectPO = new ProjectPO();
        driver.navigate().to(URL.Home.toString());
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

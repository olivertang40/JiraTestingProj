package StepDefs;

import Constants.URL;
import Drivers.DriverFactory;
import PageObjectModel.HomePO;
import PageObjectModel.ProjectPO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;

import java.time.Duration;

public class MoveIssueUI {

    private final WebDriver driver;
    private HomePO homePO;
    private ProjectPO projectPO;

    public MoveIssueUI() {
        driver = DriverFactory.getDriver();
        projectPO = new ProjectPO();
        homePO = new HomePO();
    }

//    @Given("I log in and am on backlog page")
//    public void iLogInAndAmOnBacklogPage() throws InterruptedException {

//        driver.navigate().to(URL.Backlog.toString());
//        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(2));
//        projectPO.clickBacklogBtn();
//    }

    @When("I create new issue in backlog with {string}")
    public void iCreateNewIssueInBacklogWithMessage(String message) {
        projectPO.clickBacklogBtn();
        projectPO.clickCreateBacklogIssue();
        projectPO.inputBacklogIssue(message);
    }



    @And("I move it to current sprint")
    public void iMoveItToCurrentSprint() throws InterruptedException {
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(2));

        WebElement source = driver.findElement(By.xpath("//div[@class='ghx-issue-content']"));
        WebElement target = driver.findElement(By.xpath("//div[@class='ghx-onboarding-message']"));
        new Actions(driver)
                .dragAndDrop(source, target)
                .build()
                .perform();
    }

    @And("I create another issue and move to current sprint")
    public void iCreateAnotherIssueAndMoveToCurrentSprint() throws InterruptedException {
//        projectPO.clickCreateBacklogIssue();
        projectPO.inputBacklogIssue("issue 2");

        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(2));

        WebElement source = driver.findElement(By.xpath("(//div[@class='ghx-issue-content'])[2]"));
        WebElement target = driver.findElement(By.xpath("(//div[@class='ghx-issues js-issue-list ghx-has-issues'])[1]"));
        new Actions(driver)
                .dragAndDrop(source, target)
                .pause(Duration.ofSeconds(3))
                .release()
                .build()
                .perform();


    }

    @Then("The issue should be move successfully to the new sprint")
    public void theIssueShouldBeMoveSuccessfullyToTheNewSprint() {
        WebElement issueCount = driver.findElement(By.xpath("//div[@class='ghx-issue-count'][1]"));
        Assert.assertEquals(issueCount.getText(), "2 issues");

        driver.findElement(By.xpath("//button[@class='js-sprint-start aui-button aui-button-primary']")).click();
        WebElement start = driver.findElement(By.xpath("//button[@accesskey='s']"));
        start.click();
        driver.quit();
    }


    @When("I log in as developer user")
    public void iLogOutAndLogInAsDeveloperUser() {
//        homePO.clickUserHeader();
//        homePO.clickLogOut();

        driver.navigate().to(URL.Home.toString());

        // Enter username and password
        WebElement usernameInput = driver.findElement(By.id("login-form-username"));
        WebElement passwordInput = driver.findElement(By.id("login-form-password"));
        WebElement loginButton = driver.findElement(By.id("login"));

        usernameInput.sendKeys("dev");
        passwordInput.sendKeys("localhost8080");

        // Click the login button
        loginButton.click();
    }

    @And("I come to backlog page")
    public void iComeToBacklogPage() {
        driver.navigate().to(URL.Backlog.toString());
        projectPO.clickBacklogBtn();
    }

    @Then("I view all issues in the current sprint")
    public void iViewAllIssuesInTheCurrentSprint() {
        WebElement issueCount = driver.findElement(By.xpath("//div[@class='ghx-issue-count'][1]"));
        Assert.assertEquals(issueCount.getText(), "2 issues");
        driver.quit();
    }

    @When("I log in as team lead user")
    public void iLogInAsTeamLeadUser() {
        driver.navigate().to(URL.Home.toString());

        // Enter username and password
        WebElement usernameInput = driver.findElement(By.id("login-form-username"));
        WebElement passwordInput = driver.findElement(By.id("login-form-password"));
        WebElement loginButton = driver.findElement(By.id("login"));

        usernameInput.sendKeys("admin");
        passwordInput.sendKeys("localhost8080");

        // Click the login button
        loginButton.click();
    }

    @And("I come to active sprint page")
    public void iComeToActiveSprintPage() {
        driver.navigate().to(URL.Backlog.toString());
        projectPO.clickActiveSprintBtn();
    }

    @And("I end the current active sprint")
    public void iEndTheCurrentActiveSprint() {
        WebElement source = driver.findElement(By.xpath("//div[@class='m-sortable-trigger js-draggable-trigger']"));
        WebElement target = driver.findElement(By.xpath("(//li[@class='ghx-column ui-sortable'])[3]"));

        new Actions(driver)
                .dragAndDrop(source, target)
                .build()
                .perform();

        WebElement endSprintBtn = driver.findElement(By.id("ghx-complete-sprint"));
        endSprintBtn.click();

        driver.findElement(By.xpath("//button[@class='button-panel-button aui-button ghx-complete-button']")).click();
    }


    @Then("I view the sprint in completed state")
    public void iViewTheSprintInCompletedState() {
        WebElement sprintState = driver.findElement(By.xpath("//span[@class='ghx-sprint-status aui-lozenge aui-lozenge-complete ']"));
        Assert.assertEquals(sprintState.getText(), "COMPLETED");
    }

    @When("I switch to Velocity Chart")
    public void iSwitchToVelocityChart() {
        WebElement switchReport = driver.findElement(By.id("subnav-trigger-report"));
        switchReport.click();

        driver.findElement(By.xpath("//a[@data-item-id='velocityChart']")).click();

    }

    @And("I apply {int}-month report and download")
    public void iApplyMonthReportAndDownload(int arg0) {
        WebElement download = driver.findElement(By.xpath("//canvas[@data-zr-dom-id='zr_0']"));
        download.click();
        driver.quit();
    }
}

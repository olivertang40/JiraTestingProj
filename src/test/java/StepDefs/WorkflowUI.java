package StepDefs;

import Drivers.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class WorkflowUI {

    private final String baseUrl = "http://localhost:8080/";
    private final WebDriver driver = Drivers.DriverFactory.getDriver();

    @When("I create a workflow")
    public void iCreateAWorkflow() throws InterruptedException {
        //click admin menu
        WebElement adminMenu = driver.findElement(By.id("admin_menu"));
        adminMenu.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));





        //click issue button
        WebElement issueMenu = driver.findElement(By.id("admin_issues_menu"));
        issueMenu.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));





        //authenticate
        WebElement password = driver.findElement(By.id("login-form-authenticatePassword"));
        password.sendKeys("12345");
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));
        WebElement loginButton = driver.findElement(By.id("login-form-submit"));
        loginButton.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));





        //click workflow sidebar
        WebElement workflowLink = driver.findElement(By.id("workflows"));
        workflowLink.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));





        //add a new workflow
        WebElement addWorkflow = driver.findElement(By.id("add-workflow"));
        addWorkflow.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));





        //insert workflow name and description
        WebElement insertName = driver.findElement(By.id("add-workflow-newWorkflowName"));
        insertName.sendKeys("workflow3");
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));
        WebElement insertDesc = driver.findElement(By.id("add-workflow-description"));
        insertDesc.sendKeys("test to add a new workflow");
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));





        //click to add new workflow
        WebElement addButton = driver.findElement(By.id("add-workflow-submit"));
        addButton.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));






        //select and add new step: To Do
        WebElement todoStep = driver.findElement(By.xpath("//input[@name='stepName']"));
        todoStep.sendKeys("To Do");
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));

        WebElement dropdown1 = driver.findElement(By.name("stepStatus"));
        Select select1 = new Select(dropdown1);
        select1.selectByValue("10000");

        WebElement addNewStep = driver.findElement(By.id("workflow-step-add-submit"));
        addNewStep.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));






        //select and add new step: In Progress
        WebElement inProgressStep = driver.findElement(By.xpath("//input[@name='stepName']"));
        inProgressStep.sendKeys("In Progress");
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));

        WebElement dropdown2 = driver.findElement(By.name("stepStatus"));
        Select select2 = new Select(dropdown2);
        select2.selectByValue("3");

        WebElement addInp = driver.findElement(By.id("workflow-step-add-submit"));
        addInp.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));





        //select and add new step: Resolved
        WebElement resolvedStep = driver.findElement(By.xpath("//input[@name='stepName']"));
        resolvedStep.sendKeys("Resolved");
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));

        WebElement dropdown3 = driver.findElement(By.name("stepStatus"));
        Select select3 = new Select(dropdown3);
        select3.selectByValue("5");

        WebElement addResolved = driver.findElement(By.id("workflow-step-add-submit"));
        addResolved.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));





        //select and add new step: Closed
        WebElement closedStep = driver.findElement(By.xpath("//input[@name='stepName']"));
        closedStep.sendKeys("Closed");
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));

        WebElement dropdown4 = driver.findElement(By.name("stepStatus"));
        Select select4 = new Select(dropdown4);
        select4.selectByValue("6");

        WebElement addClosed = driver.findElement(By.id("workflow-step-add-submit"));
        addClosed.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));
    }

    @Then("I can see four steps")
    public void iCanSeeFourSteps() throws InterruptedException {

        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
        //driver.quit();
    }

    @When("I edit columns")
    public void iEditColumns() throws InterruptedException {
        //go to project menu
        WebElement projectButton = driver.findElement(By.id("browse_link"));
        projectButton.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));




        //go to current project
        WebElement currentProject = driver.findElement(By.id("project_current"));
        currentProject.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));




        //go to Scrum board
        WebElement activeSprint = driver.findElement(By.xpath("//a[.='Active sprints']"));
        activeSprint.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));

    }

    @Then("I can see different statuses")
    public void iCanSeeDifferentStatuses() throws InterruptedException {
        //drag and drop the column
        WebElement source = driver.findElement(By.xpath("//div[@aria-describedby='issue-10010-issue-details']"));
        WebElement target = driver.findElement(By.xpath("//li[.='Resolved: JIR-10 swimlane']"));
        Actions actions = new Actions(driver);




        // Perform drag and drop operation
        actions.dragAndDrop(source, target).build().perform();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(5));



        //logout
        WebElement userButton = driver.findElement(By.id("header-details-user-fullname"));
        userButton.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));
        WebElement logout = driver.findElement(By.id("log_out"));
        logout.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));

        //driver.quit();
    }

    @Given("I login as a dev")
    public void iLoginAsADev() {
        driver.get(baseUrl + "/login.jsp");

        WebElement usernameInput = driver.findElement(By.id("login-form-username"));
        WebElement passwordInput = driver.findElement(By.id("login-form-password"));
        WebElement loginButton = driver.findElement(By.id("login-form-submit"));

        usernameInput.sendKeys("user1");
        passwordInput.sendKeys("user1");

        loginButton.click();
    }

    @When("I change workflow status")
    public void iChangeWorkflowStatus() throws InterruptedException {

        //going to issue
        WebElement issueButton = driver.findElement(By.xpath("//a[@id='find_link']"));
        issueButton.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));



        //click JIR1
        WebElement jir1Issue = driver.findElement(By.id("issue_lnk_10000_lnk"));
        jir1Issue.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));



        //click status drop down button
        WebElement dropdown = driver.findElement(By.id("opsbar-transitions_more"));
        dropdown.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));

    }

    @Then("I can see status is changed")
    public void iCanSeeStatusIsChanged() throws InterruptedException {
        //choose progress status
        WebElement progress = driver.findElement(By.xpath("//span[.='Resolved']"));
        progress.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));

        //driver.quit();
    }

    @Given("I login as a QA user")
    public void iLoginAsAQAUser() {
        driver.get(baseUrl + "/login.jsp");

        WebElement usernameInput = driver.findElement(By.id("login-form-username"));
        WebElement passwordInput = driver.findElement(By.id("login-form-password"));
        WebElement loginButton = driver.findElement(By.id("login-form-submit"));

        usernameInput.sendKeys("user2");
        passwordInput.sendKeys("user2");

        loginButton.click();
    }

    @Then("I can see workflow has resolved and close")
    public void iCanSeeWorkflowHasResolvedAndClose() throws InterruptedException {
        //choose close status
        WebElement progress = driver.findElement(By.xpath("//span[.='Close']"));
        progress.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));

        driver.quit();
    }
}

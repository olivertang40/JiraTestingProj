package StepDefs.IssueManagement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Sleeper;

public class AssignIssueUI {
    private WebDriver driver = Drivers.DriverFactory.getDriver();
    @Then("I am on the issue page")
    public void findTheIssuePage() throws InterruptedException {
        Sleeper.SYSTEM_SLEEPER.sleep(java.time.Duration.ofSeconds(1));
        WebElement issueElement = driver.findElement(By.xpath("//a[@aria-label='Issues of test']"));
        issueElement.click();
    }
    @When("I assign the issue to the assignee with UI")
    public void assignIssueToAssignee() throws InterruptedException {
        WebElement assigneeButton = driver.findElement(By.xpath("//span[@id='assignee-val']"));
        assigneeButton.click();
        WebElement assigneeInput = driver.findElement(By.xpath("//input[@id='assignee-field']"));
        assigneeInput.sendKeys("charlie");
        Sleeper.SYSTEM_SLEEPER.sleep(java.time.Duration.ofSeconds(1));
        assigneeInput.sendKeys(Keys.ENTER);
        Sleeper.SYSTEM_SLEEPER.sleep(java.time.Duration.ofSeconds(1));
        assigneeInput.sendKeys(Keys.ENTER);
    }
    @Then("the issue should be assigned to the assignee successfully with UI")
    public void verifyIssueAssignment() {
        WebElement assigneeElement = driver.findElement(By.id("issue_summary_assignee_charlie"));
        assert assigneeElement.isDisplayed();
        driver.quit();
    }

}

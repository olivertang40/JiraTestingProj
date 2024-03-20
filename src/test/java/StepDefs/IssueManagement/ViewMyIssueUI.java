package StepDefs.IssueManagement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewMyIssueUI {
    private WebDriver driver = Drivers.DriverFactory.getDriver();
    @When("I click on the only my issue")
    public void iClickOnTheOnlyMyIssue() {
        // Write code here that turns the phrase above into concrete actions
        WebElement onlyMyIssue = driver.findElement(By.xpath("//a[normalize-space()='Only My Issues']"));
        onlyMyIssue.click();
    }
    @Then("I should see all the issues that are assigned to me")
    public void iShouldSeeAllTheIssuesThatAreAssignedToMe() {
        // Write code here that turns the phrase above into concrete actions
//        WebElement issueTable = driver.findElement(By.xpath("//table[@id='issuetable']"));
//        assert issueTable.isDisplayed();
        if (driver != null)
            driver.quit();
    }
}

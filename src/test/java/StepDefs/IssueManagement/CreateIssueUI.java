package StepDefs.IssueManagement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Sleeper;

public class CreateIssueUI {
    private WebDriver driver = Drivers.DriverFactory.getDriver();

    @When("I create an issue")
    public void createIssue() throws InterruptedException {
        WebElement backLogButton = driver.findElement(By.xpath("//a[@aria-label='Backlog of test']"));
        backLogButton.click();
        // Find the button with the text "Create issue"
//        WebElement createIssueButton = driver.findElement(By.xpath("//button[contains(text(), 'Create issue')]"));
        // Click on the button
//        createIssueButton.click();
        Sleeper.SYSTEM_SLEEPER.sleep(java.time.Duration.ofSeconds(1));
        WebElement openInDialogButton = driver.findElement(By.xpath("//button[contains(text(), 'Open in dialog')]"));
        openInDialogButton.click();
        Sleeper.SYSTEM_SLEEPER.sleep(java.time.Duration.ofSeconds(1));
//        WebElement issueType = driver.findElement(By.id("issuetype-single-select"));
//        issueType.click();
//        Sleeper.SYSTEM_SLEEPER.sleep(java.time.Duration.ofSeconds(1));
//        WebElement expandedElement = driver.findElement(By.cssSelector("#issuetype-field[aria-expanded='true']"));
//        WebElement bugType = expandedElement.findElement(By.xpath("//div[contains(text(), 'Bug')]"));
//        bugType.click();
        Sleeper.SYSTEM_SLEEPER.sleep(java.time.Duration.ofSeconds(1));
        WebElement summary = driver.findElement(By.id("summary"));
        summary.sendKeys("Test Summary");
        Sleeper.SYSTEM_SLEEPER.sleep(java.time.Duration.ofSeconds(1));
        WebElement priority = driver.findElement(By.id("priority-field"));
        priority.click();
        Sleeper.SYSTEM_SLEEPER.sleep(java.time.Duration.ofSeconds(1));
        priority.sendKeys("high");
        Sleeper.SYSTEM_SLEEPER.sleep(java.time.Duration.ofSeconds(1));
        priority.sendKeys(Keys.ENTER);
        Sleeper.SYSTEM_SLEEPER.sleep(java.time.Duration.ofSeconds(1));
        WebElement createButton = driver.findElement(By.id("create-issue-submit"));
        createButton.click();
    }

    @Then("the issue should be created successfully with UI")
    public void verifyIssueCreation() {
        WebElement issueElement = driver.findElement(By.xpath("//div[contains(text(), 'Test Summary')]"));
        assert issueElement.isDisplayed();
        driver.quit();
    }

}

package StepDefs.IssueManagement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

public class CreateIssueUI {
    private WebDriver driver = Drivers.DriverFactory.getDriver();

    @When("I create an issue")
    public void createIssue() throws InterruptedException {
        WebElement backLogButton = driver.findElement(By.xpath("//a[@aria-label='Backlog of test']"));
        backLogButton.click();
        // Find the button with the text "Create issue"
        if(driver.findElement(By.xpath("//button[contains(text(), 'Create issue')]")) != null){
            WebElement createIssueButton = driver.findElement(By.xpath("//button[contains(text(), 'Create issue')]"));
            createIssueButton.click();
        }
        // Click on the button
        Sleeper.SYSTEM_SLEEPER.sleep(java.time.Duration.ofSeconds(1));
        WebElement openInDialogButton = driver.findElement(By.xpath("//button[contains(text(), 'Open in dialog')]"));
        openInDialogButton.click();
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
        // Find the dropdown menu
        WebElement linkedIssue = driver.findElement(By.id("issuelinks-linktype"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", linkedIssue);
        // Create a new Select object
        Sleeper.SYSTEM_SLEEPER.sleep(java.time.Duration.ofSeconds(1));
        Select select = new Select(linkedIssue);
        // Select the "blocks" option
        select.selectByVisibleText("is blocked by");
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

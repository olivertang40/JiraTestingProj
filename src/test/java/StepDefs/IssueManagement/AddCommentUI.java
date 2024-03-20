package StepDefs.IssueManagement;

import Drivers.RichTextEditor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddCommentUI {
    private WebDriver driver = Drivers.DriverFactory.getDriver();
    @When("I click on the issue")
    public void iClickOnTheIssue() {
//        WebElement issue = driver.findElement(By.xpath("//div[@class='js-issue js-sortable js-parent-drag ghx-issue-compact ghx-type-10002 ghx-selected ghx-selected-primary']//div[@class='ghx-issue-content']"));
//        issue.click();
    }
    @Then("I add a comment")
    public void iAddAComment() {
        WebElement comment = driver.findElement(By.xpath("//a[@id='footer-comment-button']"));
        comment.click();
        // Switch to the iframe
        RichTextEditor editor = new RichTextEditor(driver, "tox-edit-area__iframe");
        editor.enterText("Test comment");

        WebElement addCommentButton = driver.findElement(By.xpath("//button[@id='issue-comment-add-submit']"));
        addCommentButton.click();
    }
    @Then("I should see the comment added")
    public void iShouldSeeTheCommentAdded() {
        WebElement comment = driver.findElement(By.xpath("//p[contains(text(),'Test comment')]"));
        assert comment.isDisplayed();
        driver.quit();
    }
}

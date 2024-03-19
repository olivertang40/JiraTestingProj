package StepDefs.ProjectManagement;

import Drivers.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.AfterClass;

import java.time.Duration;

public class CreateScrumProjectUI {
    private final String baseUrl = "http://localhost:8080/";
    private WebDriver driver = DriverFactory.getDriver();

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

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

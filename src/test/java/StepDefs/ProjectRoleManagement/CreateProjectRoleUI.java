package StepDefs.ProjectRoleManagement;

import Drivers.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateProjectRoleUI {
    private WebDriver driver = DriverFactory.getDriver();

    @Given("I am on the project role management page")
    public void iAmOnTheProjectRoleManagementPage() {
        WebElement element = driver.findElement(By.xpath("//a[@id='admin_menu']"));
        element.click();
        WebElement systemButton = driver.findElement(By.xpath("//a[@id='admin_system_menu']"));
        systemButton.click();
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='login-form-authenticatePassword']"));
        passwordInput.sendKeys("12345");
        WebElement confirmButton = driver.findElement(By.xpath("//button[@id='login-form-submit']"));
        confirmButton.click();
        WebElement projectRoleButton = driver.findElement(By.xpath("//a[@id='project_role_browser']"));
        projectRoleButton.click();
    }

    @When("I should create project role")
    public void iShouldCreateProjectRole() {
        WebElement roleName = driver.findElement(By.xpath("//input[@name='name']"));
        roleName.sendKeys("TestRole");
        WebElement roleDescription = driver.findElement(By.xpath("//input[@name='description']"));
        roleDescription.sendKeys("TestDescription");
        WebElement addProjectRoleButton = driver.findElement(By.xpath("//input[@id='role_submit']"));
        addProjectRoleButton.click();
    }

    @Then("I should see the project role created")
    public void iShouldSeeTheProjectRoleCreated() {
        WebElement projectRole = driver.findElement(By.xpath("//td[contains(text(), 'TestRole')]"));
        assert projectRole.isDisplayed();
        driver.quit();
    }

}

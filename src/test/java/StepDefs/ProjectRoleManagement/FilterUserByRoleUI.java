package StepDefs.ProjectRoleManagement;

import Drivers.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Sleeper;

import java.time.Duration;

public class FilterUserByRoleUI {
    private WebDriver driver = DriverFactory.getDriver();

    @When("I filter users by role {string}")
    public void iFilterUsersByRoleDeveloper(String roleName) throws InterruptedException {
        WebElement roles = driver.findElement(By.xpath("(//span[@class='css-t5emrf'])[3]"));
        roles.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(2));
        WebElement developerRole = driver.findElement(By.xpath("(//span[@class='ItemParts__Content-sc-14xek3m-5 jRBaLt'])[2]"));
        // select the option value of 'developer'
        developerRole.click();
        // click roles button again to toggle dropdown options
        roles.click();
    }

    @Then("I should see the filtered users of the role")
    public void iShouldSeeTheFilteredUsersOfTheRole() {
        WebElement userAdded = driver.findElement(By.xpath("//div[contains(text(), 'peter')]"));
        assert userAdded.isDisplayed();
        driver.quit();
    }

}
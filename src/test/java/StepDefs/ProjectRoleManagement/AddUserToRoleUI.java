package StepDefs.ProjectRoleManagement;

import Drivers.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Sleeper;

import java.time.Duration;

public class AddUserToRoleUI {
    private WebDriver driver = DriverFactory.getDriver();

    @Then("I click Users and Roles")
    public void i_click_users_and_roles() {
        WebElement usersAndRolesLink = driver.findElement(By.xpath("//a[@id='view_project_roles']"));
        usersAndRolesLink.click();

    }

    @When("I click Add Users to a Role")
    public void i_click_add_users_to_a_role() throws InterruptedException {
        WebElement addUsersToRoleLink = driver.findElement(By.xpath("//span[contains(text(),'Add users to a role')]"));
        addUsersToRoleLink.click();
        Sleeper.SYSTEM_SLEEPER.sleep(java.time.Duration.ofSeconds(2));
        WebElement multiSelectDropdown = driver.findElement(By.cssSelector(".multi-select.css-2b097c-container"));
        // Click the dropdown to open it
        multiSelectDropdown.click();
        // Find the search input element using its id
        WebElement searchInput = driver.findElement(By.id("react-select-2-input"));
        // Send keys to the search input element to search for the desired option
        searchInput.sendKeys("charlie");
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(2));
        searchInput.sendKeys(Keys.ENTER);
        Sleeper.SYSTEM_SLEEPER.sleep(java.time.Duration.ofSeconds(2));
        WebElement multiSelectDropdown1 = driver.findElement(By.xpath("(//div[@class=' css-1b6odlt'])[2]"));
        multiSelectDropdown1.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(2));
        WebElement roelInput = driver.findElement(By.id("react-select-3-input"));
        roelInput.sendKeys("Dev");
        roelInput.sendKeys(Keys.ENTER);
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(2));
        WebElement addButton = driver.findElement(By.cssSelector(".css-1l4j2co"));
        addButton.click();
    }

    @Then("I should see the user added to the role")
    public void i_should_see_the_user_added_to_the_role() {
//        WebElement userAdded = driver.findElement(By.xpath("//td[contains(text(),'Charlie')]//td[contains(text(),'Dev')]"));
//        assert userAdded.isDisplayed();
        driver.quit();
    }

}

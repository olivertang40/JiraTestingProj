package StepDefs.ProjectManagement;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Sleeper;

import java.time.Duration;

public class AddUserToProjectUI {
    //    private final String baseUrl = "http://localhost:8080/";
    private WebDriver driver = Drivers.DriverFactory.getDriver();

    @Then("I Click on the users and roles")
    public void i_click_on_the_users_and_roles() {
        // Find the element using the id
        WebElement usersAndRolesLink = driver.findElement(By.id("view_project_roles"));
        // Click the element
        usersAndRolesLink.click();
    }

    @Then("I Click on the Add Users to Role")
    public void i_click_on_the_add_users_to_role() throws InterruptedException {
        // Find the button element using its CSS class
        WebElement button = driver.findElement(By.cssSelector(".css-1yx6h60"));

        // Click the button to add users to a role
        button.click();
        // Find the multi-select dropdown element using its CSS class
        WebElement multiSelectDropdown = driver.findElement(By.cssSelector(".multi-select.css-2b097c-container"));

        // Click the dropdown to open it
        multiSelectDropdown.click();

        // Find the search input element using its id
        WebElement searchInput = driver.findElement(By.id("react-select-2-input"));

        // Send keys to the search input element to search for the desired option
        searchInput.sendKeys("charlie");
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(2));
        searchInput.sendKeys(Keys.ENTER);
        WebElement multiSelectDropdown2 = driver.findElement(By.xpath("//*[@id=\"ADD_USER_OR_GROUP_FORM\"]/div[2]/div/div"));

        // Click the dropdown to open it
        multiSelectDropdown2.click();

        // Find the option with the text "Administrators" and click it
        WebElement adminOption = driver.findElement(By.xpath("//div[text()='Administrators']"));
        adminOption.click();

        // Find the button using the class name
        WebElement addButton = driver.findElement(By.cssSelector(".css-1l4j2co"));

        // Click the button
        addButton.click();

    }

    @Then("the user should be added to the project successfully with UI")
    public void the_user_should_be_added_to_the_project_successfully() {
        WebElement userElement = driver.findElement(By.xpath("//div[text()='Charlie']"));
        assert userElement.isDisplayed();
        driver.quit();
    }
}

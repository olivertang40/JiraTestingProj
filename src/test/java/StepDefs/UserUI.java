package StepDefs;

import Drivers.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class UserUI {
    private WebDriver driver;
    private final String baseUrl = "http://localhost:8080/";

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.navigate().to(baseUrl);
    }

    @Given("I login as an admin")
    public void loggAsAdmin() {
        if (driver == null) {
            setUp();
        }
        driver.get(baseUrl + "/login.jsp");

        WebElement usernameInput = driver.findElement(By.id("login-form-username"));
        WebElement passwordInput = driver.findElement(By.id("login-form-password"));
        WebElement loginButton = driver.findElement(By.id("login-form-submit"));

        usernameInput.sendKeys("admin");
        passwordInput.sendKeys("localhost8080");

        loginButton.click();
    }

    @When("I create a new user")
    public void iCreateANewUser() throws InterruptedException {
        //Click admin menu on bar
        WebElement adminMenu = driver.findElement(By.id("admin_menu"));
        adminMenu.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));

        //choose the user management
        WebElement adminUserMenu = driver.findElement(By.id("admin_users_menu"));
        adminUserMenu.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));

        //authenticate as admin user
        WebElement authInsert = driver.findElement(By.id("login-form-authenticatePassword"));
        authInsert.sendKeys("localhost8080");
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));
        WebElement confirmButton = driver.findElement(By.id("login-form-submit"));
        confirmButton.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));

        //create a user
        WebElement createButton = driver.findElement(By.id("create_user"));
        createButton.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));

        //insert new user info
        WebElement insertEmail = driver.findElement(By.id("user-create-email"));
        insertEmail.sendKeys("user2@user.com");
        WebElement insertFullName = driver.findElement(By.id("user-create-fullname"));
        insertFullName.sendKeys("user2 user2");
        WebElement insertUsername = driver.findElement(By.id("user-create-username"));
        insertUsername.sendKeys("user2");
        WebElement insertPassword = driver.findElement(By.id("password"));
        insertPassword.sendKeys("user2");
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));


    }

    @Then("I can see it in user menu")
    public void iCanSeeItInUserMenu() throws InterruptedException {
        //click submit
        WebElement submitButton = driver.findElement(By.id("user-create-submit"));
        submitButton.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));
    }

    @When("I deactivate the user in UI")
    public void iDeactivateTheUserInUI() throws InterruptedException {
        //Click admin menu on bar
        WebElement adminMenu = driver.findElement(By.id("admin_menu"));
        adminMenu.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));

        //choose the user management
        WebElement adminUserMenu = driver.findElement(By.id("admin_users_menu"));
        adminUserMenu.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));

        //authenticate as admin user
        WebElement authInsert = driver.findElement(By.id("login-form-authenticatePassword"));
        authInsert.sendKeys("localhost8080");
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));
        WebElement confirmButton = driver.findElement(By.id("login-form-submit"));
        confirmButton.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));

        //click edit user status
        WebElement editUser = driver.findElement(By.id("edituser_link_user2"));
        editUser.click();
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));

    }

    @Then("I can see the user status changed")
    public void iCanSeeTheUserStatusChanged() throws InterruptedException {
        //checkbox to deactivate
        WebElement userStatus = driver.findElement(By.id("user-edit-active"));
        //click?
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(1));

    }
}

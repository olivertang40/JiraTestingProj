package stepDef;

import constants.URL;
import drivers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import page_object_model.LoginPO;
import project_management.TestCreateScrumProject;
import project_management.TestCreateScrumProjectUI;

public class LoginSteps {

    private final WebDriver driver;
    private LoginPO loginPO;

    public LoginSteps(){
        driver = DriverFactory.getDriver();
        loginPO = new LoginPO();
    }
    @Given("I am on the login page")
    public void i_am_on_the_login_page() throws InterruptedException {
        driver.navigate().to(URL.Home.toString());
        System.out.println("before loginPO");
        System.out.println("after loginPO");
    }

    @When("I enter the valid credential with {string} and {string}")
    public void i_enter_the_valid_credential_with_and(String username, String password) throws InterruptedException {
        Thread.sleep(4000);
        loginPO.inputUserName(username);
        loginPO.inputPassword(password);
    }

//    @Given("I logged in as admin user with UI")
//    public void i_logged_in_as_admin_user_with_UI() {
//        // Navigate to the login page
//        new TestCreateScrumProjectUI().loggedInAsAdminUser();
//        driver.get(URL.Home.toString() + "/login.jsp");
//        loginPO = new LoginPO();
//
//        // Enter username and password
//        WebElement usernameInput = driver.findElement(By.id("login-form-username"));
//        WebElement passwordInput = driver.findElement(By.id("login-form-password"));
//        WebElement loginButton = driver.findElement(By.id("login-form-submit"));
//
//        usernameInput.sendKeys("admin");
//        passwordInput.sendKeys("12345");
//
//        // Click the login button
//        loginButton.click();
//    }
//    }
    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPO.clickLoginBtn();
    }

    @Then("I should be directed to the dashboard page")
    public void i_should_be_directed_to_the_dashboard_page() {
        Assert.assertEquals(driver.getCurrentUrl(),
                "http://localhost:8080/secure/Dashboard.jspa");
    }
}

package stepDef;

import constants.URL;
import drivers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page_object_model.LoginPO;

public class LoginSteps {

    private final WebDriver driver;
    private LoginPO loginPO;

    public LoginSteps(){
        driver = DriverFactory.getDriver();
    }
    @Given("I am on the login page")
    public void i_am_on_the_login_page() throws InterruptedException {
        driver.navigate().to(URL.Home.toString());
        Thread.sleep(4000);
        loginPO = new LoginPO();
    }

    @When("I enter the valid credential with {string} and {string}")
    public void i_enter_the_valid_credential_with_and(String username, String password) throws InterruptedException {
        Thread.sleep(4000);
        loginPO.inputUserName(username);
        loginPO.inputPassword(password);
    }
    @And("click the login button")
    public void click_the_login_button() {
        loginPO.clickLoginBtn();
    }

    @Then("I should be directed to the dashboard page")
    public void i_should_be_directed_to_the_dashboard_page() {
        Assert.assertEquals(driver.getCurrentUrl(),
                "http://localhost:8080/secure/Dashboard.jspa");
    }
}

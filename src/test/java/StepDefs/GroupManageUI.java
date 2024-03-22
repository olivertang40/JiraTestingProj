package StepDefs;

import Constants.URL;
import Drivers.DriverFactory;
import PageObjectModel.AdminPO;
import PageObjectModel.HomePO;
import PageObjectModel.ProjectPO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class GroupManageUI {

    private final WebDriver driver;
    private AdminPO adminPO;
    private HomePO homePO;
    private ProjectPO projectPO;

    public GroupManageUI() {
        driver = DriverFactory.getDriver();
    }

    @Given("I visit the home page as an admin user")
    public void iVisitTheHomePage() {
        adminPO = new AdminPO();
        homePO = new HomePO();
        projectPO = new ProjectPO();
        driver.navigate().to(URL.Home.toString());
    }

    @When("I click User Management Button")
    public void iClickUserManagementButton() {
        homePO.clickDropMenu();
        homePO.clickUserManageBtn();
    }

    @And("I enter password as {string}")
    public void iEnterPasswordAsPassword(String password) {
        homePO.enterAdminCredential(password);
    }

    @Then("I should view the User Admin page")
    public void iShouldViewTheUserAdminPage() {
        Assert.assertEquals(DriverFactory.getDriver().getCurrentUrl(),
                URL.UserAdmin.toString());
    }

    @And("I click add group button")
    public void iClickAddGroupButton() {
        adminPO.addGroupBtnClick();
    }

    @And("I click edit members button")
    public void iClickEditMembersButton() {
        adminPO.editGroupMember();
    }

    @When("I click the groups")
    public void iClickTheGroups() {
        adminPO.groupsBtnClick();
    }

    @And("I enter group name as {string}")
    public void iEnterGroupNameAsGroupName(String groupName) {
        adminPO.inputGroupName(groupName);
    }

    @Then("I should see group member as {string}")
    public void iShouldSeeGroupMemberAsUserName(String username) {
        adminPO.verifyGroupMemberName(username);
    }

    @When("I visit the project page as an admin user")
    public void iVisitTheProjectPageAsAnAdminUser() {
//        iVisitTheHomePage();
//        WebElement usernameInput = driver.findElement(By.id("login-form-username"));
//        WebElement passwordInput = driver.findElement(By.id("login-form-password"));
//        WebElement loginButton = driver.findElement(By.id("login"));
//
//        usernameInput.sendKeys("admin");
//        passwordInput.sendKeys("localhost8080");
//
//        // Click the login button
//        loginButton.click();

        try{
            driver.navigate().to(URL.Backlog.toString());
            projectPO.clickBacklogBtn();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        WebElement setting = driver.findElement(By.xpath("//a[@data-tooltip='Project settings']"));
        setting.click();
    }

    @And("I filter users by project roles")
    public void iGoToManageProjectRoles() {
        WebElement projectRoles = driver.findElement(By.linkText("View Project Roles"));
        projectRoles.click();

        WebElement roles = driver.findElement(By.xpath("//button[@aria-controls='uid1']"));
        roles.click();

        WebElement developerGroup = driver.findElement(By.xpath("(//span[@role='menuitemcheckbox'])[2]"));
        developerGroup.click();

        driver.findElement(By.id("user-roles-page-container")).click();
    }

    @Then("I should view the developer role filter")
    public void iShouldViewTheDeveloperRoleFilter() {
        WebElement curFilter = driver.findElement(By.xpath("(//span[@class='css-t5emrf'])[3]"));
        Assert.assertTrue(curFilter.getText().contains("developer"));
        driver.quit();
    }
}

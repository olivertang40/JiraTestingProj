package StepDefs;

import Constants.URL;
import Drivers.DriverFactory;
import PageObjectModel.AdminPO;
import PageObjectModel.HomePO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class GroupManageUI {

    private final WebDriver driver;
    private AdminPO adminPO;
    private HomePO homePO;

    public GroupManageUI() {
        driver = DriverFactory.getDriver();
    }

    @Given("I visit the home page as an admin user")
    public void iVisitTheHomePage() {
        adminPO = new AdminPO();
        homePO = new HomePO();
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


}

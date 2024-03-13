package stepDef;

import constants.URL;
import drivers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import page_object_model.AdminPO;
import page_object_model.HomePO;

import static org.bouncycastle.cms.RecipientId.password;

public class GroupManageStepDefs {

    private AdminPO adminPO;
    private HomePO homePO;

    @Given("I visit the home page")
    public void iVisitThehomePage(){
        DriverFactory.getDriver().navigate().to(URL.Home.toString());
        homePO = new HomePO();
    }

    @When("I click User Management Button")
    public void iClickUserManagementButton(){
        homePO.clickDropMenu();
        homePO.clickUserManageBtn();
    }

    @And("I enter password as <password>")
    public void iEnterPasswordAs(String password){
        homePO.enterAdminCredential(password);
    }

    @Then("I should view the User Admin page")
    public void iShouldViewTheUserAdminPage(){
        Assert.assertEquals(DriverFactory.getDriver().getCurrentUrl(),
                URL.UserAdmin.toString());
    }

    @When("When I click the groups")
    public void iClickTheGroups(){
        adminPO = new AdminPO();
        adminPO.groupsBtnClick();
    }

    @And("I enter group name as <groupName>")
    public void iEnterGroupNameAs(String groupName){
        adminPO.inputGroupName(groupName);
    }

    @And("I click add group button")
    public void iClickAddGroupButton(){
        adminPO.addGroupBtnClick();
    }

    @And("I click edit members button")
    public void iClickEditMembersButton(){
        adminPO.editGroupMember();
    }




}

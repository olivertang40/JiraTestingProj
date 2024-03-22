package StepDefs;

import API.GroupAPI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;


public class GetUsersByRolesAPI {
    private final GroupAPI groupAPI;

    private Response response;

    public GetUsersByRolesAPI() {
        groupAPI = new GroupAPI();
    }

    @When("I get users based on roleId {int}")
    public void iGetUsersBasedOnRoleId(int roleId) {
        response = groupAPI.getUsersByRole(roleId);
    }

    @Then("The users should be fetched correctly")
    public void theUsersShouldBeFetchedCorrectly() {
        Assert.assertEquals(response.jsonPath().getString("actors[0].name"), "dev");
    }

}

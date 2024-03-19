package StepDefs;

import API.GroupAPI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;


public class AddUserToGroupAPI {
    private final GroupAPI groupAPI;

    private Response response;

    public AddUserToGroupAPI() {
        groupAPI = new GroupAPI();
    }

    @When("I add a user {string} to the new group {string}")
    public void iAddAUserToTheNewGroup(String username, String groupName) {
        response = groupAPI.addUserToGroup(username, groupName);
    }

    @Then("the user should be added to the group {string} successfully")
    public void the_user_should_be_added_to_group_successfully(String groupName) {
        Assert.assertEquals(response.jsonPath().getString("name"), groupName);
    }

}

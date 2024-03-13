package stepDef;

import api.UserAPI;
import entity.User;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.Assert;

public class UserStepDef {
    private static final ThreadLocal<User> currentUser = new ThreadLocal<>();

//    @When("I create a user with {string}, {string}, {string}, {string} and {string[]}")
//    public void ICreateAUser(String name, String password, String emailAddress, String displayName, String[] applicationKeys){
//        currentUser.set(new UserAPI().createUser(User.builder()
//                    .name(name)
//                    .password(password)
//                    .emailAddress(emailAddress)
//                    .displayName(displayName)
//                    .applicationKeys(applicationKeys)
//                    .build())
//                .then()
//                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/user-schema.json"))
//                .statusCode(201)
//                .extract().jsonPath().getObject("", User.class));
//    }
    @When("I create a user with {string}, {string}, {string}, {string} and {string[]}")
    public void iCreateAUserWithNamePasswordEmailAddressDisplayNameAndApplicationKeys(String name, String password, String emailAddress, String displayName, String[] applicationKeys) {
        currentUser.set(new UserAPI().createUser(User.builder()
                    .name(name)
                    .password(password)
                    .emailAddress(emailAddress)
                    .displayName(displayName)
                    .applicationKeys(applicationKeys)
                    .build())
                .then()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/user-schema.json"))
                .statusCode(201)
                .extract().jsonPath().getObject("", User.class));
    }
    @And("I get the user info with key")
    public void iGetTheUserInfoWithKey(){

    }

    @Then("The user info should match the {string}, [string] and {string}")
    public void theUserInfoShouldMatchTheNamePasswordEmailAddressDisplayNameAndApplicationKeys(String name, String emailAddress, String displayName) {
        Assert.assertEquals(currentUser.get().getName(), name);
        Assert.assertEquals(currentUser.get().getEmailAddress(), emailAddress);
        Assert.assertEquals(currentUser.get().getDisplayName(), displayName);
    }
}

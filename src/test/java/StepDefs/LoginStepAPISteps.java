package StepDefs;

import Entity.User;
import api.LoginAPI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class LoginStepAPISteps {

    private static final ThreadLocal<User> currentUser = new ThreadLocal<>();

    private final LoginAPI loginAPI;
    private Response response;

    public LoginStepAPISteps() {
        loginAPI = new LoginAPI();
    }

    @When("I enter valid user credential")
    public void i_enter_valid_user_credential() {
//        String requestBody = "{ \"username\": \"admin\", \"password\": \"12345\" }";
//        currentUser.set(User.builder().username(username).password(password).build());
        User admin = User.builder().username("admin").password("12345").build();

        response = loginAPI.userLogin(admin);
    }

    @Then("The response status code is 200")
    public void theResponseStatusCodeIs200() {
        if (response.getBody().asString() != null && !response.getBody().asString().isEmpty()) {
            response.then()
                    .log().body()
                    .statusCode(200);
        } else {
            System.out.println("Response body is empty or null");
        }
    }
}

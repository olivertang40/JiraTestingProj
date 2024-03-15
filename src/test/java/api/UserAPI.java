package api;
import io.restassured.response.Response;
import entity.User;
import static io.restassured.RestAssured.given;


public class UserAPI extends BaseAPI{
    public UserAPI(){requestSpec.basePath("/rest/api/2/user");}

    public Response createUser(User payload){
        Response response = given(requestSpec)
                .auth()
                .basic("sliang","gqgx815")
                .body(payload)
                .when()
                .post();
        response.then()
                .spec(responseSpec);
        return response;
    }

}

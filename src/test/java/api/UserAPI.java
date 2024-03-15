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

    public Response fetchUserDetail(String name){
        return given(requestSpec)
                .auth()
                .basic("sliang","gqgx815")
                .pathParam("name", name)
                .when()
                .get("/?key=JIRAUSER10100");
    }

    public Response changeUserStatusByName(String name){
        return given(requestSpec)
                .auth()
                .basic("sliang","gqgx815")
                .pathParam("name", name)
                .when()
                .body("{\"active\":false}")
                .put("/rest/api/2/user");
    }
}

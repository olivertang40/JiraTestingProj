package API;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class BaseAPI {

    protected RequestSpecification requestSpec = given()
            .baseUri("http://localhost:8080")
//            .auth().preemptive().basic("admin", "localhost8080")
            .contentType(ContentType.JSON)
            .log().all();

    protected ResponseSpecification responseSpec = given()
            .then()
            .response()
            .log().all()
            .time(Matchers.lessThan(10L), TimeUnit.SECONDS);

}

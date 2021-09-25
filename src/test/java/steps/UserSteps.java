package steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import models.reqresin.listusers.User;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserSteps {

    protected static final RequestSpecification REQUEST_SPEC_BUILDER = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in/api/users")
            .setContentType(ContentType.JSON)
            .build();

    public static List<User> getAllUsers() {
        return given()
                .spec(REQUEST_SPEC_BUILDER)
                .get()
                .jsonPath().getList("data", User.class);
    }
}

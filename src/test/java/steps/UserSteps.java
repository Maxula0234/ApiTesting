package steps;

import api.models.reqresin.listusers.DataItem;
import api.models.reqresin.listusers.ListUser;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserSteps {

    protected static final RequestSpecification REQUEST_SPEC_BUILDER = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in/api/users")
            .setContentType(ContentType.JSON)
            .build();

    public static List<DataItem> getAllUsers() {
        return given()
                .spec(REQUEST_SPEC_BUILDER)
                .get()
                .jsonPath().getList("data", DataItem.class);
    }
}

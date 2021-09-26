package steps;

import api.models.reqresin.listusers.DataItem;
import api.models.reqresin.resources.resourceslist.Resources;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ResourceSteps {

    protected static final RequestSpecification REQUEST_SPEC_BUILDER = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in/api/unknown")
            .setContentType(ContentType.JSON)
            .build();

    public static Resources getResourseList() {
        return given()
                .spec(REQUEST_SPEC_BUILDER)
                .get().as(Resources.class);
    }
}

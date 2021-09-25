package steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import models.Pet.Pet;

import static io.restassured.RestAssured.given;

public class PetSteps {

    protected static final RequestSpecification REQUEST_SPEC_BUILDER = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in/api/users")
            .setContentType(ContentType.JSON)
            .build();
    private static final String path = "/pet/";


    public static Pet getPetById(int idPet) {
        return given()
                .spec(REQUEST_SPEC_BUILDER.basePath(path + idPet))
                .get().jsonPath().getObject("", Pet.class);

    }
}

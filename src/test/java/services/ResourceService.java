package services;

import api.models.reqresin.resources.resourceslist.Resources;
import io.restassured.http.Cookies;

import static io.restassured.RestAssured.given;

public class ResourceService extends RestService {

    public ResourceService(Cookies cookies) {
        super(cookies);
    }

    @Override
    protected String getBasePath() {
        return "/unknown";
    }

    public Resources getAllResources() {
        return given().spec(REQUEST_SPEC)
                .get()
                .as(Resources.class);
    }

}

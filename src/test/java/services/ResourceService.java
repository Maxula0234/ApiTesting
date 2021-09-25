package services;

import api.models.reqresin.resources.resourceslist.Resources;
import io.restassured.http.Cookies;
import api.models.reqresin.listusers.User;

import java.util.List;

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
        return given().spec(REQUEST_SPEC_BUILDER)
                .get()
                .as(Resources.class);
    }

}

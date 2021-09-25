package services;

import io.restassured.http.Cookies;
import api.models.reqresin.listusers.User;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ListUserService extends RestService {

    public ListUserService(Cookies cookies) {
        super(cookies);
    }

    @Override
    protected String getBasePath() {
        return "/users";
    }
    
    public List<User> getAllUsers() {
        return given().spec(REQUEST_SPEC_BUILDER).get()
                .jsonPath().getList("data", User.class);
    }

}

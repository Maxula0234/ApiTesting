package services;

import io.restassured.http.Cookies;
import models.reqresin.ListUsers.User;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserService extends RestService {

    public UserService(Cookies cookies) {
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

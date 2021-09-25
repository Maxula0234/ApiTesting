package services;

import io.restassured.http.Cookies;
import models.ListUsers.User;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserService extends RestService {

    @Override
    protected String getBasePath() {
        return "/users";
    }

    public UserService(Cookies cookies) {
        super(cookies);
    }


    public List<User> getAllUsers() {
        return given().spec(REQUEST_SPEC_BUILDER).get()
                .jsonPath().getList("data", User.class);
    }

}

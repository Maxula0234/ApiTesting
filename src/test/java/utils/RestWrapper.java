package utils;


import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;
import models.reqresin.listusers.UserLogin;
import services.ListUserService;

import static io.restassured.RestAssured.given;

public class RestWrapper {
    public static final String BASE_URL = "https://reqres.in/api/";
    private static RequestSpecification REQUEST_SPEC_BUILDER;
    public ListUserService userService;
    private Cookies cookies;

    private RestWrapper(Cookies cookie) {
        this.cookies = cookie;
        userService = new ListUserService(cookies);
    }

    public static RestWrapper loginAs(String login, String password) {
        Cookies cookie = given().contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .basePath("/login")
                .body(new UserLogin(login, password))
                .post()
                .getDetailedCookies();
        return new RestWrapper(cookie);
    }

}

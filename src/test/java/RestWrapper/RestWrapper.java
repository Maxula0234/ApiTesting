package RestWrapper;


import api.models.reqresin.UserLogin;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import services.ListUserService;
import services.ResourceService;

import static io.restassured.RestAssured.given;

public class RestWrapper {
    public static final String BASE_URL = "https://reqres.in/api/";
//    private static RequestSpecification REQUEST_SPEC_BUILDER;

    public ListUserService userService;
    public ResourceService resources;

    private Cookies cookies;

    private RestWrapper(Cookies cookie) {
        this.cookies = cookie;
        resources = new ResourceService(cookies);
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

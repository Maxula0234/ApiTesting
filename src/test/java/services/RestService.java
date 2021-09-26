package services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;

public abstract class RestService {

    public static final String BASE_URL = "https://reqres.in/api/";
    protected static RequestSpecification REQUEST_SPEC;
    private Cookies cookies;

    protected abstract String getBasePath();

    public RestService(Cookies cookies){
        this.cookies = cookies;

        REQUEST_SPEC = new RequestSpecBuilder()
                .addCookies(cookies)
                .setBaseUri(BASE_URL)
                .setBasePath(getBasePath())
                .setContentType(ContentType.JSON)
                .build();
    }
}

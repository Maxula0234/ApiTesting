package services;

import api.models.reqresin.listusers.DataItem;
import io.restassured.http.Cookies;

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

    public List<DataItem> getAllUsers() {
        return given().spec(REQUEST_SPEC)
                .get()
                .jsonPath().getList("data",DataItem.class);
    }

}

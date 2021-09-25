import api.models.reqresin.resources.resourceslist.DataItem;
import api.utils.RestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
public class ApiTestResource extends BaseTest {


    @BeforeAll
    public static void getUsers() {
        api = RestWrapper.loginAs("eve.holt@reqres.in", "cityslicka");
        allResources = api.resources.getAllResources();
    }

    @Test
    public void checkAllRes() {
        List<DataItem> data = allResources.getData();
    }
}

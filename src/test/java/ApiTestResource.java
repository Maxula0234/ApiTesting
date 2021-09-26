import api.models.reqresin.resources.resourceslist.DataItem;
import RestWrapper.RestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import steps.ResourceSteps;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@Slf4j
public class ApiTestResource extends BaseTest {

    @BeforeAll
    public static void getResources() {
        api = RestWrapper.loginAs("eve.holt@reqres.in", "cityslicka");
        gerResources = ResourceSteps.getResourseList();
    }

    @Test
    public void checkAllRes() {
        List<DataItem> data = gerResources.getData();
        assertFalse(data.isEmpty());
    }
}

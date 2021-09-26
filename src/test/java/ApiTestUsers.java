import RestWrapper.RestWrapper;
import api.models.reqresin.listusers.DataItem;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import steps.UserSteps;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class ApiTestUsers extends BaseTest {

    @BeforeAll
    public static void getUsers() {
        api = RestWrapper.loginAs("eve.holt@reqres.in", "cityslicka");
        allUsers = UserSteps.getAllUsers();
    }

    @Test
    public void testCountUser() {
        assertEquals(6, allUsers.size());
    }

    @Test
    public void testCheckUserWithNamePositive() throws RuntimeException {
        String expectedUserName = "George";
        DataItem getUser = allUsers.stream().filter(u -> u.getFirstName().equals(expectedUserName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        assertEquals(expectedUserName, getUser.getFirstName());
    }

    @Test
    public void testCheckUserWithNameNegative() {
        String expectedName = "Byron";

        List<DataItem> getFilterName = allUsers.stream().filter(f -> f.getFirstName().equals(expectedName))
                .collect(Collectors.toList());
        assertTrue(getFilterName.isEmpty());
    }

}

import models.ListUsers.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.RestWrapper;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiTest {

    private static RestWrapper api;
    private static List<User> allUsers;

    @BeforeAll
    public static void getUsers() {
        api = RestWrapper.loginAs("eve.holt@reqres.in", "cityslicka");
        allUsers = api.userService.getAllUsers();
    }

    @Test
    public void testCountUser() {
        assertEquals(6, allUsers.size());
    }

    @Test
    public void testCheckUserWithNamePositive() throws RuntimeException {
        String expectedUserName = "George";
        User getUser = allUsers.stream().filter(u -> u.getFirstName().equals(expectedUserName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        assertEquals(expectedUserName, getUser.getFirstName());
    }

    @Test
    public void testCheckUserWithNameNegative() {
        String expectedName = "Byron";

        List<User> getFilterName = allUsers.stream().filter(f -> f.getFirstName().equals(expectedName))
                .collect(Collectors.toList());
        assertTrue(getFilterName.isEmpty());
    }

    @Test
    public void checkIdUserEqualsIdPhoto() {
        allUsers.stream().forEach(u -> {
            Path p = Paths.get(u.getAvatar());

        });
    }
}

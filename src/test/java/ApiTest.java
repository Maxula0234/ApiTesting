import lombok.extern.slf4j.Slf4j;
import models.reqresin.listusers.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.RestWrapper;

import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class ApiTest extends BaseTest {

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
            String nameFileAvatar = Paths.get(u.getAvatar()).getFileName().toString();
            assertTrue(nameFileAvatar.startsWith(String.valueOf(u.getId())));

            log.info("Пользователь " + u.getFirstName() + " имеет корректный идентификатор аватара = " + nameFileAvatar);
        });
    }
}

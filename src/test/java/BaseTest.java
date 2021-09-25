import models.ListUsers.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.RestWrapper;

import java.util.List;

public class BaseTest {
    //    Logger log = LogManager.getLogger(BaseTest.class);
    public static final Logger log = LogManager.getLogger(BaseTest.class);

    public static RestWrapper api;
    public static List<User> allUsers;
}

package util;

import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelperTest {

    private List<User> testData;
    private List<User> expected;

    @BeforeEach
    public void setUp() {
        testData = new ArrayList<>();
        expected = new ArrayList<>();
        testData.add(new User(2, "TestTwo First", "TestTwo Last", "TestTwoUser", "Manager", new Date()));
        testData.add(new User(1, "TestOne First", "TestOne Last", "TestOneUser", "Employee", new Date()));
        expected.add(new User(1, "TestOne First", "TestOne Last", "TestOneUser", "Employee", new Date()));
        expected.add(new User(2, "TestTwo First", "TestTwo Last", "TestTwoUser", "Manager", new Date()));
    }

    @Test
    @DisplayName("userDataSortingById")
    public void sortUsersTest() {
        assertEquals(expected, Helper.sortUsers(testData));
    }

    @Test
    @DisplayName("sortNullUsersTest")
    public void sortNullUsersTest() {
        assertEquals(null, Helper.sortUsers(null));
    }

}

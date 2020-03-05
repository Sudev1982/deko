package util;

import model.User;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Helper {

    public static List<User> sortUsers(List<User> userData) {
        List<User> sortedUserData = null;
        if (userData != null && userData.size() > 0) {
            sortedUserData = userData.stream()
                    .sorted(Comparator.comparingInt(User::getUser_id))
                    .collect(Collectors.toList());
        }
        return sortedUserData;
    }
}

package homework13.onlineShop.user;

import homework13.onlineShop.Storage;

import java.util.Arrays;

public class UserStorage extends Storage<User> {

    User user;

    public User getUserByUsername(String username) {
        for (int i = 0; i < getSize(); i++) {
            user = getByIndex(i);
            if (user != null && user.getName().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public User getUserByEmail(String email) {
        for (int i = 0; i < getSize(); i++) {
            user = getByIndex(i);
            if (user != null && user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public User getUserByID(String id) {
        for (int i = 0; i < getSize(); i++) {
            user = getByIndex(i);
            if (user != null && user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public User getUserByUsernamePassword(String username, String password) {
        for (int i = 0; i < getSize(); i++) {
            user = getByIndex(i);
            if (user != null && user.getName().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public boolean usernameAndPasswordExists(String username, String password) {
        if (getUserByUsernamePassword(username, password) != null) return true;
        return false;
    }
}

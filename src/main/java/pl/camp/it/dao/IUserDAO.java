package pl.camp.it.dao;

import pl.camp.it.model.User;

import java.util.List;

public interface IUserDAO {

    void saveUserToDatabase(User user);
    List<User> getAllUserFromDatabase();
}

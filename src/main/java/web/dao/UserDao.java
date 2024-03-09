package web.dao;

import web.model.User;

import javax.persistence.Query;
import java.util.List;

public interface UserDao {
    void createUser(User user);
    List<User> userList();
    User getOneUser(int id);
    void deleteUser(int id);
    void updateUser(User user);
}

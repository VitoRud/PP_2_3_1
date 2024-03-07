package web.dao;

import web.model.User;

import javax.persistence.Query;
import java.util.List;

public interface UserDao {
    public void createUser(User user);
    public List<User> userList();
    public User getOneUser(int id);
    public void deleteUser(int id);
    public void updateUser(User user);
}

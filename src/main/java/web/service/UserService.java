package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void removeUser(int id);
    List<User> userList();
    User getOneUser(int id);
    void updateUser(User user);
}

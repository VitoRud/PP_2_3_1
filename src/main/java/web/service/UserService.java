package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public void removeUser(int id);
    public List<User> userList();
    public User getOneUser(int id);
    public void updateUser(User user);
}

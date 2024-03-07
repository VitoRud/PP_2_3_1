package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDaoImp;
import web.model.User;
import  org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class UserServiceImp implements UserService{
    private final UserDaoImp userDaoImp;

    @Autowired
    public UserServiceImp(UserDaoImp userDaoImp) {
        this.userDaoImp = userDaoImp;
    }

    @Override
    public void addUser(User user) {
        userDaoImp.createUser(user);
    }

    @Override
    public void removeUser(int id) {
        userDaoImp.deleteUser(id);
    }

    @Override
    public List<User> userList() {
        return userDaoImp.userList();
    }

    @Override
    public User getOneUser(int id) {
        return userDaoImp.getOneUser(id);
    }

    @Override
    public void updateUser(User user) {
        userDaoImp.updateUser(user);
    }
}

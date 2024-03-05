package web;

import web.dao.UserDaoImp;
import web.model.User;

public class Main {
    public static void main(String[] args) {
        UserDaoImp us = new UserDaoImp();
        User user = new User("Vad","Fasdf","vsdfa@ddas.ru");
        us.createUser(user);
    }

}

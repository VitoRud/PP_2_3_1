package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class UserDaoImp {
    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Transactional
    public void deleteUser(User user) {
        entityManager.remove(user);
    }

    @Transactional
    public void updateUser(User user) {
        entityManager.remove(user);
    }

    @Transactional
    public List<User> getAllUsers(User user) {
        entityManager.remove(user);
        return null;
    }

    @Transactional
    public User getUsers(User user) {
        entityManager.remove(user);
        return null;
    }
}

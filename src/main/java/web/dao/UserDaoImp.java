package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class UserDaoImp {
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void createUser(User user) {
        entityManager.persist(user);
    }

    public List<User> userList() {
        return entityManager.createQuery("from User").getResultList();
    }

    public User getOneUser(int id) {
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.id = :identy");
        query.setParameter("identy", id);
        return (User) query.getSingleResult();
    }

    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    public void updateUser(User user){
        entityManager.merge(user);
    }

}

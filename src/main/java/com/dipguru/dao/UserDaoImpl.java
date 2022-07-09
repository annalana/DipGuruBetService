package com.dipguru.dao;

import com.dipguru.models.AbstractUser;
import com.dipguru.models.UserAdmin;
import com.dipguru.models.UserAuthor;
import com.dipguru.models.UserCustomer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void addUser(UserCustomer customer) {
        entityManager.persist(customer);
    }
    @Override
    public void addUser(UserAuthor author) {
        entityManager.persist(author);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void addAdminUser(UserAdmin admin) {
        entityManager.persist(admin);
    }
    //Дописать логику
    @Override
    public void redactUser(Long id, UserCustomer customer) {
        AbstractUser user = getUser(id);
        if (user.getClass() == UserCustomer.class) {
            UserCustomer customer1 = (UserCustomer) getUser(id);
            entityManager.merge(customer1);
        }

    }

    @Override
    public void redactUser(Long id, UserAuthor author) {
        AbstractUser user = getUser(id);
        if (user.getClass() == UserAuthor.class) {
            UserCustomer author1 = (UserCustomer) getUser(id);
            entityManager.merge(author1);
        }
    }

    @Override
    public AbstractUser getUser(Long id) {
        return entityManager.find(AbstractUser.class, id);
    }

    @Override
    public AbstractUser getUser(String username) {
        return entityManager.createQuery("select user from AbstractUser user where user.username=?1",
                AbstractUser.class).getResultList().get(0);
    }

    @Override
    public List<AbstractUser> getUserList() {
        return entityManager.createQuery("select user from AbstractUser user", AbstractUser.class).getResultList();
    }

    @Override
    public void removeUser(Long id) {
        entityManager.createQuery("delete from AbstractUser user where user.id=?1").setParameter(1, id)
                .executeUpdate();
    }
}

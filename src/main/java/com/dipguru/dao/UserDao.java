package com.dipguru.dao;

import com.dipguru.models.AbstractUser;
import com.dipguru.models.UserAdmin;
import com.dipguru.models.UserAuthor;
import com.dipguru.models.UserCustomer;

import java.util.List;

public interface UserDao {
    void addUser(UserCustomer customer);
    void addUser(UserAuthor author);
    void addAdminUser(UserAdmin admin);
    void redactUser(Long id, UserCustomer customer);
    void redactUser(Long id, UserAuthor author);
    AbstractUser getUser(Long id);
    AbstractUser getUser(String username);
    List<AbstractUser> getUserList();
    void removeUser(Long id);
}

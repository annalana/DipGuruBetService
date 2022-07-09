package com.dipguru.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class UserCustomer extends AbstractUser {
    @ManyToOne
    Role role = new Role("ROLE_ADMIN");
    @OneToMany
    List<AbstractOrder> abstractOrders;
    @OneToMany(mappedBy = "user")
    List<Contacts> contacts;


}

package com.dipguru.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class UserAdmin extends AbstractUser{
    @ManyToOne
    private Role role = new Role("ROLE_ADMIN");
}

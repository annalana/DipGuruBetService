package com.dipguru.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.List;

@Entity
public class UserAuthor extends AbstractUser{
    @ManyToOne
    private Role role = new Role("ROLE_AUTHOR");
    @OneToMany(mappedBy = "user")
    private List<Contacts> contacts;
    @OneToMany(mappedBy = "author")
    private List<Bet> bets;


}

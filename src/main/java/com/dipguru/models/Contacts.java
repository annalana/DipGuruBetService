package com.dipguru.models;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
public class Contacts {
    @Id
    Long id;
    @ManyToOne
    AbstractUser user;
    @Column
    String email;
    @Column
    String phoneNumber;
    @Column
    String address;
    @Column
    String firstName;
    @Column
    String lastName;
}

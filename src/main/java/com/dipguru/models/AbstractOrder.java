package com.dipguru.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Inheritance(
        strategy = InheritanceType.JOINED
)
public abstract class AbstractOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    UserCustomer creator;
    @Column
    String topicName;
    @Column
    LocalDateTime creationTime;
    @Column
    String annotation;

}

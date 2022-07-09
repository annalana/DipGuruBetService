package com.dipguru.models;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "bets")
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    UserAuthor author;
    @ManyToOne
    OrderTender order;
    @Column
    Integer price;
    @Column
    String text;
}

package com.dipguru.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "tenders")
public class OrderTender extends AbstractOrder {
    @OneToMany(mappedBy = "order")
    private List<Bet> bets;
}

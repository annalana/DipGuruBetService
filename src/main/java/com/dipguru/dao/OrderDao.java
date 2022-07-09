package com.dipguru.dao;

import com.dipguru.models.AbstractOrder;

public interface OrderDao {
    AbstractOrder getOrder(Long id);
    void mergeOrder(Long id, AbstractOrder order);
}

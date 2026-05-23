package com.mamezou.sample.domain;

import java.util.Optional;

import com.mamezou.sample.domain.model.Order;

public interface OrderRepository {

    Optional<Order> findByOrderNo(String no);
}

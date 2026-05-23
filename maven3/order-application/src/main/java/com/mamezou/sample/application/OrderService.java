package com.mamezou.sample.application;

import java.util.Optional;

import com.mamezou.sample.domain.OrderRepository;
import com.mamezou.sample.domain.model.Order;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    public Optional<Order> findOrder(String no) {
        return repository.findByOrderNo(no);
    }
}

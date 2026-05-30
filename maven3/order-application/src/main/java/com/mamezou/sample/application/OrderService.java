package com.mamezou.sample.application;

import java.util.Optional;

import com.mamezou.sample.domain.OrderRepository;
import com.mamezou.sample.domain.model.Order;

import lombok.RequiredArgsConstructor;

/**
 * オーダーサービス。
 */
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    /**
     * オーダーを検索する
     * @param no オーダー番号
     * @return オーダー
     */
    public Optional<Order> findOrder(String no) {
        return repository.findByOrderNo(no);
    }
}

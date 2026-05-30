package com.mamezou.sample.domain;

import java.util.Optional;

import com.mamezou.sample.domain.model.Order;

/**
 * オーダーリポジトリ。
 */
public interface OrderRepository {

    /**
     * オーダー検索。
     * @param no オーダー番号
     * @return オーダー
     */
    Optional<Order> findByOrderNo(String no);
}

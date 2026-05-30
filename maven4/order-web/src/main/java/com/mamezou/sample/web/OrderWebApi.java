package com.mamezou.sample.web;

import com.mamezou.sample.application.OrderService;
import com.mamezou.sample.domain.model.Order;

/**
 * HTTPリクエストは受け付けずmainメソッドから起動するモドキWebApiクラス。
 */
public class OrderWebApi {

    private final OrderService service;

    /**
     * コンストラクタ。
     * @param service サービス
     */
    public OrderWebApi(OrderService service) {
        this.service = service;
    }

    /**
     * オーダーを検索する。
     * @param no オーダー番号
     * @return オーダー
     */
    public Order findOrder(String no) {
        return service.findOrder(no).orElse(null);
    }
}

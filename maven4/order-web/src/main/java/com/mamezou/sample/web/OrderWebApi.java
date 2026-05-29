package com.mamezou.sample.web;

import com.mamezou.sample.application.OrderService;
import com.mamezou.sample.domain.model.Order;

// HTTPリクエストは受け付けずmainメソッドから起動するモドキWebApiクラス
public class OrderWebApi {

    private final OrderService service;

    public OrderWebApi(OrderService service) {
        this.service = service;
    }

    public Order findOrder(String no) {
        return service.findOrder(no).orElse(null);
    }
}

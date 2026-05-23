package com.mamezou.sample.domain.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    void shouldCreateOrder() {

        // geven
        String orderNo = "M0001";
        String customerName = "CUSTOMER_1";
        int productId = 101;
        int amount = 3;

        // when
        Order order = new Order(
                orderNo,
                customerName,
                productId,
                amount);

        // then
        assertThat(order.getOrderNo()).isEqualTo(orderNo);
        assertThat(order.getCustomerName()).isEqualTo(customerName);
        assertThat(order.getProductId()).isEqualTo(productId);
        assertThat(order.getAmount()).isEqualTo(amount);
    }
}

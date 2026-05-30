package com.mamezou.sample.web;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mamezou.sample.application.OrderService;
import com.mamezou.sample.domain.OrderRepository;
import com.mamezou.sample.domain.model.Order;
import com.mamezou.sample.infrastructure.FileOrderRepository;

public class OrderWebApiIntegrationTest {

    @Test
    void shouldReturnOrderWhenOrderExists() {
        // given
        OrderWebApi api = buildWebApi();

        // when
        Order result = api.findOrder("M0001");

        // then
        assertThat(result).isNotNull();
        assertThat(result.getOrderNo()).isEqualTo("M0001");
        assertThat(result.getCustomerName()).isEqualTo("お客様1号");
        assertThat(result.getProductId()).isEqualTo(101);
        assertThat(result.getAmount()).isEqualTo(3);
    }

    @Test
    void shouldReturnNullWhenOrderDoesNotExist() {
        // given
        OrderWebApi api = buildWebApi();

        // when
        Order result = api.findOrder("M9999");

        // then
        assertThat(result).isNull();
    }

    private OrderWebApi buildWebApi() {
        OrderRepository repository = new FileOrderRepository();
        OrderService service = new OrderService(repository);
        return new OrderWebApi(service);
    }
}

package com.mamezou.sample.web;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mamezou.sample.application.OrderService;
import com.mamezou.sample.domain.model.Order;

@ExtendWith(MockitoExtension.class)
class OrderWebApiTest {

    @Mock
    private OrderService service;

    @InjectMocks
    private OrderWebApi api;

    @Test
    void shouldReturnOrderWhenOrderExists() {

        // given
        String orderNo = "M0001";
        Order order = new Order(
                orderNo,
                "CUSTOMER_1",
                101,
                3
        );
        when(service.findOrder(orderNo))
                .thenReturn(Optional.of(order));

        // when
        Order result = api.findOrder(orderNo);

        // then
        assertThat(result).isEqualTo(order);
        verify(service).findOrder(orderNo);
    }

    @Test
    void shouldReturnNullWhenOrderDoesNotExist() {

        // given
        String orderNo = "M9999";
        when(service.findOrder(orderNo))
                .thenReturn(Optional.empty());

        // when
        Order result = api.findOrder(orderNo);

        // then
        assertThat(result).isNull();
        verify(service).findOrder(orderNo);
    }
}
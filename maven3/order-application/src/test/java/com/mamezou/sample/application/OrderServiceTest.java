package com.mamezou.sample.application;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mamezou.sample.domain.OrderRepository;
import com.mamezou.sample.domain.model.Order;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository repository;

    @InjectMocks
    private OrderService service;

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
        when(repository.findByOrderNo(orderNo))
                .thenReturn(Optional.of(order));

        // when
        Optional<Order> result = service.findOrder(orderNo);

        // then
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(order);
        verify(repository).findByOrderNo(orderNo);
    }

    @Test
    void shouldReturnEmptyWhenOrderDoesNotExist() {

        // given
        String orderNo = "M9999";
        when(repository.findByOrderNo(orderNo))
                .thenReturn(Optional.empty());

        // when
        Optional<Order> result = service.findOrder(orderNo);

        // then
        assertThat(result).isEmpty();
        verify(repository).findByOrderNo(orderNo);
    }
}
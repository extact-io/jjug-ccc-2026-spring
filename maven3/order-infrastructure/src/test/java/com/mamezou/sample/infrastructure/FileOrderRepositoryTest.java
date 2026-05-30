package com.mamezou.sample.infrastructure;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.mamezou.sample.domain.model.Order;

public class FileOrderRepositoryTest {

    @Test
    void shouldFindOrderByOrderNo() {

        // given
        FileOrderRepository repository = new FileOrderRepository("/order_test.csv");

        // when
        Optional<Order> result = repository.findByOrderNo("M0001");

        // then
        assertThat(result).isPresent();

        Order order = result.orElseThrow();
        assertThat(order.getOrderNo()).isEqualTo("M0001");
        assertThat(order.getCustomerName()).isEqualTo("CUSTOMER_1");
        assertThat(order.getProductId()).isEqualTo(101);
        assertThat(order.getAmount()).isEqualTo(3);
    }

    @Test
    void shouldReturnEmptyWhenOrderDoesNotExist() {

        // given
        FileOrderRepository repository = new FileOrderRepository("/order_test.csv");

        // when
        Optional<Order> result = repository.findByOrderNo("M9999");

        // then
        assertThat(result).isEmpty();
    }
}

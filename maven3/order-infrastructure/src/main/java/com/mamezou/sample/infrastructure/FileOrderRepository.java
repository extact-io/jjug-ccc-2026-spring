package com.mamezou.sample.infrastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.mamezou.sample.domain.OrderRepository;
import com.mamezou.sample.domain.model.Order;

public class FileOrderRepository implements OrderRepository {

    private Map<String, Order> orderMap;

    public FileOrderRepository() {
       try {
           initLoad();
       } catch (IOException e) {
           throw new IllegalStateException(e);
       }
    }

    @Override
    public Optional<Order> findByOrderNo(String no) {
        return Optional.ofNullable(orderMap.get(no));
    }

    private void initLoad() throws IOException {

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        getClass().getResourceAsStream("/order.csv"),
                        StandardCharsets.UTF_8))) {

            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(reader);

            orderMap = StreamSupport.stream(records.spliterator(), false)
                    .collect(Collectors.toMap(
                            r -> r.get(0),
                            this::mapToOrder));
        }
    }

    private Order mapToOrder(CSVRecord record) {
        return new Order(
                record.get(0),
                record.get(1),
                Integer.parseInt(record.get(2)),
                Integer.parseInt(record.get(3)) //
        );
    }
}

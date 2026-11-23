package com.example.mcpserverwebmvc.service;

import com.example.mcpserverwebmvc.model.Order;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderService {

    private final Map<Long, Order> orders = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(123);

    public OrderService() {
        orders.put(123L, new Order(123L, "Alice", 1, "CREATED"));
    }

    public Optional<Order> findById(long id) {
        return Optional.ofNullable(orders.get(id));
    }

}

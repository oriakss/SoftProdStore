package com.softprod.repositories;

import com.softprod.entities.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.softprod.utils.Constants.DEFAULT_ID;
import static com.softprod.utils.Constants.ONE_STEP;

public class OrderRepositoryImpl implements OrderRepository {

    private static OrderRepository orderRepository;
    private final List<Order> orders = new ArrayList<>();

    @Override
    public Optional<Order> createOrder(Order order) {
        if (orders.isEmpty()) {
            order.setId(DEFAULT_ID);
        } else {
            order.setId(orders.get(orders.size() - ONE_STEP).getId() + DEFAULT_ID);
        }
        orders.add(order);
        return Optional.of(order);
    }

    @Override
    public Optional<List<Order>> readOrders() {
        return Optional.of(orders);
    }

    @Override
    public Optional<Order> updateOrder(Long orderId) {
        return orders.stream()
                .filter(item -> Objects.equals(item.getId(), orderId))
                .findAny();
    }

    @Override
    public Optional<Order> deleteOrder(Long orderId) {
        Order order = orders.stream()
                .filter(item -> Objects.equals(item.getId(), orderId))
                .findAny()
                .orElseThrow();
        orders.remove(order);
        return Optional.of(order);
    }

    public static OrderRepository getInstance() {
        if (orderRepository == null) {
            orderRepository = new OrderRepositoryImpl();
        }
        return orderRepository;
    }

    private OrderRepositoryImpl() {
        orders.add(new Order(1L, null, 1000, 7, "done"));
        orders.add(new Order(2L, null, 2300, 14, "canceled"));
        orders.add(new Order(3L, null, 5000, 4, "processing"));
        orders.add(new Order(4L, null, 6600, 8, "processing"));
        orders.add(new Order(5L, null, 1200, 5, "done"));
    }
}
package com.softprod.repositories;

import com.softprod.entities.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OrderRepositoryImpl implements OrderRepository {

    private static OrderRepository orderRepository;

    private final List<Order> orders = new ArrayList<>();

    private OrderRepositoryImpl() {
        orders.add(new Order(1L, null, 1000, 7, "done"));
        orders.add(new Order(2L, null, 2300, 14, "canceled"));
        orders.add(new Order(3L, null, 5000, 4, "processing"));
        orders.add(new Order(4L, null, 6600, 8, "processing"));
        orders.add(new Order(5L, null, 1200, 5, "done"));
    }

    @Override
    public Optional<Order> createOrder(Order order) {
        if (orders.isEmpty()) {
            order.setId(1L);
        } else {
            order.setId(orders.get(orders.size() - 1).getId() + 1);
        }
        orders.add(order);
        return Optional.of(order);
    }

    @Override
    public Optional<List<Order>> readOrders() {
        return Optional.of(orders);
    }

    @Override
    public Optional<Order> updateOrder(Order order) {
        Order oldStatusOrder = orders.stream()
                .filter(item -> Objects.equals(item.getId(), order.getId()))
                .findAny().orElseThrow();
        oldStatusOrder.setStatus(order.getStatus());
        return Optional.of(oldStatusOrder);

    }

    @Override
    public Optional<Order> deleteOrder(Order order) {
        Order delOrder = orders.stream()
                .filter(item -> Objects.equals(item.getId(), order.getId()))
                .findAny().orElseThrow();
        orders.remove(delOrder);
        return Optional.of(delOrder);
    }

    public static OrderRepository getInstance() {
        if (orderRepository == null) {
            orderRepository = new OrderRepositoryImpl();
        }
        return orderRepository;
    }
}

package com.softprod.services;

import com.softprod.entities.Order;
import com.softprod.repositories.OrderRepository;
import com.softprod.repositories.OrderRepositoryImpl;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private static OrderService orderService;

    private final OrderRepository orderRepository = OrderRepositoryImpl.getInstance();

    private OrderServiceImpl() {}

    @Override
    public Order createOrder(Order order) {
        return orderRepository.createOrder(order).orElseThrow();
    }

    @Override
    public List<Order> readOrders() {
        return orderRepository.readOrders().orElseThrow();
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.updateOrder(order).orElseThrow();
    }

    @Override
    public Order deleteOrder(Order order) {
        return orderRepository.deleteOrder(order).orElseThrow();
    }

    public static OrderService getInstance() {
        if (orderService == null) {
            orderService = new OrderServiceImpl();
        }
        return orderService;
    }
}

package com.softprod.services;

import com.softprod.entities.Order;
import com.softprod.repositories.OrderRepository;
import com.softprod.repositories.OrderRepositoryImpl;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private static OrderService orderService;
    private final OrderRepository orderRepository = OrderRepositoryImpl.getInstance();

    @Override
    public Order createOrder(Order order) {
        return orderRepository.createOrder(order).orElseThrow();
    }

    @Override
    public List<Order> readOrders() {
        return orderRepository.readOrders().orElseThrow();
    }

    @Override
    public Order updateOrder(Long orderId, String status) {
        Order order = orderRepository.updateOrder(orderId).orElseThrow();
        order.setStatus(status);
        return order;
    }

    @Override
    public Order deleteOrder(Long orderId) {
        return orderRepository.deleteOrder(orderId).orElseThrow();
    }

    public static OrderService getInstance() {
        if (orderService == null) {
            orderService = new OrderServiceImpl();
        }
        return orderService;
    }

    private OrderServiceImpl() {
    }
}
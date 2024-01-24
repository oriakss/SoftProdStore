package com.softprod.services;

import com.softprod.entities.Order;
import com.softprod.entities.OrderStatus;
import com.softprod.repositories.OrderRepository;
import com.softprod.repositories.OrderRepositoryImpl;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private static OrderService orderService;
    private final OrderRepository orderRepository = OrderRepositoryImpl.getInstance();

    @Override
    public void createOrder(Order order) {
        orderRepository.createOrder(order).orElseThrow();
    }

    @Override
    public List<Order> readOrders() {
        return orderRepository.readOrders().orElseThrow();
    }

    @Override
    public void updateOrder(Long orderId, OrderStatus status) {
        orderRepository.updateOrder(orderId, status).orElseThrow();
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteOrder(orderId).orElseThrow();
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
package com.softprod.services;

import com.softprod.entities.Order;

import java.util.List;

public interface OrderService {

    void createOrder(Order order);

    List<Order> readOrders();

    void updateOrder(Long orderId, String status);

    void deleteOrder(Long orderId);
}
package com.softprod.services;

import com.softprod.entities.Order;
import com.softprod.entities.OrderStatus;

import java.util.List;

public interface OrderService {

    void createOrder(Order order);

    List<Order> readOrders();

    void updateOrder(Long orderId, OrderStatus status);

    void deleteOrder(Long orderId);
}
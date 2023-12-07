package com.softprod.services;

import com.softprod.entities.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(Order order);

    List<Order> readOrders();

    Order updateOrder(Long orderId, String status);

    Order deleteOrder(Long orderId);
}
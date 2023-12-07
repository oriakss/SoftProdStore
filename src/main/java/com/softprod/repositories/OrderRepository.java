package com.softprod.repositories;

import com.softprod.entities.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    Optional<Order> createOrder(Order order);

    Optional<List<Order>> readOrders();

    Optional<Order> updateOrder(Long orderId);

    Optional<Order> deleteOrder(Long orderId);
}
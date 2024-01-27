package com.softprod.repositories;

import com.softprod.entities.Order;
import com.softprod.entities.OrderStatus;
import com.softprod.mappers.OrderMapper;
import com.softprod.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.softprod.entities.OrderStatus.*;
import static com.softprod.utils.Constants.*;

public class OrderRepositoryImpl implements OrderRepository {

    private static OrderRepository orderRepository;
    private final EntityManager entityManager = JPAUtil.getEntityManager();
    private final EntityTransaction transaction = entityManager.getTransaction();
    private final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    private List<Order> orders;

    @Override
    public Optional<Order> createOrder(Order order) {
        transaction.begin();
        entityManager.persist(order);

        CriteriaQuery<Long> orderCriteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<Order> orderRoot = orderCriteriaQuery.from(Order.class);

        orderCriteriaQuery
                .select(orderRoot.get(ID))
                .where(criteriaBuilder.equal(orderRoot.get(ORDER_UUID), order.getUuid()));
        Long orderId = entityManager
                .createQuery(orderCriteriaQuery)
                .getResultList()
                .stream()
                .findAny()
                .orElseThrow();

        transaction.commit();

        order.setId(orderId);
        orders.add(order);
        return Optional.of(order);
    }

    @Override
    public Optional<List<Order>> readOrders() {
        if (orders == null || orders.isEmpty()) {
            transaction.begin();

            CriteriaQuery<Order> orderCriteriaQuery = criteriaBuilder.createQuery(Order.class);
            Root<Order> orderRoot = orderCriteriaQuery.from(Order.class);

            orderCriteriaQuery.select(orderRoot);
            orders = entityManager.createQuery(orderCriteriaQuery).getResultList();

            transaction.commit();
        }
        return Optional.of(orders);
    }

    @Override
    public Optional<Order> updateOrder(Long orderId, OrderStatus status) {
        transaction.begin();

        CriteriaUpdate<Order> orderCriteriaUpdate = criteriaBuilder.createCriteriaUpdate(Order.class);
        Root<Order> orderRoot = orderCriteriaUpdate.from(Order.class);

        orderCriteriaUpdate
                .set(ORDER_STATUS, status)
                .where((criteriaBuilder.equal(orderRoot.get(ID), orderId)));
        entityManager.createQuery(orderCriteriaUpdate).executeUpdate();

        transaction.commit();

        Order order = orders.stream()
                .filter(item -> Objects.equals(item.getId(), orderId))
                .findAny()
                .orElseThrow();
        order.setStatus(status);
        return Optional.of(order);
    }

    @Override
    public Optional<Order> deleteOrder(Long orderId) {
        transaction.begin();

        CriteriaDelete<Order> orderCriteriaDelete = criteriaBuilder.createCriteriaDelete(Order.class);
        Root<Order> orderRootDelete = orderCriteriaDelete.from(Order.class);

        orderCriteriaDelete.where(criteriaBuilder.equal(orderRootDelete.get(ID), orderId));
        entityManager.createQuery(orderCriteriaDelete).executeUpdate();

        transaction.commit();

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
        if (readOrders().orElseThrow().isEmpty()) {
            OrderMapper orderMapper = OrderMapper.getInstance();
            transaction.begin();

            entityManager.persist(orderMapper.buildOrderManually(new BigDecimal(2300), 14, CANCELED));
            entityManager.persist(orderMapper.buildOrderManually(new BigDecimal(5000), 4, IN_PROCESS));
            entityManager.persist(orderMapper.buildOrderManually(new BigDecimal(6600), 8, IN_PROCESS));
            entityManager.persist(orderMapper.buildOrderManually(new BigDecimal(1200), 5, COMPLETE));

            transaction.commit();
        }
    }
}
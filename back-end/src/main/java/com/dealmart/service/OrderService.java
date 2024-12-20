package com.dealmart.service;

import com.dealmart.model.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);

    List<Order> getAllOrders();

    Order getOrderById(long id);

    Order updateOrder(Order order, long id);

    void deleteOrder(long id);
}

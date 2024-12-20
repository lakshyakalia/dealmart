package com.dealmart.service;

import com.dealmart.model.OrderItem;

import java.util.List;

public interface OrderItemService {
    OrderItem createOrderItem(OrderItem orderItem);

    List<OrderItem> getAllOrderItems();

    OrderItem getOrderItemById(long id);

    OrderItem updateOrderItem(OrderItem orderItem, long id);

    void deleteOrderItem(long id);
}

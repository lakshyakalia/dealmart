package com.dealmart.service.impl;

import com.dealmart.exception.ResourceNotFoundException;
import com.dealmart.model.OrderItem;
import com.dealmart.repository.OrderItemRepository;
import com.dealmart.service.OrderItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private OrderItemRepository orderItemRepository;


    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem getOrderItemById(long id) {
        return orderItemRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Order Item", "Id", id));
    }

    @Override
    public OrderItem updateOrderItem(OrderItem orderItem, long id) {
        OrderItem existingOrderItem = orderItemRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Order Item", "Id", id));
        existingOrderItem.setOrder(orderItem.getOrder());
        existingOrderItem.setProduct(orderItem.getProduct());
        existingOrderItem.setQuantity(orderItem.getQuantity());
        existingOrderItem.setTotalPrice(orderItem.getTotalPrice());

        return existingOrderItem;
    }

    @Override
    public void deleteOrderItem(long id) {
        orderItemRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Order Item", "Id", id));
        orderItemRepository.deleteById(id);
    }
}

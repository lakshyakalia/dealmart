package com.dealmart.service.impl;

import com.dealmart.exception.ResourceNotFoundException;
import com.dealmart.model.Order;
import com.dealmart.repository.OrderRepository;
import com.dealmart.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        super();
        this.orderRepository = orderRepository;
    }


    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(long id) {
        return orderRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Order", "Id", id));
    }

    @Override
    public Order updateOrder(Order order, long id) {
        Order existingOrder = orderRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Order", "Id", id));
        existingOrder.setUser(order.getUser());
        existingOrder.setOrderItems(order.getOrderItems());
        existingOrder.setTotalPrice(order.getTotalPrice());
        existingOrder.setDate(order.getDate());
        return existingOrder;
    }

    @Override
    public void deleteOrder(long id) {
        orderRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Order", "Id", id));
        orderRepository.deleteById(id);
    }
}

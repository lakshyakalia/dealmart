package com.dealmart.controller;

import com.dealmart.model.Order;
import com.dealmart.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        super();
        this.orderService = orderService;
    }

    @PostMapping()
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        return new ResponseEntity<Order>(orderService.createOrder(order), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") long orderId){
        return new ResponseEntity<Order>(orderService.getOrderById(orderId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") long orderId, @RequestBody Order order){
        return new ResponseEntity<Order>(orderService.updateOrder(order, orderId), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") long orderId) {
        orderService.deleteOrder(orderId);
        return new ResponseEntity<String>("Order Deleted Successfully!", HttpStatus.OK);
    }
}

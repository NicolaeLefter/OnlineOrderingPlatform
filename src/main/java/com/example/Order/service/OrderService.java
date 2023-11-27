package com.example.Order.service;

import com.example.Order.entity.Order;
import com.example.Order.orderRepository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired

    OrderRepository orderRepository;


    public ResponseEntity<Object> getOrderById(Integer idOrder) {
        orderRepository.findById(idOrder);
        return ResponseEntity.ok("Order find succesfull!");
    }

    public ResponseEntity<Object> getAllOrder() {

        return ResponseEntity.status(HttpStatus.OK).body(orderRepository.findAll());
    }

    public ResponseEntity<Object> placedOrder(Order order){
        order.setOrderDate(new Date());
        order.setStatus("Placed");
        orderRepository.save(order);
        return ResponseEntity.ok("Order placed succesfull!");
    }
    public ResponseEntity<Object> cancelOrder(Integer idOrder){
        Optional<Order> orderOptional = orderRepository.findById(idOrder);
        if (orderOptional.isPresent()){
            Order order = orderOptional.get();
            order.setStatus("Cancelled!");
            orderRepository.save(order);
        }
        return ResponseEntity.ok("Cancelled order succesfull!");

    }

    public ResponseEntity<Object> completeOrder(Integer idOrder){
        Optional<Order> optionalOrder = orderRepository.findById(idOrder);
        if (optionalOrder.isPresent()){
            Order order = optionalOrder.get();
            order.setStatus("Completed!");
            orderRepository.save(order);
        }
        return ResponseEntity.ok("Order completed succesfull!");
    }
}

package com.example.Order.controller;

import com.example.Order.entity.Order;
import com.example.Order.orderRepository.OrderRepository;
import com.example.Order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/order")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderService orderService;

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getAllOrder());
    }

    @GetMapping("/getById/{idOrder}")
    public ResponseEntity<Object> getByIdOreder(@PathVariable Integer idOrder) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrderById(idOrder));
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<Object> placedOrder(@RequestBody Order order) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.placedOrder(order));
    }

    @PutMapping("/canceledOrder/{idOrder}")

    public ResponseEntity<Object> canceledOrder(@PathVariable Integer idOrder) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.cancelOrder(idOrder));
    }

    @PutMapping("/complectedOrder/{idOrder}")

    public ResponseEntity<Object> complectedOrder(@PathVariable Integer idOrder){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.completeOrder(idOrder));
    }


}

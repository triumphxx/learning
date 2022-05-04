package com.triumphxx.consumer.controller;


import com.triumphxx.consumer.entity.OrderBase;
import com.triumphxx.consumer.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/create-order")
    public void createOrder(@RequestBody OrderBase order) throws MQClientException {
        orderService.createOrder(order);
    }
}
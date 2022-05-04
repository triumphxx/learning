package com.triumphxx.consumer.service.impl;

import com.alibaba.fastjson.JSON;
import com.triumphxx.consumer.config.TransactionProducer;
import com.triumphxx.consumer.dao.OrderBaseDao;
import com.triumphxx.consumer.dao.TransactionLogDao;
import com.triumphxx.consumer.entity.OrderBase;
import com.triumphxx.consumer.entity.TransactionLog;
import com.triumphxx.consumer.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderBaseDao orderMapper;
    @Autowired
    TransactionLogDao transactionLogMapper;
    @Autowired
    TransactionProducer producer;

//    Snowflake snowflake = new Snowflake(1,1);

    //执行本地事务时调用，将订单数据和事务日志写入本地数据库
    @Transactional
    @Override
    public void createOrder(OrderBase order, String transactionId) throws InvocationTargetException, IllegalAccessException {

        //1.创建订单
        Long no = Math.round((Math.random() + 1) * 1000);
        String orderNo = String.valueOf(no);
        int id = no.intValue();
        order.setId(id);
        order.setOrderNo(orderNo);
        orderMapper.insert(order);

        //2.写入事务日志
        TransactionLog log = new TransactionLog();
        log.setId(transactionId);
        log.setBusiness("order");
        log.setForeignKey(String.valueOf(order.getId()));
        transactionLogMapper.insert(log);

    }

    //前端调用，只用于向RocketMQ发送事务消息
    @Override
    public void createOrder(OrderBase order) throws MQClientException {
        long no = Math.round((Math.random() + 1) * 1000);
        String orderNo = String.valueOf(no);

        order.setOrderNo(orderNo);
        producer.send(JSON.toJSONString(order), "order");
    }
}
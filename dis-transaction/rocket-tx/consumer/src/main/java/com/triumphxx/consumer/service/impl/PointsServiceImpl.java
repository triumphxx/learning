package com.triumphxx.consumer.service.impl;

import com.triumphxx.consumer.dao.TblPointsDao;
import com.triumphxx.consumer.entity.OrderBase;
import com.triumphxx.consumer.entity.TblPoints;
import com.triumphxx.consumer.service.PointsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PointsServiceImpl implements PointsService {

    @Autowired
    TblPointsDao pointsMapper;

    @Override
    public void increasePoints(OrderBase order) {

        //入库之前先查询，实现幂等
//        if (pointsMapper.getByOrderNo(order.getOrderNo())>0){
//            log.info("积分添加完成，订单已处理。{}",order.getOrderNo());
//        }else{
        Long no = Math.round((Math.random() + 1) * 1000);

        TblPoints points = new TblPoints();
        points.setId(no.intValue());
        points.setUserId("1");
        points.setOrderNo("wo");
        points.setPoints("10");
        points.setRemarks("products is " + points.getPoints());
        pointsMapper.insert(points);
        log.info("已为订单号码{}增加积分。", points.getOrderNo());
//        }
    }
}
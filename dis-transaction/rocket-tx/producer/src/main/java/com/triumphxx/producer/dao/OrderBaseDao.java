package com.triumphxx.producer.dao;

import com.triumphxx.producer.entity.OrderBase;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderBaseDao {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderBase record);

    int insertSelective(OrderBase record);

    OrderBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderBase record);

    int updateByPrimaryKey(OrderBase record);
}
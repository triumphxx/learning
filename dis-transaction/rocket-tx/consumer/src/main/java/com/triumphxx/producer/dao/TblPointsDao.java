package com.triumphxx.producer.dao;

import com.triumphxx.producer.entity.TblPoints;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TblPointsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TblPoints record);

    int insertSelective(TblPoints record);

    TblPoints selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TblPoints record);

    int updateByPrimaryKey(TblPoints record);
}
package com.triumphxx.lcnorder.dao;

import com.triumphxx.lcnorder.bean.TOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TOrderDao {
    int insert(TOrder record);

    int insertSelective(TOrder record);

    int deleteByPrimaryKey(Integer id);
}
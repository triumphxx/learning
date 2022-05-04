package com.triumphxx.lcnpay.dao;

import com.triumphxx.lcnpay.bean.TPay;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TPayDao {
    int insert(TPay record);

    int insertSelective(TPay record);

    int deleteByPrimaryKey(Integer id);
}
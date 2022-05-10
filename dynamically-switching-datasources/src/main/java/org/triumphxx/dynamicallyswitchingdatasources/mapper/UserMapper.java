package org.triumphxx.dynamicallyswitchingdatasources.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select count(*) from lduser")
    Integer count();
}

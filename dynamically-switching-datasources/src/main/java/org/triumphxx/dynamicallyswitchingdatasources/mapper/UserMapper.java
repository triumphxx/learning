package org.triumphxx.dynamicallyswitchingdatasources.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.triumphxx.dynamicallyswitchingdatasources.model.User;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select count(*) from user")
    Integer count();

    @Select("Select * from user")
    List<User> getUsers();
}

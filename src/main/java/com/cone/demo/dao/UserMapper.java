package com.cone.demo.dao;


import com.cone.demo.model.bo.User;
import com.cone.utils.mybatisConfig.MyMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by pactera on 2017/2/7.
 */
@Mapper
public interface UserMapper extends MyMapper<User> {
    //@Insert("insert into t_user(username,age) values(#{userName,jdbcType=VARCHAR},#{age,jdbcType=NUMERIC})")
    public int save(User user);

    User selectById(Integer id);

    int updateById(User user);

    int deleteById(Integer id);
    //@Select("select * from t_user")
    List<User> queryAll();
}

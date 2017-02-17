package com.cone.demo.dao;


import com.cone.demo.model.bo.User;
import com.cone.utils.mybatisConfig.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by pactera on 2017/2/7.
 */
@Mapper
public interface UserMapper extends MyMapper<User> {
    //@Insert("insert into t_user(username,age) values(#{userName,jdbcType=VARCHAR},#{age,jdbcType=NUMERIC})")
    public int _save(User user);

    User _selectById(Integer id);

    int _updateById(User user);

    int _deleteById(Integer id);
    
    List<User> _queryAll();
}

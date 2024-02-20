package com.example.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.mybatisflex.core.BaseMapper;
import com.example.mybatis.entity.User;

/**
 *  映射层。
 *
 * @author bill
 * @since 2024-02-20
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

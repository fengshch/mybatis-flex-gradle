package com.example.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.mybatisflex.core.BaseMapper;
import com.example.mybatis.entity.Users;

/**
 *  映射层。
 *
 * @author bill
 * @since 2024-05-30
 */
@Mapper
public interface UsersMapper extends BaseMapper<Users> {

}

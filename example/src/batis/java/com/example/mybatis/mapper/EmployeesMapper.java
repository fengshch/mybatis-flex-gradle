package com.example.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.mybatisflex.core.BaseMapper;
import com.example.mybatis.entity.Employees;

/**
 *  映射层。
 *
 * @author bill
 * @since 2023-09-11
 */
@Mapper
public interface EmployeesMapper extends BaseMapper<Employees> {

}

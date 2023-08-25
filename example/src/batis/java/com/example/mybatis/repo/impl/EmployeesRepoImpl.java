package com.example.mybatis.repo.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.example.mybatis.entity.Employees;
import com.example.mybatis.mapper.EmployeesMapper;
import com.example.mybatis.repo.EmployeesRepo;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author bill
 * @since 2023-08-25
 */
@Service
public class EmployeesRepoImpl extends ServiceImpl<EmployeesMapper, Employees> implements EmployeesRepo {

}

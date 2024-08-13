package com.example.mybatis.repo.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.example.mybatis.po.OrdersPO;
import com.example.mybatis.mapper.OrdersMapper;
import com.example.mybatis.repo.OrdersRepo;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author bill
 * @since 2024-08-13
 */
@Service
public class OrdersRepoImpl extends ServiceImpl<OrdersMapper, OrdersPO> implements OrdersRepo {

}

package com.example.persistents.repo.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.example.persistents.po.OrdersPO;
import com.example.persistents.mapper.OrdersMapper;
import com.example.persistents.repo.OrdersRepo;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author bill
 * @since 2026-03-18
 */
@Service
public class OrdersRepoImpl extends ServiceImpl<OrdersMapper, OrdersPO>  implements OrdersRepo{

}

package com.example.mybatis.repo.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.example.mybatis.po.ProductsPO;
import com.example.mybatis.mapper.ProductsMapper;
import com.example.mybatis.repo.ProductsRepo;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author bill
 * @since 2024-08-13
 */
@Service
public class ProductsRepoImpl extends ServiceImpl<ProductsMapper, ProductsPO> implements ProductsRepo {

}

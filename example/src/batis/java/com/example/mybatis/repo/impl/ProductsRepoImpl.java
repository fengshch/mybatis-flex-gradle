package com.example.mybatis.repo.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.example.mybatis.po.ProductsPo;
import com.example.mybatis.mapper.ProductsMapper;
import com.example.mybatis.repo.ProductsRepo;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author bill
 * @since 2024-09-06
 */
@Service
public class ProductsRepoImpl extends ServiceImpl<ProductsMapper, ProductsPo> implements ProductsRepo {

}

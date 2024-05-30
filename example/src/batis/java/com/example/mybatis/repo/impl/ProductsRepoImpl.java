package com.example.mybatis.repo.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.example.mybatis.entity.Products;
import com.example.mybatis.mapper.ProductsMapper;
import com.example.mybatis.repo.ProductsRepo;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author bill
 * @since 2024-05-30
 */
@Service
public class ProductsRepoImpl extends ServiceImpl<ProductsMapper, Products> implements ProductsRepo {

}

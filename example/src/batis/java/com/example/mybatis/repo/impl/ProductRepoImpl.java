package com.example.mybatis.repo.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.example.mybatis.entity.Product;
import com.example.mybatis.mapper.ProductMapper;
import com.example.mybatis.repo.ProductRepo;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author bill
 * @since 2024-02-20
 */
@Service
public class ProductRepoImpl extends ServiceImpl<ProductMapper, Product> implements ProductRepo {

}

package com.example.persistents.repo.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.example.persistents.po.ProductsPO;
import com.example.persistents.mapper.ProductsMapper;
import com.example.persistents.repo.ProductsRepo;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author bill
 * @since 2026-03-18
 */
@Service
public class ProductsRepoImpl extends ServiceImpl<ProductsMapper, ProductsPO>  implements ProductsRepo{

}

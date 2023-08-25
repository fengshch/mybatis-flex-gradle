package com.example.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.mybatisflex.core.BaseMapper;
import com.example.mybatis.entity.Product;

/**
 *  映射层。
 *
 * @author bill
 * @since 2023-08-25
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}
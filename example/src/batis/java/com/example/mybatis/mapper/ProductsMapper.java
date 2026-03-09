package com.example.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.mybatisflex.core.BaseMapper;
import com.example.mybatis.po.ProductsPO;

/**
 *  映射层。
 *
 * @author bill
 * @since 2026-03-06
 */
@Mapper
public interface ProductsMapper extends BaseMapper<ProductsPO> {

}

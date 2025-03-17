package com.example.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.mybatisflex.core.BaseMapper;
import com.example.mybatis.po.OrdersPo;

/**
 *  映射层。
 *
 * @author bill
 * @since 2024-12-10
 */
@Mapper
public interface OrdersMapper extends BaseMapper<OrdersPo> {

}

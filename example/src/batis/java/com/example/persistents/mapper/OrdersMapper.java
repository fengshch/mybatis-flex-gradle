package com.example.persistents.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.mybatisflex.core.BaseMapper;
import com.example.persistents.po.OrdersPO;

/**
 *  映射层。
 *
 * @author bill
 * @since 2026-03-18
 */
@Mapper
public interface OrdersMapper extends BaseMapper<OrdersPO> {

}

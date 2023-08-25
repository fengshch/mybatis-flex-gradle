package com.example.mybatis.repo.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.example.mybatis.entity.FlywaySchemaHistory;
import com.example.mybatis.mapper.FlywaySchemaHistoryMapper;
import com.example.mybatis.repo.FlywaySchemaHistoryRepo;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author bill
 * @since 2023-08-25
 */
@Service
public class FlywaySchemaHistoryRepoImpl extends ServiceImpl<FlywaySchemaHistoryMapper, FlywaySchemaHistory> implements FlywaySchemaHistoryRepo {

}

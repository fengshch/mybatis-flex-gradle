package com.example.mybatis.repo.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.example.mybatis.entity.Authorities;
import com.example.mybatis.mapper.AuthoritiesMapper;
import com.example.mybatis.repo.AuthoritiesRepo;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author bill
 * @since 2023-09-11
 */
@Service
public class AuthoritiesRepoImpl extends ServiceImpl<AuthoritiesMapper, Authorities> implements AuthoritiesRepo {

}

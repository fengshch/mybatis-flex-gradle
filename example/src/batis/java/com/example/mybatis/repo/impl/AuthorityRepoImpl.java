package com.example.mybatis.repo.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.example.mybatis.entity.Authority;
import com.example.mybatis.mapper.AuthorityMapper;
import com.example.mybatis.repo.AuthorityRepo;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author bill
 * @since 2023-09-11
 */
@Service
public class AuthorityRepoImpl extends ServiceImpl<AuthorityMapper, Authority> implements AuthorityRepo {

}

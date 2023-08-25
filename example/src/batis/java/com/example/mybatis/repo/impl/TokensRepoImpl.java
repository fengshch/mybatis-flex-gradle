package com.example.mybatis.repo.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.example.mybatis.entity.Tokens;
import com.example.mybatis.mapper.TokensMapper;
import com.example.mybatis.repo.TokensRepo;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author bill
 * @since 2023-08-25
 */
@Service
public class TokensRepoImpl extends ServiceImpl<TokensMapper, Tokens> implements TokensRepo {

}

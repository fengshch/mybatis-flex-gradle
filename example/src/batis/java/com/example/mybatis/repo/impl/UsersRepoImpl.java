package com.example.mybatis.repo.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.example.mybatis.po.UsersPo;
import com.example.mybatis.mapper.UsersMapper;
import com.example.mybatis.repo.UsersRepo;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author bill
 * @since 2024-09-06
 */
@Service
public class UsersRepoImpl extends ServiceImpl<UsersMapper, UsersPo> implements UsersRepo {

}

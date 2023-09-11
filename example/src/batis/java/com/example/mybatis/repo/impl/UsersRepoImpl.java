package com.example.mybatis.repo.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.example.mybatis.entity.Users;
import com.example.mybatis.mapper.UsersMapper;
import com.example.mybatis.repo.UsersRepo;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author bill
 * @since 2023-09-11
 */
@Service
public class UsersRepoImpl extends ServiceImpl<UsersMapper, Users> implements UsersRepo {

}

package com.example.mybatis.repo.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.example.mybatis.po.UsersPO;
import com.example.mybatis.mapper.UsersMapper;
import com.example.mybatis.repo.UsersRepo;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author bill
 * @since 2024-08-13
 */
@Service
public class UsersRepoImpl extends ServiceImpl<UsersMapper, UsersPO> implements UsersRepo {

}

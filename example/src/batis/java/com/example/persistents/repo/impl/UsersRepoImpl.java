package com.example.persistents.repo.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.example.persistents.po.UsersPO;
import com.example.persistents.mapper.UsersMapper;
import com.example.persistents.repo.UsersRepo;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author bill
 * @since 2026-03-18
 */
@Service
public class UsersRepoImpl extends ServiceImpl<UsersMapper, UsersPO>  implements UsersRepo{

}

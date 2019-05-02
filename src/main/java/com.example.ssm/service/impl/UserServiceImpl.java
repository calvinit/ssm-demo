package com.example.ssm.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ssm.entity.User;
import com.example.ssm.mapper.UserMapper;
import com.example.ssm.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public IPage<User> selectPage(IPage<User> page) {
        return super.page(page);
    }

    @Override
    public IPage<User> selectPage(IPage<User> page, Wrapper<User> queryWrapper) {
        return super.page(page, queryWrapper);
    }

    @Override
    public User selectByPrimaryKey(int id) {
        return super.getById(id);
    }

    @Override
    public List<User> list() {
        return super.list();
    }

    @Override
    public List<User> list(Wrapper<User> queryWrapper) {
        return super.list(queryWrapper);
    }
}

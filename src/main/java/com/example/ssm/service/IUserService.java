package com.example.ssm.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ssm.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IUserService extends IService<User> {

    @Transactional(readOnly = true, rollbackFor = Exception.class)
    IPage<User> selectPage(IPage<User> page);

    @Transactional(readOnly = true, rollbackFor = Exception.class)
    IPage<User> selectPage(IPage<User> page, Wrapper<User> queryWrapper);

    @Transactional(readOnly = true, rollbackFor = Exception.class)
    User selectByPrimaryKey(int id);

    @Transactional(readOnly = true, rollbackFor = Exception.class)
    List<User> list();

    @Transactional(readOnly = true, rollbackFor = Exception.class)
    List<User> list(Wrapper<User> queryWrapper);
}

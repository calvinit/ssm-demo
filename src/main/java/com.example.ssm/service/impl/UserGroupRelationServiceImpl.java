package com.example.ssm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ssm.entity.UserGroupRelation;
import com.example.ssm.mapper.UserGroupRelationMapper;
import com.example.ssm.service.IUserGroupRelationService;
import org.springframework.stereotype.Service;

@Service
public class UserGroupRelationServiceImpl extends ServiceImpl<UserGroupRelationMapper, UserGroupRelation> implements IUserGroupRelationService {

}

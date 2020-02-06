package com.example.ssm.dto;

import com.example.ssm.converter.UserGroupDto2Converter;
import com.example.ssm.converter.UserGroupDtoConverter;
import com.example.ssm.entity.Group;
import com.example.ssm.entity.User;
import com.example.ssm.entity.UserGroupRelation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-*.xml"})
public class UserGroupDtoConverterTests {

    @Autowired
    private UserGroupDtoConverter userGroupDtoConverter;
    @Autowired
    private UserGroupDto2Converter userGroupDto2Converter;

    @Test
    public void testMapping() throws JsonProcessingException {
        LocalDateTime now = LocalDateTime.now();

        User user = new User();
        user.setId(1);
        user.setName("刘一");
        user.setGender("保密");
        user.setBirthday("2001-01-03");
        user.setTel("13800138001");
        user.setAddress("测试地址--001");
        user.setRemark("这是测试用户数据");
        user.setCreateDt(now);
        user.setLastUpdateDt(now);

        Group group = new Group();
        group.setId(3);
        group.setName("群组3");
        group.setVisible(false);
        group.setRemark("这是测试群组数据");
        group.setCreateDt(now);
        group.setLastUpdateDt(now);

        UserGroupRelation userGroupRelation = new UserGroupRelation();
        userGroupRelation.setId(1);
        userGroupRelation.setUserId(user.getId());
        userGroupRelation.setGroupId(group.getId());
        userGroupRelation.setCreateDt(now);

        ObjectWriter objectWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();

        UserGroupDto userGroupDto = userGroupDtoConverter.mergeEntitiesToDto(user, group);
        log.debug("userGroupDto: \n{}", objectWriter.writeValueAsString(userGroupDto));

        UserGroupDto2 userGroupDto2 = userGroupDto2Converter.mergeEntitiesToDto(user, userGroupRelation, group);
        log.debug("userGroupDto2: \n{}", objectWriter.writeValueAsString(userGroupDto2));
    }
}

package com.example.ssm.vo;

import com.example.ssm.converter.UserVoConverter;
import com.example.ssm.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
public class UserVoTests {

    private final UserVoConverter userVoConverter = Mappers.getMapper(UserVoConverter.class);

    @Test
    public void testMapping() throws JsonProcessingException {
        ObjectWriter objectWriter = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writerWithDefaultPrettyPrinter();

        LocalDateTime now = LocalDateTime.now();

        User user1 = new User();
        user1.setId(1);
        user1.setName("张三");
        user1.setGender("保密");
        user1.setBirthday("2001-01-03");
        user1.setTel("13800138001");
        user1.setAddress("测试地址--001");
        user1.setRemark("这是测试用户数据1");
        user1.setCreateDt(now);
        user1.setLastUpdateDt(now);

        UserVo userVo1 = userVoConverter.entityToVo(user1);
        log.debug("userVo1: \n{}\n", objectWriter.writeValueAsString(userVo1));
        User tUser1 = userVoConverter.voToEntity(userVo1);
        log.debug("tUser1: \n{}\n", objectWriter.writeValueAsString(tUser1));

        User user2 = new User();
        user2.setId(2);
        user2.setName("李四");
        user2.setGender("男");
        user2.setBirthday("2000-11-20");
        user2.setTel("13800138002");
        user2.setAddress("测试地址--002");
        user2.setRemark("这是测试用户数据2");
        user2.setCreateDt(now);
        user2.setLastUpdateDt(now);

        UserVo userVo2 = userVoConverter.entityToVo(user2);
        log.debug("userVo2: \n{}\n", objectWriter.writeValueAsString(userVo2));
        User tUser2 = userVoConverter.voToEntity(userVo2);
        log.debug("tUser2: \n{}\n", objectWriter.writeValueAsString(tUser2));

        User user3 = new User();
        user3.setId(3);
        user3.setName("王五");
        user3.setGender("女");
        user3.setBirthday("2001-05-13");
        user3.setTel("13800138003");
        user3.setAddress("测试地址--003");
        user3.setRemark("这是测试用户数据3");
        user3.setCreateDt(now);
        user3.setLastUpdateDt(now);

        UserVo userVo3 = userVoConverter.entityToVo(user3);
        log.debug("userVo3: \n{}\n", objectWriter.writeValueAsString(userVo3));
        User tUser3 = userVoConverter.voToEntity(userVo3);
        log.debug("tUser3: \n{}\n", objectWriter.writeValueAsString(tUser3));

        List<User> userList = List.of(user1, user2, user3);
        List<UserVo> userVoList = userVoConverter.batchEntityToVo(userList);
        log.debug("userVoList: \n{}\n", objectWriter.writeValueAsString(userVoList));
        userVoList = List.of(userVo1, userVo2, userVo3);
        userList = userVoConverter.batchVoToEntity(userVoList);
        log.debug("userList: \n{}", objectWriter.writeValueAsString(userList));
    }
}

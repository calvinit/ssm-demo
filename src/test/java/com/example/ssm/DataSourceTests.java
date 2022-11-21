package com.example.ssm;

import com.example.ssm.entity.Group;
import com.example.ssm.mapper.GroupMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-*.xml"})
public class DataSourceTests {

    @Autowired
    private GroupMapper groupMapper;

    @Test
    public void test() {
        List<Group> groupList = groupMapper.selectList(null);
        groupList.forEach(System.out::println);
    }
}

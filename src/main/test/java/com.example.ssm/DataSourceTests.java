package com.example.ssm;

import com.example.ssm.entity.Group;
import com.example.ssm.mapper.GroupMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
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

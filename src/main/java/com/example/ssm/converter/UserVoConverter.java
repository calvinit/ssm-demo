package com.example.ssm.converter;

import com.example.ssm.entity.User;
import com.example.ssm.vo.UserVo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface UserVoConverter {

    @Mappings({
            @Mapping(target = "userId", source = "id"),
            @Mapping(target = "userName", source = "name"),
            @Mapping(target = "createDt", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "lastUpdateDt", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    UserVo entityToVo(User user);

    List<UserVo> batchEntityToVo(List<User> userList);

    @InheritInverseConfiguration
    User voToEntity(UserVo userVo);

    List<User> batchVoToEntity(List<UserVo> userVoList);
}

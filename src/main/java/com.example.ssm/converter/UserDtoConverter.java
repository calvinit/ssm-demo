package com.example.ssm.converter;

import com.example.ssm.dto.UserDto;
import com.example.ssm.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface UserDtoConverter {

    @Mappings({
            @Mapping(target = "createDt", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "lastUpdateDt", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    UserDto entityToDto(User user);

    List<UserDto> batchEntityToDto(List<User> userList);

    @InheritInverseConfiguration
    User dtoToEntity(UserDto userDto);

    List<User> batchDtoToEntity(List<UserDto> userDtoList);
}

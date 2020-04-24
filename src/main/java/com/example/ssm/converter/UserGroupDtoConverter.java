package com.example.ssm.converter;

import com.example.ssm.dto.UserGroupDto;
import com.example.ssm.entity.Group;
import com.example.ssm.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface UserGroupDtoConverter {

    @Mappings({
            @Mapping(target = "userId", source = "user.id"),
            @Mapping(target = "userName", source = "user.name"),
            @Mapping(target = "groupId", source = "group.id"),
            @Mapping(target = "groupName", source = "group.name"),
            @Mapping(target = "gender", source = "user.gender"),
            @Mapping(source = "user.tel", target = "telephone"),
            @Mapping(target = "birthday", source = "user.birthday"),
            @Mapping(target = "address", source = "user.address"),
            @Mapping(target = "visible", source = "group.visible")
    })
    UserGroupDto mergeEntitiesToDto(User user, Group group);
}

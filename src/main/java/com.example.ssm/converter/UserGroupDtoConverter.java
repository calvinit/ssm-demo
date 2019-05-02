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
            @Mapping(source = "user.id", target = "userId"),
            @Mapping(source = "user.name", target = "userName"),
            @Mapping(source = "group.id", target = "groupId"),
            @Mapping(source = "group.name", target = "groupName"),
            @Mapping(source = "user.tel", target = "telephone")
    })
    UserGroupDto mergeEntitiesToDto(User user, Group group);
}

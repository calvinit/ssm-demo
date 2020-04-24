package com.example.ssm.converter;

import com.example.ssm.dto.UserGroupDto2;
import com.example.ssm.entity.Group;
import com.example.ssm.entity.User;
import com.example.ssm.entity.UserGroupRelation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(uses = {UserDtoConverter.class, GroupDtoConverter.class})
public interface UserGroupDto2Converter {

    @Mappings({
            @Mapping(target = "id", source = "userGroupRelation.id"),
            @Mapping(target = "userDto", source = "user"),
            @Mapping(target = "groupDto", source = "group"),
            @Mapping(target = "createDt", source = "userGroupRelation.createDt", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    UserGroupDto2 mergeEntitiesToDto(User user, UserGroupRelation userGroupRelation, Group group);
}

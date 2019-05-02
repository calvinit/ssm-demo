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
            @Mapping(source = "userGroupRelation.id", target = "id"),
            @Mapping(source = "user", target = "userDto"),
            @Mapping(source = "group", target = "groupDto"),
            @Mapping(source = "userGroupRelation.createDt", target = "createDt", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    UserGroupDto2 mergeEntitiesToDto(User user, UserGroupRelation userGroupRelation, Group group);
}

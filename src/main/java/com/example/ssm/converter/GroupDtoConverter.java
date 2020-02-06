package com.example.ssm.converter;

import com.example.ssm.dto.GroupDto;
import com.example.ssm.entity.Group;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface GroupDtoConverter {

    @Mappings({
            @Mapping(target = "createDt", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "lastUpdateDt", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    GroupDto entityToDto(Group group);

    List<GroupDto> batchEntityToDto(List<Group> groupList);

    @InheritInverseConfiguration
    Group dtoToEntity(GroupDto groupDto);

    List<Group> batchDtoToEntity(List<GroupDto> groupDtoList);
}

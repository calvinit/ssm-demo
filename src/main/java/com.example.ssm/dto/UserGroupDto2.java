package com.example.ssm.dto;

import lombok.Data;

@Data
public class UserGroupDto2 {

    /**
     * 用户-群组关系表，主键ID
     */
    private int id;

    /**
     * 用户
     */
    private UserDto userDto;

    /**
     * 群组
     */
    private GroupDto groupDto;

    /**
     * 创建时间
     */
    private String createDt;
}

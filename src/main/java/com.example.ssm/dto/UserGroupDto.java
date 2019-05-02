package com.example.ssm.dto;

import lombok.Data;

@Data
public class UserGroupDto {

    /**
     * 用户ID
     */
    private int userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 所属群组ID
     */
    private int groupId;

    /**
     * 所属群组名称
     */
    private String groupName;

    /**
     * 性别
     */
    private String gender;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 联系电话
     */
    private String telephone;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 所属群组是否可见
     */
    private boolean visible;
}

package com.example.ssm.dto;

import lombok.Data;

@Data
public class UserDto {

    /**
     * ID
     */
    private int id;

    /**
     * 姓名
     */
    private String name;

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
    private String tel;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private String createDt;

    /**
     * 最后更新时间
     */
    private String lastUpdateDt;
}

package com.example.ssm.vo;

import lombok.Data;

@Data
public class UserVo {

    /**
     * ID
     */
    private int userId;

    /**
     * 姓名
     */
    private String userName;

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

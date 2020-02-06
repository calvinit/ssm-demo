package com.example.ssm.dto;

import lombok.Data;

@Data
public class GroupDto {

    /**
     * ID
     */
    private int id;

    /**
     * 群组名称
     */
    private String name;

    /**
     * 是否可见（0：否，1：是）
     */
    private boolean visible;

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

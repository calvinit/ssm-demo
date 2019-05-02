package com.example.ssm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user_group_relation")
public class UserGroupRelation implements Serializable {

    private static final long serialVersionUID = 5947200140623924174L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 群组ID
     */
    @TableField("group_id")
    private Integer groupId;

    /**
     * 创建时间
     */
    @TableField("create_dt")
    private Date createDt;

    public static final String ID = "id";

    public static final String USER_ID = "user_id";

    public static final String GROUP_ID = "group_id";

    public static final String CREATE_DT = "create_dt";
}

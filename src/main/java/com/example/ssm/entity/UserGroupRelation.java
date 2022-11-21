package com.example.ssm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户-群组关系表
 *
 * @author auto-generator
 * @since 2022/11/21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_user_group_relation")
public class UserGroupRelation implements Serializable {

    @Serial
    private static final long serialVersionUID = -187408203315155266L;

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
    private LocalDateTime createDt;

    public static final String ID = "id";

    public static final String USER_ID = "user_id";

    public static final String GROUP_ID = "group_id";

    public static final String CREATE_DT = "create_dt";
}

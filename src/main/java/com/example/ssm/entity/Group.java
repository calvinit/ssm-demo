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
 * 群组表
 *
 * @author auto-generator
 * @since 2022/11/21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_group")
public class Group implements Serializable {

    @Serial
    private static final long serialVersionUID = 7464262768830403543L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 群组名称
     */
    @TableField("`name`")
    private String name;

    /**
     * 是否可见（0：否，1：是）
     */
    @TableField("`visible`")
    private Boolean visible;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 创建时间
     */
    @TableField("create_dt")
    private LocalDateTime createDt;

    /**
     * 最后更新时间
     */
    @TableField("last_update_dt")
    private LocalDateTime lastUpdateDt;

    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String VISIBLE = "visible";

    public static final String REMARK = "remark";

    public static final String CREATE_DT = "create_dt";

    public static final String LAST_UPDATE_DT = "last_update_dt";
}

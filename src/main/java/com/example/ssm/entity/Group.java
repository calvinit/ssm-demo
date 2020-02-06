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
@TableName("t_group")
public class Group implements Serializable {

    private static final long serialVersionUID = 90302241012039201L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 群组名称
     */
    @TableField("name")
    private String name;

    /**
     * 是否可见（0：否，1：是）
     */
    @TableField("visible")
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
    private Date createDt;

    /**
     * 最后更新时间
     */
    @TableField("last_update_dt")
    private Date lastUpdateDt;

    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String VISIBLE = "visible";

    public static final String REMARK = "remark";

    public static final String CREATE_DT = "create_dt";

    public static final String LAST_UPDATE_DT = "last_update_dt";
}

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
 * 用户表
 *
 * @author auto-generator
 * @since 2022/11/21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_user")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 8657888305886996227L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    @TableField("`name`")
    private String name;

    /**
     * 性别
     */
    @TableField("gender")
    private String gender;

    /**
     * 生日
     */
    @TableField("birthday")
    private String birthday;

    /**
     * 联系电话
     */
    @TableField("tel")
    private String tel;

    /**
     * 联系地址
     */
    @TableField("address")
    private String address;

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

    public static final String GENDER = "gender";

    public static final String BIRTHDAY = "birthday";

    public static final String TEL = "tel";

    public static final String ADDRESS = "address";

    public static final String REMARK = "remark";

    public static final String CREATE_DT = "create_dt";

    public static final String LAST_UPDATE_DT = "last_update_dt";
}

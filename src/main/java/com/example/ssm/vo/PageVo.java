package com.example.ssm.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class PageVo<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 7524276290658542899L;
    /**
     * 页码
     */
    private long pageNum;
    /**
     * 页面大小
     */
    private long pageSize;
    /**
     * 总页数
     */
    private long pageTotal;
    /**
     * 总数据行数
     */
    private long rowTotal;
    /**
     * 数据行列表
     */
    private List<T> rowList;
}

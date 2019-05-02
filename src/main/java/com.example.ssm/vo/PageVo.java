package com.example.ssm.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Data
@Accessors(chain = true)
public class PageVo<T> implements Serializable {

    private static final long serialVersionUID = 7524276290658542899L;
    /**
     * 页码
     */
    private long pageNum = 1;
    /**
     * 页面大小
     */
    private long pageSize = 10;
    /**
     * 总页数
     */
    private long pageTotal = 0;
    /**
     * 总数据行数
     */
    private long rowTotal = 0;
    /**
     * 数据行列表
     */
    private List<T> rowList = Collections.emptyList();

    public PageVo<T> get() {
        return this;
    }
}

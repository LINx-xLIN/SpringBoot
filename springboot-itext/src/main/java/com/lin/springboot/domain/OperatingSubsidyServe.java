package com.lin.springboot.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 运营补贴服务情况表
 */
@Data
public class OperatingSubsidyServe implements Serializable {
    /**
     * 编号
     */
    private String id;

    /**
     * 运营补贴编号
     */
    private String operatingSubsidyId;

    /**
     * 老人服务情况（a->自理，b->半自理，c->不能自理）
     */
    private String serveType;

    /**
     * 一月数量
     */
    private String monNum;

    /**
     * 二月数量
     */
    private String febNum;

    /**
     * 三月数量
     */
    private String marNum;

    /**
     * 四月数量
     */
    private String aprNum;

    /**
     * 五月数量
     */
    private String mayNum;

    /**
     * 六月数量
     */
    private String junNum;

    /**
     * 七月数量
     */
    private String julNum;

    /**
     * 八月数量
     */
    private String aguNum;

    /**
     * 九月数量
     */
    private String sepNum;

    /**
     * 十月数量
     */
    private String octNum;

    /**
     * 十一月数量
     */
    private String novNum;

    /**
     * 十二月数量
     */
    private String decNum;

    /**
     * 年服务量合计
     */
    private String totalNum;

    /**
     * 年申请补助金额合计
     */
    private String totalMoney;

    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date createDate;

    /**
     * 修改日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date updateDate;

    private static final long serialVersionUID = 1L;
}
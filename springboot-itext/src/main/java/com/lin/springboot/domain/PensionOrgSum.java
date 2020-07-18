package com.lin.springboot.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 养老机构补贴汇总表
 */
@Data
public class PensionOrgSum implements Serializable {
    /**
     * 编号
     */
    private String id;

    private int index;

    /**
     * 所属对象（0-->养老机构，1-->区）
     */
    private String target;

    /**
     * 养老机构编号
     */
    private String pensionOrgId;

    /**
     * 区----->行政区域编码
     */
    private String zoneRegionCode;

    /**
     * 补贴类型（0--->建设补贴，1--->运营补贴）
     */
    private String subsidyType;

    /**
     * 年份
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date year;
    /**
     * 养老机构行政区域名称
     */

    private String pensionOrgRegionName;

    private String pensionOrgRegionCode;
    /**
     * 实际补贴金总额
     */
    private String actualMoney;

    /**
     * 市分配比例
     */
    private String cityRatio;

    /**
     * 县分配比例
     */
    private String countyRatio;

    /**
     * 用户编号
     */
    private String persionId;

    /**
     * 行政区域编码
     */
    private String regionCode;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 修改日期
     */
    private Date updateDate;

    /**
     * 行政区域名称
     */
    private String regionName;

    /**
     * 机构数量
     */
    private Long orgNum;

    /**
     * 机构性质（0公建，1民营）
     */
    private String isPublic;

    /**
     * 建筑面积
     */
    private String buildArea;

    /**
     * 床位数
     */
    private Long bedNum;;

    /**
     * 运营日期
     */
    private Date practiceDate;

    /**
     * 营业执照注册号(社会组织信用代码)
     */
    private String openNo;

    /**
     * 自理人数
     */
    private Long jiliNum;

    /**
     * 半自理人数
     */
    private Long banZiliNum;

    /**
     * 不能自理人数
     */
    private Long bnZiliNum;
    /**
     * 建设申请补贴金额
     */
    private Long applyMoney;
    /**
     * 运营申请补贴金额
     */
    private Long applyTotalMoney;


    /**
     * 养老机构名称
     */
    private String pensionOrgName;
    /**
     *   民非登记证号 许可证书编号
     */
    private String licenseNo;

    private Long liveNum;

    private Long totalMoney;


    private static final long serialVersionUID = 1L;
}
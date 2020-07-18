package com.lin.springboot.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.xml.internal.ws.api.message.Attachment;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 运营补助申请表
 */
@Data
public class OperatingSubsidy implements Serializable {
    /**
     * 编号
     */
    private String id;

    /**
     * 养老机构编号
     */
    private String pensionOrgId;

    /**
     * 养老机构名称
     */
    private String pensionOrgName;

    /**
     * 养老机构住所
     */
    private String pensionOrgAddress;

    /**
     * 养老机构行政区域编码
     */
    private String pensionOrgRegionCode;

    /**
     * 许可证书编号
     */
    private String licenseNo;

    /**
     * 登记床位数
     */
    private String bedNum;

    /**
     * 法人证书编号
     */
    private String legalNo;

    /**
     * 机构性质
     */
    private String orgNature;

    /**
     * 是否为公建民营（0->是，1->否）
     */
    private String isPublic;

    /**
     * 营业执照注册号
     */
    private String openNo;

    /**
     * 注册资金（万元）
     */
    private String capital;

    /**
     * 养老机构法定代表人
     */
    private String legalPersion;

    /**
     * 登记机关
     */
    private String registrar;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 邮政编码
     */
    private String zipCode;

    /**
     * 执业时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date practiceDate;

    /**
     * 开户银行
     */
    private String bank;

    /**
     * 银行账号
     */
    private String bankAccount;

    /**
     * 银行行号
     */
    private String bankCode;

    /**
     * 年申请补助金额总合计
     */
    private String applyTotalMoney;

    /**
     * 录入用户用户编号
     */
    private String persionId;

    /**
     * 录入用户行政区域编码
     */
    private String regionCode;

    /**
     * 创建日期（申请日期）
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date createDate;

    /**
     * 修改日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date updateDate;

    /**
     * 运营补贴服务情况列表
     *
     * */
    private List<OperatingSubsidyServe>  operatingSubsidyServe;
    /**
     * 附件列表
     *
     * */
    private List<Attachment> attachment;
    /**
     *
     *申请日期开始时间
     */

    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date startDate;
    /**
     *
     *申请日期结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date endDate;

    private static final long serialVersionUID = 1L;
}
package com.lin.springboot.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.xml.internal.ws.api.message.Attachment;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 建筑补助申请表
 */
@Data
public class ConstructionSubsidy implements Serializable {
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
     * 扩建新增床位位数（张）
     */
    private String addBedNum;

    /**
     * 法人证书编号
     */
    private String legalNo;

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
     * 建设方式（0->新建，1->扩建，2->改建）
     */
    private String buildMethod;

    /**
     * 占地面积（㎡）
     */
    private String floorArea;

    /**
     * 建筑面积（㎡）
     */
    private String buildArea;

    /**
     * 房屋权属（0->机构自有，1->租凭，2->其它）
     */
    private String houseWeight;

    /**
     * 租凭开始日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date rentalBeginDate;

    /**
     * 租凭结束日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date rentalEndDate;

    /**
     * 申请补助床位（张）
     */
    private String applyBedNum;

    /**
     * 申请补助金额（万元）
     */
    private String applyMoney;

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
     *  上传附件列表
     */
    private List<Attachment> attachments;

    private static final long serialVersionUID = 1L;
}
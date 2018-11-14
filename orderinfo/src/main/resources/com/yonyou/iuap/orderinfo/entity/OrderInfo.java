package com.yonyou.iuap.orderinfo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.iuap.baseservice.attachment.entity.AttachmentEntity;
import com.yonyou.iuap.baseservice.attachment.entity.Attachmentable;
import com.yonyou.iuap.baseservice.entity.AbsDrModel;
import com.yonyou.iuap.baseservice.entity.annotation.Reference;
import com.yonyou.iuap.baseservice.support.condition.Condition;
import com.yonyou.iuap.baseservice.support.condition.Match;
import com.yonyou.iuap.baseservice.support.generator.GeneratedValue;
import com.yonyou.iuap.baseservice.support.generator.Strategy;

/**
 * 单表培训
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "order_info")

public class OrderInfo extends AbsDrModel implements Serializable, Attachmentable {
	@Id
	@GeneratedValue(strategy = Strategy.UUID)
	@Column(name = "id")
	@Condition
	protected String id;// ID

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(Serializable id) {
		this.id = id.toString();
		super.id = id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Condition(match = Match.EQ)
	@Column(name = "order_type")
	private String orderType; // 订单类型

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderType() {
		return this.orderType;
	}

	@Column(name = "is_paid")
	private Boolean isPaid; // 是否付款

	public void setIsPaid(Boolean isPaid) {
		this.isPaid = isPaid;
	}

	public Boolean getIsPaid() {
		return this.isPaid;
	}

	@Condition(match = Match.EQ)
	@Column(name = "order_no")
	private String orderNo; // 编号

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderNo() {
		return this.orderNo;
	}

	@Condition(match = Match.EQ)
	@Column(name = "pur_org")
	@Reference(code = "common_ref", srcProperties = { "peoname" }, desProperties = { "purOrgSrc" })
	private String purOrg; // 采购单位

	public void setPurOrg(String purOrg) {
		this.purOrg = purOrg;
	}

	public String getPurOrg() {
		return this.purOrg;
	}

	@Column(name = "release_time")
	private String releaseTime; // 发布时间

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getReleaseTime() {
		return this.releaseTime;
	}

	@Condition(match = Match.EQ)
	@Column(name = "order_amount")
	private BigDecimal orderAmount; // 订单金额

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public BigDecimal getOrderAmount() {
		return this.orderAmount;
	}

	@Column(name = "apply_no")
	@Reference(code = "bd_common_org", srcProperties = { "name" }, desProperties = { "applyName" })
	private String applyNo; // 供应商编号

	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}

	public String getApplyNo() {
		return this.applyNo;
	}

	@Condition(match = Match.EQ)
	@Column(name = "pur_group_no")
	private String purGroupNo; // 采购组编号

	public void setPurGroupNo(String purGroupNo) {
		this.purGroupNo = purGroupNo;
	}

	public String getPurGroupNo() {
		return this.purGroupNo;
	}

	@Transient
	private String purOrgSrc; // purOrgSrc

	public void setPurOrgSrc(String purOrgSrc) {
		this.purOrgSrc = purOrgSrc;
	}

	public String getPurOrgSrc() {
		return this.purOrgSrc;
	}

	@Column(name = "confirm_time")
	private String confirmTime; // 确认时间

	public void setConfirmTime(String confirmTime) {
		this.confirmTime = confirmTime;
	}

	public String getConfirmTime() {
		return this.confirmTime;
	}

	@Transient
	private String applyName; // applyName

	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}

	public String getApplyName() {
		return this.applyName;
	}

	@Condition(match = Match.EQ)
	@Column(name = "order_state")
	private String orderState; // 订单状态

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getOrderState() {
		return this.orderState;
	}

	@Condition(match = Match.EQ)
	@Column(name = "billstatus")
	private String billstatus; // 单据状态

	public String getBillstatus() {
		return billstatus;
	}

	public void setBillstatus(String billstatus) {
		this.billstatus = billstatus;
	}
	

	@Transient
	private List<AttachmentEntity> attachment;

	@Override
	public List<AttachmentEntity> getAttachment() {
		return attachment;
	}

	@Override
	public void setAttachment(List<AttachmentEntity> attachment) {
		this.attachment = attachment;
	}

}

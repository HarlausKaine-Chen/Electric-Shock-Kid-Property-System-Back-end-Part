package com.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;


/**
 * 水电费
 * 数据库通用操作实体类（普通增删改查）
 */
@TableName("we_fees")
public class WeFeesEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public WeFeesEntity() {

	}

	public WeFeesEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 水费
	 */
	@TableField("water_fee")
	private String waterFee;

	/**
     * 电费
	 */
	@TableField("electricity_fee")
	private String electricityFee;

	/**
	 * 月份
	 */
	private String month;

	/**
	 * 是否支付
	 */
	@TableField("is_pay")
	private String isPay;

	/**
	 * 宿舍编号
	 */
	@TableField("hostel_no")
	private String hostelNo;

	/**
	 * 缴费日期
	 */
	private String paydate;

	public String getPaydate() {
		return paydate;
	}

	public void setPaydate(String paydate) {
		this.paydate = paydate;
	}

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date crtTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWaterFee() {
		return waterFee;
	}

	public void setWaterFee(String waterFee) {
		this.waterFee = waterFee;
	}

	public String getElectricityFee() {
		return electricityFee;
	}

	public void setElectricityFee(String electricityFee) {
		this.electricityFee = electricityFee;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getIsPay() {
		return isPay;
	}

	public void setIsPay(String isPay) {
		this.isPay = isPay;
	}


	public String getHostelNo() {
		return hostelNo;
	}

	public void setHostelNo(String hostelNo) {
		this.hostelNo = hostelNo;
	}

	public Date getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}
}

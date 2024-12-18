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
 * 宿舍信息
 * 数据库通用操作实体类（普通增删改查）
 */
@TableName("hostel_info")
public class HostelInfoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public HostelInfoEntity() {

	}

	public HostelInfoEntity(T t) {
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
	 * 宿舍编号
	 */
	@TableField("hostel_no")
	private String hostelNo;

	/**
	 * 宿舍名称
	 */
	@TableField("hostel_name")
	private String hostelName;

	/**
	 * 可容纳人数
	 */
	private String num;

	private Long c1;
	private Long c2;
	private Long c3;
	private Long c4;
	private Long c5;
	private Long c6;

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date crtTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHostelNo() {
		return hostelNo;
	}

	public void setHostelNo(String hostelNo) {
		this.hostelNo = hostelNo;
	}

	public String getHostelName() {
		return hostelName;
	}

	public void setHostelName(String hostelName) {
		this.hostelName = hostelName;
	}

	public Date getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Long getC1() {
		return c1;
	}

	public void setC1(Long c1) {
		this.c1 = c1;
	}

	public Long getC2() {
		return c2;
	}

	public void setC2(Long c2) {
		this.c2 = c2;
	}

	public Long getC3() {
		return c3;
	}

	public void setC3(Long c3) {
		this.c3 = c3;
	}

	public Long getC4() {
		return c4;
	}

	public void setC4(Long c4) {
		this.c4 = c4;
	}

	public Long getC5() {
		return c5;
	}

	public void setC5(Long c5) {
		this.c5 = c5;
	}

	public Long getC6() {
		return c6;
	}

	public void setC6(Long c6) {
		this.c6 = c6;
	}
}

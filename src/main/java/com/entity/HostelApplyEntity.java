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
 * 宿舍申请退宿
 * 数据库通用操作实体类（普通增删改查）
 */
@TableName("hostel_apply")
public class HostelApplyEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public HostelApplyEntity() {

	}

	public HostelApplyEntity(T t) {
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
	 * 学生ID
	 */
	@TableField("stu_id")
	private Long stuId;

	/**
     * 宿舍编号
	 */
	@TableField("hostel_no")
	private String hostelNo;

	/**
	 * 申请类别
	 */
	@TableField("apply_type")
	private String applyType;

	/**
	 * 申请进度
	 */
	@TableField("apply_pro")
	private String applyPro;

	/**
	 * 申请描述
	 */
	@TableField("apply_txt")
	private String applyTxt;

//	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
//	@DateTimeFormat
	@TableField("crt_time")
	private String crtTime;


	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStuId() {
		return stuId;
	}

	public void setStuId(Long stuId) {
		this.stuId = stuId;
	}

	public String getHostelNo() {
		return hostelNo;
	}

	public void setHostelNo(String hostelNo) {
		this.hostelNo = hostelNo;
	}

	public String getApplyType() {
		return applyType;
	}

	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}

	public String getApplyPro() {
		return applyPro;
	}

	public void setApplyPro(String applyPro) {
		this.applyPro = applyPro;
	}

	public String getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(String crtTime) {
		this.crtTime = crtTime;
	}

	public String getApplyTxt() {
		return applyTxt;
	}

	public void setApplyTxt(String applyTxt) {
		this.applyTxt = applyTxt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

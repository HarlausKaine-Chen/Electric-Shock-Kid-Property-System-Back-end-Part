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
 * 报修信息
 * 数据库通用操作实体类（普通增删改查）
 */
@TableName("repair_info")
public class RepairInfoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public RepairInfoEntity() {

	}

	public RepairInfoEntity(T t) {
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
	 * 报修内容
	 */
	@TableField("repair_text")
	private String repairText;

	/**
     * 学生ID
	 */
	@TableField("user_id")
	private Long userId;

	/**
	 * 学生姓名
	 */
	private String name;
	/**
	 * 报修进度
	 */
	@TableField("repair_pro")
	private String repairPro;

	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date crtTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRepairText() {
		return repairText;
	}

	public void setRepairText(String repairText) {
		this.repairText = repairText;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getRepairPro() {
		return repairPro;
	}

	public void setRepairPro(String repairPro) {
		this.repairPro = repairPro;
	}

	public Date getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

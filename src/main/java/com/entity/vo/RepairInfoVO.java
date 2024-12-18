package com.entity.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;


/**
 * 报修信息
 * 接口用
 */
public class RepairInfoVO implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 报修内容
	 */
					
	private String repairText;

	/**
     * 宿舍名称
	 */
	private Long userId;

	/**
	 * 报修进度
	 */
	private String repairPro;

	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date crtTime;

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
}

package com.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 宿舍申请信息
 * 接口用
 */
public class HostelApplyVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 学生ID
	 */

	private Long stuId;
	/**
	 * 宿舍编号
	 */
					
	private String hostelNo;

	/**
     * 申请类型
	 */
	private String applyType;


	/**
	 *申请进度
	 */
	private String applyPro;

	/**
	 * 申请描述
	 */
	private String applyTxt;
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date crtTime;

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


	public Date getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}

	public String getApplyTxt() {
		return applyTxt;
	}

	public void setApplyTxt(String applyTxt) {
		this.applyTxt = applyTxt;
	}
}

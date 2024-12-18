package com.entity.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 消息
 * 接口用
 */
public class MessageInfoVO implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 发消息人
	 */
					
	private Long sendId;

	/**
     * 接消息人
	 */
	private Long accpetId;

	/**
     * 消息内容
	 */
	private String content;

	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date crtTime;

	public Long getSendId() {
		return sendId;
	}

	public void setSendId(Long sendId) {
		this.sendId = sendId;
	}

	public Long getAccpetId() {
		return accpetId;
	}

	public void setAccpetId(Long accpetId) {
		this.accpetId = accpetId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}
}

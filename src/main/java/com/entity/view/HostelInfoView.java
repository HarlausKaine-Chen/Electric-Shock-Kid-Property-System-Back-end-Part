package com.entity.view;

import com.entity.HostelInfoEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;


/**
 * 宿舍信息
 * 接口用
 */
public class HostelInfoView extends HostelInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HostelInfoView(){

	}

	public HostelInfoView(HostelInfoEntity hostelInfoEntity){
		try {
			BeanUtils.copyProperties(this, hostelInfoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 宿舍可用床位数
	 */
	private String knum;

	public String getKnum() {
		return knum;
	}

	public void setKnum(String knum) {
		this.knum = knum;
	}

	private String c1n;
	private String c2n;
	private String c3n;
	private String c4n;
	private String c5n;
	private String c6n;

	public String getC1n() {
		return c1n;
	}

	public void setC1n(String c1n) {
		this.c1n = c1n;
	}

	public String getC2n() {
		return c2n;
	}

	public void setC2n(String c2n) {
		this.c2n = c2n;
	}

	public String getC3n() {
		return c3n;
	}

	public void setC3n(String c3n) {
		this.c3n = c3n;
	}

	public String getC4n() {
		return c4n;
	}

	public void setC4n(String c4n) {
		this.c4n = c4n;
	}

	public String getC5n() {
		return c5n;
	}

	public void setC5n(String c5n) {
		this.c5n = c5n;
	}

	public String getC6n() {
		return c6n;
	}

	public void setC6n(String c6n) {
		this.c6n = c6n;
	}
}

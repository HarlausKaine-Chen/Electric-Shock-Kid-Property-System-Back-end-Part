package com.entity.view;

import com.entity.MessageInfoEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 消息
 * 返回数据用
 */
public class MessageInfoView extends MessageInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public MessageInfoView(){
	}

	public MessageInfoView(MessageInfoEntity messageInfoEntity){
		try {
			BeanUtils.copyProperties(this, messageInfoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String sname;

	private String aname;

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}
}

package com.entity.view;

import com.entity.NoticeInfoEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 公告信息表
 * 返回数据用
 */
public class NoticeInfoView extends NoticeInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public NoticeInfoView(){
	}

	public NoticeInfoView(NoticeInfoEntity noticeInfoEntity){
		try {
			BeanUtils.copyProperties(this, noticeInfoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

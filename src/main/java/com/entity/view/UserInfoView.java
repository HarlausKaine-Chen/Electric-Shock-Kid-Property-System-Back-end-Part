package com.entity.view;

import com.entity.UserInfoEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 用户信息
 * 返回数据用
 */
public class UserInfoView extends UserInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public UserInfoView(){
	}

	public UserInfoView(UserInfoEntity userInfoEntity){
		try {
			BeanUtils.copyProperties(this, userInfoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

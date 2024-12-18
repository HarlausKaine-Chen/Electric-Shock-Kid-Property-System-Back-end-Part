package com.entity.view;

import com.entity.RepairInfoEntity;
import com.entity.WeFeesEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;


/**
 * 水电费
 返回数据用
 */
public class WeFeesView extends WeFeesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WeFeesView(){
	}

	public WeFeesView(WeFeesEntity weFeesEntity){
		try {
			BeanUtils.copyProperties(this, weFeesEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

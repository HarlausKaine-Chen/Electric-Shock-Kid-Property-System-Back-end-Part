package com.entity.view;

import com.entity.RepairInfoEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 报修信息
 * 返回数据用
 */
public class RepairInfoView extends RepairInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public RepairInfoView(){
	}

	public RepairInfoView(RepairInfoEntity repairInfoEntity){
		try {
			BeanUtils.copyProperties(this, repairInfoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

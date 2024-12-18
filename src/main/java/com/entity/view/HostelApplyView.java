package com.entity.view;

import com.entity.HostelApplyEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 宿舍申请信息
 * 接口用
 */
public class HostelApplyView extends HostelApplyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HostelApplyView(){

	}

	public HostelApplyView(HostelApplyEntity hostelInfoEntity){
		try {
			BeanUtils.copyProperties(this, hostelInfoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

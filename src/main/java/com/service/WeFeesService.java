package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.UserInfoEntity;
import com.entity.WeFeesEntity;
import com.entity.view.RepairInfoView;
import com.entity.view.UserInfoView;
import com.entity.view.WeFeesView;
import com.entity.vo.UserInfoVO;
import com.entity.vo.WeFeesVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 费用信息
 */
public interface WeFeesService extends IService<WeFeesEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<WeFeesVO> selectListVO(Wrapper<WeFeesEntity> wrapper);

	WeFeesVO selectVO(@Param("ew") Wrapper<WeFeesEntity> wrapper);

   	List<WeFeesView> selectListView(Wrapper<WeFeesEntity> wrapper);

	WeFeesView selectView(@Param("ew") Wrapper<WeFeesEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params,Wrapper<WeFeesEntity> wrapper);

	void payUp(Long param1);

	List<String> calcFees(String param1);
}


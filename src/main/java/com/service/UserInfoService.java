package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.RepairInfoEntity;
import com.entity.UserInfoEntity;
import com.entity.view.RepairInfoView;
import com.entity.view.UserInfoView;
import com.entity.vo.RepairInfoVO;
import com.entity.vo.UserInfoVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 用户信息
 */
public interface UserInfoService extends IService<UserInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<UserInfoVO> selectListVO(Wrapper<UserInfoEntity> wrapper);

	UserInfoVO selectVO(@Param("ew") Wrapper<UserInfoEntity> wrapper);

   	List<UserInfoView> selectListView(Wrapper<UserInfoEntity> wrapper);

	UserInfoView selectView(@Param("ew") Wrapper<UserInfoEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params,Wrapper<UserInfoEntity> wrapper);

}


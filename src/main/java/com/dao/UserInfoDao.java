package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.RepairInfoEntity;
import com.entity.UserInfoEntity;
import com.entity.view.RepairInfoView;
import com.entity.view.UserInfoView;
import com.entity.vo.RepairInfoVO;
import com.entity.vo.UserInfoVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 消息
 * 返回数据用
 */
public interface UserInfoDao extends BaseMapper<UserInfoEntity> {
	
	List<UserInfoVO> selectListVO(@Param("ew") Wrapper<UserInfoEntity> wrapper);
	
	UserInfoVO selectVO(@Param("ew") Wrapper<UserInfoEntity> wrapper);
	
	List<UserInfoView> selectListView(@Param("ew") Wrapper<UserInfoEntity> wrapper);

	List<UserInfoView> selectListView(Pagination page,@Param("ew") Wrapper<UserInfoEntity> wrapper);

	UserInfoView selectView(@Param("ew") Wrapper<UserInfoEntity> wrapper);
	
}

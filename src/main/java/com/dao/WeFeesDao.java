package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.UserInfoEntity;
import com.entity.WeFeesEntity;
import com.entity.view.UserInfoView;
import com.entity.view.WeFeesView;
import com.entity.vo.UserInfoVO;
import com.entity.vo.WeFeesVO;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;


/**
 * 消息
 * 返回数据用
 */
public interface WeFeesDao extends BaseMapper<WeFeesEntity> {
	
	List<WeFeesVO> selectListVO(@Param("ew") Wrapper<WeFeesEntity> wrapper);
	
	WeFeesVO selectVO(@Param("ew") Wrapper<WeFeesEntity> wrapper);
	
	List<WeFeesView> selectListView(@Param("ew") Wrapper<WeFeesEntity> wrapper);

	List<WeFeesView> selectListView(Pagination page,@Param("ew") Wrapper<WeFeesEntity> wrapper);

	WeFeesView selectView(@Param("ew") Wrapper<WeFeesEntity> wrapper);

	void payUp(@Param("param1") Long param1);

	List<String> calcFees(@Param("param1") String param1);
	
}

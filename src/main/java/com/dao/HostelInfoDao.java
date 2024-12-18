package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.entity.HostelInfoEntity;
import com.entity.view.HostelInfoView;
import com.entity.vo.HostelInfoVO;
import org.apache.ibatis.annotations.Param;


/**
 * 宿舍信息
 * 返回数据用
 */
public interface HostelInfoDao extends BaseMapper<HostelInfoEntity> {
	
	List<HostelInfoVO> selectListVO(@Param("ew") Wrapper<HostelInfoEntity> wrapper);
	
	HostelInfoVO selectVO(@Param("ew") Wrapper<HostelInfoEntity> wrapper);
	
	List<HostelInfoView> selectListView(@Param("ew") Wrapper<HostelInfoEntity> wrapper);

	List<HostelInfoView> selectListView(Pagination page,@Param("ew") Wrapper<HostelInfoEntity> wrapper);

	HostelInfoView selectView(@Param("ew") Wrapper<HostelInfoEntity> wrapper);

	String selectHostelNo(@Param("param1")Long param1);
}

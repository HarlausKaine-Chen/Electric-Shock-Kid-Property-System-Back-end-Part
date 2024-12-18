package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.HostelApplyEntity;
import com.entity.view.HostelApplyView;
import com.entity.vo.HostelApplyVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 宿舍申请和退宿
 * 返回数据用
 */
public interface HostelApplyDao extends BaseMapper<HostelApplyEntity> {
	
	List<HostelApplyVO> selectListVO(@Param("ew") Wrapper<HostelApplyEntity> wrapper);
	
	HostelApplyVO selectVO(@Param("ew") Wrapper<HostelApplyEntity> wrapper);
	
	List<HostelApplyView> selectListView(@Param("ew") Wrapper<HostelApplyEntity> wrapper);

	List<HostelApplyView> selectListView(Pagination page,@Param("ew") Wrapper<HostelApplyEntity> wrapper);

	HostelApplyView selectView(@Param("ew") Wrapper<HostelApplyEntity> wrapper);

	void updatePro(@Param("param1")String param1,@Param("param2")Long param2,@Param("param3")String param3);
}

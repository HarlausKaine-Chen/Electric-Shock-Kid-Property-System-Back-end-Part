package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.MessageInfoEntity;
import com.entity.NoticeInfoEntity;
import com.entity.RepairInfoEntity;
import com.entity.view.NoticeInfoView;
import com.entity.view.RepairInfoView;
import com.entity.vo.NoticeInfoVO;
import com.entity.vo.RepairInfoVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 消息
 * 返回数据用
 */
public interface RepairInfoDao extends BaseMapper<RepairInfoEntity> {
	
	List<RepairInfoVO> selectListVO(@Param("ew") Wrapper<RepairInfoEntity> wrapper);
	
	RepairInfoVO selectVO(@Param("ew") Wrapper<RepairInfoEntity> wrapper);
	
	List<RepairInfoView> selectListView(@Param("ew") Wrapper<RepairInfoEntity> wrapper);

	List<RepairInfoView> selectListView(Pagination page,@Param("ew") Wrapper<RepairInfoEntity> wrapper);

	RepairInfoView selectView(@Param("ew") Wrapper<RepairInfoEntity> wrapper);

	void updatePro(@Param("param1")String param1,@Param("param2")Long param2);
}

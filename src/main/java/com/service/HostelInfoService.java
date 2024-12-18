package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.HostelInfoEntity;
import com.entity.view.HostelInfoView;
import com.entity.vo.HostelInfoVO;
import com.utils.PageUtils;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


/**
 * 宿舍信息
 */
public interface HostelInfoService extends IService<HostelInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HostelInfoVO> selectListVO(Wrapper<HostelInfoEntity> wrapper);

	HostelInfoVO selectVO(@Param("ew") Wrapper<HostelInfoEntity> wrapper);
   	
   	List<HostelInfoView> selectListView(Wrapper<HostelInfoEntity> wrapper);

	HostelInfoView selectView(@Param("ew") Wrapper<HostelInfoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HostelInfoEntity> wrapper);

	String selectHostelNo(Long param1);
}


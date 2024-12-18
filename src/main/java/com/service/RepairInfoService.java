package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.NoticeInfoEntity;
import com.entity.RepairInfoEntity;
import com.entity.view.NoticeInfoView;
import com.entity.view.RepairInfoView;
import com.entity.vo.NoticeInfoVO;
import com.entity.vo.RepairInfoVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 报修信息
 */
public interface RepairInfoService extends IService<RepairInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<RepairInfoVO> selectListVO(Wrapper<RepairInfoEntity> wrapper);

	RepairInfoVO selectVO(@Param("ew") Wrapper<RepairInfoEntity> wrapper);

   	List<RepairInfoView> selectListView(Wrapper<RepairInfoEntity> wrapper);

	RepairInfoView selectView(@Param("ew") Wrapper<RepairInfoEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params,Wrapper<RepairInfoEntity> wrapper);

	void updatePro(String param1,Long param2);

}


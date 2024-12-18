package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.HostelApplyEntity;
import com.entity.view.HostelApplyView;
import com.entity.vo.HostelApplyVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 宿舍申请和退宿

 */
public interface HostelApplyService extends IService<HostelApplyEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HostelApplyVO> selectListVO(Wrapper<HostelApplyEntity> wrapper);

	HostelApplyVO selectVO(@Param("ew") Wrapper<HostelApplyEntity> wrapper);
   	
   	List<HostelApplyView> selectListView(Wrapper<HostelApplyEntity> wrapper);

	HostelApplyView selectView(@Param("ew") Wrapper<HostelApplyEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HostelApplyEntity> wrapper);

	void updatePro(String param1,Long param2,String param3 );
}


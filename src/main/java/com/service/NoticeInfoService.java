package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.MessageInfoEntity;
import com.entity.NoticeInfoEntity;
import com.entity.view.MessageInfoView;
import com.entity.view.NoticeInfoView;
import com.entity.vo.MessageInfoVO;
import com.entity.vo.NoticeInfoVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 公告
 */
public interface NoticeInfoService extends IService<NoticeInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<NoticeInfoVO> selectListVO(Wrapper<NoticeInfoEntity> wrapper);

	NoticeInfoVO selectVO(@Param("ew") Wrapper<NoticeInfoEntity> wrapper);

   	List<NoticeInfoView> selectListView(Wrapper<NoticeInfoEntity> wrapper);

	NoticeInfoView selectView(@Param("ew") Wrapper<NoticeInfoEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params,Wrapper<NoticeInfoEntity> wrapper);

}


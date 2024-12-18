package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.HostelInfoEntity;
import com.entity.MessageInfoEntity;
import com.entity.view.HostelInfoView;
import com.entity.view.MessageInfoView;
import com.entity.vo.HostelInfoVO;
import com.entity.vo.MessageInfoVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 消息信息
 */
public interface MessageInfoService extends IService<MessageInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<MessageInfoVO> selectListVO(Wrapper<MessageInfoEntity> wrapper);

	MessageInfoVO selectVO(@Param("ew") Wrapper<MessageInfoEntity> wrapper);

   	List<MessageInfoView> selectListView(Wrapper<MessageInfoEntity> wrapper);

	MessageInfoView selectView(@Param("ew") Wrapper<MessageInfoEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params,Wrapper<MessageInfoEntity> wrapper);

}


package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.MessageInfoEntity;
import com.entity.view.MessageInfoView;
import com.entity.vo.MessageInfoVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 消息
 * 返回数据用
 */
public interface MessageInfoDao extends BaseMapper<MessageInfoEntity> {
	
	List<MessageInfoVO> selectListVO(@Param("ew") Wrapper<MessageInfoEntity> wrapper);

	MessageInfoVO selectVO(@Param("ew") Wrapper<MessageInfoEntity> wrapper);
	
	List<MessageInfoView> selectListView(@Param("ew") Wrapper<MessageInfoEntity> wrapper);

	List<MessageInfoView> selectListView(Pagination page,@Param("ew") Wrapper<MessageInfoEntity> wrapper);

	MessageInfoView selectView(@Param("ew") Wrapper<MessageInfoEntity> wrapper);
	
}

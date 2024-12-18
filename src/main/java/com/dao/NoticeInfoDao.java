package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.MessageInfoEntity;
import com.entity.NoticeInfoEntity;
import com.entity.view.HostelInfoView;
import com.entity.view.NoticeInfoView;
import com.entity.vo.HostelInfoVO;
import com.entity.vo.NoticeInfoVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 消息
 * 返回数据用
 */
public interface NoticeInfoDao extends BaseMapper<NoticeInfoEntity> {
	
	List<NoticeInfoVO> selectListVO(@Param("ew") Wrapper<NoticeInfoEntity> wrapper);
	
	NoticeInfoVO selectVO(@Param("ew") Wrapper<NoticeInfoEntity> wrapper);
	
	List<NoticeInfoView> selectListView(@Param("ew") Wrapper<NoticeInfoEntity> wrapper);

	List<NoticeInfoView> selectListView(Pagination page,@Param("ew") Wrapper<NoticeInfoEntity> wrapper);

	NoticeInfoView selectView(@Param("ew") Wrapper<NoticeInfoEntity> wrapper);
	
}

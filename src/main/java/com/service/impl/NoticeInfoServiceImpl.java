package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.MessageInfoDao;
import com.dao.NoticeInfoDao;
import com.entity.NoticeInfoEntity;
import com.entity.NoticeInfoEntity;
import com.entity.view.MessageInfoView;
import com.entity.view.NoticeInfoView;
import com.entity.vo.NoticeInfoVO;
import com.entity.vo.NoticeInfoVO;
import com.service.MessageInfoService;
import com.service.NoticeInfoService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("noticeInfoService")
public class NoticeInfoServiceImpl extends ServiceImpl<NoticeInfoDao, NoticeInfoEntity> implements NoticeInfoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NoticeInfoEntity> page = this.selectPage(
                new Query<NoticeInfoEntity>(params).getPage(),
                new EntityWrapper<NoticeInfoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<NoticeInfoEntity> wrapper) {
		  Page<NoticeInfoView> page =new Query<NoticeInfoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<NoticeInfoVO> selectListVO(Wrapper<NoticeInfoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public NoticeInfoVO selectVO(Wrapper<NoticeInfoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<NoticeInfoView> selectListView(Wrapper<NoticeInfoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public NoticeInfoView selectView(Wrapper<NoticeInfoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

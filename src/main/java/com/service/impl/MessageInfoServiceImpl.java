package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.HostelInfoDao;
import com.dao.MessageInfoDao;
import com.entity.MessageInfoEntity;
import com.entity.MessageInfoEntity;
import com.entity.view.MessageInfoView;
import com.entity.view.MessageInfoView;
import com.entity.vo.MessageInfoVO;
import com.entity.vo.MessageInfoVO;
import com.service.HostelInfoService;
import com.service.MessageInfoService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("messageInfoService")
public class MessageInfoServiceImpl extends ServiceImpl<MessageInfoDao, MessageInfoEntity> implements MessageInfoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MessageInfoEntity> page = this.selectPage(
                new Query<MessageInfoEntity>(params).getPage(),
                new EntityWrapper<MessageInfoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MessageInfoEntity> wrapper) {
		  Page<MessageInfoView> page =new Query<MessageInfoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<MessageInfoVO> selectListVO(Wrapper<MessageInfoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MessageInfoVO selectVO(Wrapper<MessageInfoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MessageInfoView> selectListView(Wrapper<MessageInfoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MessageInfoView selectView(Wrapper<MessageInfoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

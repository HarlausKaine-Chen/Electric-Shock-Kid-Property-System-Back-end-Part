package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.RepairInfoDao;
import com.dao.UserInfoDao;
import com.entity.UserInfoEntity;
import com.entity.UserInfoEntity;
import com.entity.view.RepairInfoView;
import com.entity.view.UserInfoView;
import com.entity.vo.UserInfoVO;
import com.entity.vo.UserInfoVO;
import com.service.RepairInfoService;
import com.service.UserInfoService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("userInfoService")
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfoEntity> implements UserInfoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserInfoEntity> page = this.selectPage(
                new Query<UserInfoEntity>(params).getPage(),
                new EntityWrapper<UserInfoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<UserInfoEntity> wrapper) {
		  Page<UserInfoView> page =new Query<UserInfoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<UserInfoVO> selectListVO(Wrapper<UserInfoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public UserInfoVO selectVO(Wrapper<UserInfoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<UserInfoView> selectListView(Wrapper<UserInfoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public UserInfoView selectView(Wrapper<UserInfoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

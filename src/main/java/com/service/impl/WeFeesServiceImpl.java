package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.WeFeesDao;
import com.entity.WeFeesEntity;
import com.entity.view.WeFeesView;
import com.entity.vo.WeFeesVO;
import com.service.WeFeesService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service("weFeesService")
public class WeFeesServiceImpl extends ServiceImpl<WeFeesDao, WeFeesEntity> implements WeFeesService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WeFeesEntity> page = this.selectPage(
                new Query<WeFeesEntity>(params).getPage(),
                new EntityWrapper<WeFeesEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WeFeesEntity> wrapper) {
		  Page<WeFeesView> page =new Query<WeFeesView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

	@Override
	public void payUp(Long param1) {
		baseMapper.payUp(param1);
	}

	@Override
	public List<String> calcFees(String param1) {
		return baseMapper.calcFees(param1);
	}

	@Override
	public List<WeFeesVO> selectListVO(Wrapper<WeFeesEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WeFeesVO selectVO(Wrapper<WeFeesEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WeFeesView> selectListView(Wrapper<WeFeesEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WeFeesView selectView(Wrapper<WeFeesEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

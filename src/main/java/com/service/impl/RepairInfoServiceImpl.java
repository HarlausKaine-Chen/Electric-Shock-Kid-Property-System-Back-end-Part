package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.NoticeInfoDao;
import com.dao.RepairInfoDao;
import com.entity.RepairInfoEntity;
import com.entity.RepairInfoEntity;
import com.entity.view.RepairInfoView;
import com.entity.view.RepairInfoView;
import com.entity.vo.RepairInfoVO;
import com.entity.vo.RepairInfoVO;
import com.service.NoticeInfoService;
import com.service.RepairInfoService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("repairInfoService")
public class RepairInfoServiceImpl extends ServiceImpl<RepairInfoDao, RepairInfoEntity> implements RepairInfoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RepairInfoEntity> page = this.selectPage(
                new Query<RepairInfoEntity>(params).getPage(),
                new EntityWrapper<RepairInfoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<RepairInfoEntity> wrapper) {
		  Page<RepairInfoView> page =new Query<RepairInfoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

	@Override
	public void updatePro(String param1, Long param2) {
		baseMapper.updatePro(param1,param2);
	}

	@Override
	public List<RepairInfoVO> selectListVO(Wrapper<RepairInfoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public RepairInfoVO selectVO(Wrapper<RepairInfoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<RepairInfoView> selectListView(Wrapper<RepairInfoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public RepairInfoView selectView(Wrapper<RepairInfoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

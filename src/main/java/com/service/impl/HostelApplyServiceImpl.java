package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.HostelApplyDao;
import com.dao.HostelInfoDao;
import com.entity.HostelApplyEntity;
import com.entity.HostelApplyEntity;
import com.entity.view.HostelApplyView;
import com.entity.view.HostelApplyView;
import com.entity.vo.HostelApplyVO;
import com.service.HostelApplyService;
import com.service.HostelInfoService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("hostelApplyService")
public class HostelApplyServiceImpl extends ServiceImpl<HostelApplyDao, HostelApplyEntity> implements HostelApplyService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HostelApplyEntity> page = this.selectPage(
                new Query<HostelApplyEntity>(params).getPage(),
                new EntityWrapper<HostelApplyEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HostelApplyEntity> wrapper) {
		  Page<HostelApplyView> page =new Query<HostelApplyView>(params).getPage();
		  List<HostelApplyView> list = baseMapper.selectListView(page,wrapper);
		  page.setRecords(list);
		  PageUtils pageUtil = new PageUtils(page);
		  return pageUtil;
 	}

	@Override
	public void updatePro(String param1, Long param2,String param3) {
		baseMapper.updatePro(param1,param2,param3);
	}


	@Override
	public List<HostelApplyVO> selectListVO(Wrapper<HostelApplyEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HostelApplyVO selectVO(Wrapper<HostelApplyEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HostelApplyView> selectListView(Wrapper<HostelApplyEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HostelApplyView selectView(Wrapper<HostelApplyEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

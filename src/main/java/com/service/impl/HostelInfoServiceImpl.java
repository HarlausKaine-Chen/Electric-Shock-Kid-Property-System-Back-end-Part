package com.service.impl;

import com.dao.HostelInfoDao;
import com.entity.HostelInfoEntity;
import com.entity.UserInfoEntity;
import com.entity.view.HostelInfoView;
import com.entity.vo.HostelInfoVO;
import com.service.HostelInfoService;
import com.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;



@Service("hostelInfoService")
public class HostelInfoServiceImpl extends ServiceImpl<HostelInfoDao, HostelInfoEntity> implements HostelInfoService {

	@Autowired
	private UserInfoService userInfoService;
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HostelInfoEntity> page = this.selectPage(
                new Query<HostelInfoEntity>(params).getPage(),
                new EntityWrapper<HostelInfoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HostelInfoEntity> wrapper) {
		  Page<HostelInfoView> page =new Query<HostelInfoView>(params).getPage();
		  List<HostelInfoView> list = baseMapper.selectListView(page,wrapper);
		  for (HostelInfoView view:list){

				//床位总数
			  Long num = Long.parseLong(view.getNum());
			  Long knum = num;
			  if (view.getC1() != null && view.getC1()>0){
				  UserInfoEntity entity = userInfoService.selectById(view.getC1());
				  if (null != entity){
					  view.setC1n(entity.getName());
				  }
				  knum = knum - 1;
			  }
			  if (view.getC2() != null && view.getC2()>0){
				  UserInfoEntity entity = userInfoService.selectById(view.getC2());
				  if (null != entity){
					  view.setC2n(entity.getName());
				  }
				  knum = knum - 1;
			  }
			  if (view.getC3() != null && view.getC3()>0){
				  UserInfoEntity entity = userInfoService.selectById(view.getC3());
				  if (null != entity){
					  view.setC3n(entity.getName());
				  }
				  knum = knum - 1;
			  }
			  if (view.getC4() != null && view.getC4()>0){
				  UserInfoEntity entity = userInfoService.selectById(view.getC4());
				  if (null != entity){
					  view.setC4n(entity.getName());
				  }
				  knum = knum - 1;
			  }
			  if (view.getC5() != null && view.getC5()>0){
				  UserInfoEntity entity = userInfoService.selectById(view.getC5());
				  if (null != entity){
					  view.setC5n(entity.getName());
				  }
				  knum = knum - 1;
			  }
			  if (view.getC6() != null && view.getC6()>0){
				  UserInfoEntity entity = userInfoService.selectById(view.getC6());
				  if (null != entity){
					  view.setC6n(entity.getName());
				  }
				  knum = knum - 1;
			  }
			  if (knum > num){
				  knum = num;
			  }
			  view.setKnum(knum.toString());

		  }
	        page.setRecords(list);
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

	@Override
	public String selectHostelNo(Long param1) {
		return baseMapper.selectHostelNo(param1);
	}

	@Override
	public List<HostelInfoVO> selectListVO(Wrapper<HostelInfoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HostelInfoVO selectVO(Wrapper<HostelInfoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HostelInfoView> selectListView(Wrapper<HostelInfoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HostelInfoView selectView(Wrapper<HostelInfoEntity> wrapper) {
		HostelInfoView hostelInfoView = baseMapper.selectView(wrapper);
		if (null == hostelInfoView){
			return null;
		}
		//床位总数
		Long num = Long.parseLong(hostelInfoView.getNum());
		Long knum = num;
		if (hostelInfoView.getC1() != null && hostelInfoView.getC1()>0){
			knum = knum - 1;
		}
		if (hostelInfoView.getC2() != null && hostelInfoView.getC2()>0){
			knum = knum - 1;
		}
		if (hostelInfoView.getC3() != null && hostelInfoView.getC3()>0){
			knum = knum - 1;
		}
		if (hostelInfoView.getC4() != null && hostelInfoView.getC4()>0){
			knum = knum - 1;
		}
		if (hostelInfoView.getC5() != null && hostelInfoView.getC5()>0){
			knum = knum - 1;
		}
		if (hostelInfoView.getC6() != null && hostelInfoView.getC6()>0){
			knum = knum - 1;
		}
		if (knum > num){
			knum = num;
		}
		hostelInfoView.setKnum(knum.toString());

		return hostelInfoView;
	}

}

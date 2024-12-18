package com.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import com.entity.HostelInfoEntity;
import com.entity.UserInfoEntity;
import com.entity.view.HostelInfoView;
import com.service.HostelInfoService;
import com.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;


import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;


/**
 * 宿舍信息
 * 后端接口
 */
@RestController
@RequestMapping("/hostelInfo")
public class HostelInfoController {
    @Autowired
    private HostelInfoService hostelInfoService;
    @Autowired
    private UserInfoService userInfoService;


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HostelInfoEntity hostelInfoEntity,
                  HttpServletRequest request){
        EntityWrapper<HostelInfoEntity> ew = new EntityWrapper<HostelInfoEntity>();
        Long id = (Long)request.getSession().getAttribute("userId");
        UserInfoEntity userInfoEntity = userInfoService.selectById(id);
        String userType = userInfoEntity.getUserType();
        PageUtils page = null;
        if ("领导".equals(userType) || "宿管".equals(userType)){
            page = hostelInfoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, hostelInfoEntity), params), params));
        }
        //学生只能查询自己的数据
        if ("学生".equals(userType)){
            page = hostelInfoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, hostelInfoEntity), params).or().eq("c1",id).or().eq("c2",id).or().eq("c3",id)
                    .or().eq("c4",id).or().eq("c5",id).or().eq("c6",id), params));
        }

        if (page == null){
            return R.error("查询失败");
        }

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HostelInfoEntity hostelInfoEntity, HttpServletRequest request){
        EntityWrapper<HostelInfoEntity> ew = new EntityWrapper<HostelInfoEntity>();
		PageUtils page = hostelInfoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, hostelInfoEntity), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HostelInfoEntity hostelInfoEntity){
       	EntityWrapper<HostelInfoEntity> ew = new EntityWrapper<HostelInfoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( hostelInfoEntity, "hostelInfoEntity")); 
        return R.ok().put("data", hostelInfoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HostelInfoEntity hostelInfoEntity){
        EntityWrapper< HostelInfoEntity> ew = new EntityWrapper< HostelInfoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( hostelInfoEntity, "hostelInfoEntity")); 
		HostelInfoView hostelInfoView =  hostelInfoService.selectView(ew);
		return R.ok("查询信息成功").put("data", hostelInfoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HostelInfoEntity e1 = new HostelInfoEntity();
        e1.setId(id);
        EntityWrapper< HostelInfoEntity> ew = new EntityWrapper< HostelInfoEntity>();
        ew.allEq(MPUtil.allEQMapPre( e1, "hostel_info"));
        HostelInfoView hostelInfoView = hostelInfoService.selectView(ew);
        if (hostelInfoView.getC1() != null && hostelInfoView.getC1()>0){
            UserInfoEntity entity = userInfoService.selectById(hostelInfoView.getC1());
            if (null != entity){
                hostelInfoView.setC1n(entity.getName());
            }
        }
        if (hostelInfoView.getC2() != null && hostelInfoView.getC2()>0){
            UserInfoEntity entity = userInfoService.selectById(hostelInfoView.getC2());
            if (null != entity){
                hostelInfoView.setC2n(entity.getName());
            }
        }
        if (hostelInfoView.getC3() != null && hostelInfoView.getC3()>0){
            UserInfoEntity entity = userInfoService.selectById(hostelInfoView.getC3());
            if (null != entity){
                hostelInfoView.setC3n(entity.getName());
            }
        }
        if (hostelInfoView.getC4() != null && hostelInfoView.getC4()>0){
            UserInfoEntity entity = userInfoService.selectById(hostelInfoView.getC4());
            if (null != entity){
                hostelInfoView.setC4n(entity.getName());
            }
        }
        if (hostelInfoView.getC5() != null && hostelInfoView.getC5()>0){
            UserInfoEntity entity = userInfoService.selectById(hostelInfoView.getC5());
            if (null != entity){
                hostelInfoView.setC5n(entity.getName());
            }
        }
        if (hostelInfoView.getC6() != null && hostelInfoView.getC6()>0){
            UserInfoEntity entity = userInfoService.selectById(hostelInfoView.getC6());
            if (null != entity){
                hostelInfoView.setC6n(entity.getName());
            }
        }
        return R.ok().put("data", hostelInfoView);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HostelInfoEntity hostelInfoEntity = hostelInfoService.selectById(id);
        return R.ok().put("data", hostelInfoEntity);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HostelInfoEntity hostelInfoEntity, HttpServletRequest request){
        hostelInfoService.insert(hostelInfoEntity);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HostelInfoEntity hostelInfoEntity, HttpServletRequest request){
        hostelInfoService.insert(hostelInfoEntity);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody HostelInfoEntity hostelInfoEntity, HttpServletRequest request){
        hostelInfoService.updateById(hostelInfoEntity);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        hostelInfoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<HostelInfoEntity> wrapper = new EntityWrapper<HostelInfoEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = hostelInfoService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}

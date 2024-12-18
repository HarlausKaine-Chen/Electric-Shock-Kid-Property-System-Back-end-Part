package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.HostelApplyEntity;
import com.entity.HostelInfoEntity;
import com.entity.UserInfoEntity;
import com.entity.view.HostelApplyView;
import com.entity.view.HostelInfoView;
import com.service.HostelApplyService;
import com.service.HostelInfoService;
import com.service.UserInfoService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;


/**
 * 宿舍信息
 * 后端接口
 */
@RestController
@RequestMapping("/hostelApply")
public class HostelApplyController {
    @Autowired
    private HostelApplyService hostelApplyService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private HostelInfoService hostelInfoService;

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HostelApplyEntity hostelApplyEntity,
                  HttpServletRequest request){
        EntityWrapper<HostelApplyEntity> ew = new EntityWrapper<HostelApplyEntity>();
        Long id = (Long)request.getSession().getAttribute("userId");
        UserInfoEntity userInfoEntity = userInfoService.selectById(id);
        String userType = userInfoEntity.getUserType();
        PageUtils page = null;
        if ("领导".equals(userType) || "宿管".equals(userType)){
            page = hostelApplyService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, hostelApplyEntity), params), params));
        }
        //学生只能查询自己的数据
        if ("学生".equals(userType)){
            page = hostelApplyService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, hostelApplyEntity), params).and().eq("stu_id",id), params));
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
    public R list(@RequestParam Map<String, Object> params,HostelApplyEntity hostelApplyEntity, HttpServletRequest request){
        EntityWrapper<HostelApplyEntity> ew = new EntityWrapper<HostelApplyEntity>();
		PageUtils page = hostelApplyService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, hostelApplyEntity), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HostelApplyEntity hostelApplyEntity){
       	EntityWrapper<HostelApplyEntity> ew = new EntityWrapper<HostelApplyEntity>();
      	ew.allEq(MPUtil.allEQMapPre( hostelApplyEntity, "hostelApplyEntity")); 
        return R.ok().put("data", hostelApplyService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HostelApplyEntity hostelApplyEntity){
        EntityWrapper< HostelApplyEntity> ew = new EntityWrapper< HostelApplyEntity>();
 		ew.allEq(MPUtil.allEQMapPre( hostelApplyEntity, "hostelApplyEntity")); 
		HostelApplyView hostelApplyView =  hostelApplyService.selectView(ew);
		return R.ok("查询信息成功").put("data", hostelApplyView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HostelApplyEntity hostelApplyEntity = hostelApplyService.selectById(id);
        return R.ok().put("data", hostelApplyEntity);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HostelApplyEntity hostelApplyEntity = hostelApplyService.selectById(id);
        return R.ok().put("data", hostelApplyEntity);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HostelApplyEntity hostelApplyEntity, HttpServletRequest request){
        //查询出这个学生的宿舍编号
        Long id = (Long)request.getSession().getAttribute("userId");
        String hostelNo = hostelInfoService.selectHostelNo(id);
        if (StringUtils.isNotEmpty(hostelNo)) {
            hostelApplyEntity.setHostelNo(hostelNo);
        }
        hostelApplyService.insert(hostelApplyEntity);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HostelApplyEntity hostelApplyEntity, HttpServletRequest request){
        hostelApplyService.insert(hostelApplyEntity);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody HostelApplyEntity hostelApplyEntity, HttpServletRequest request){
        hostelApplyService.updateById(hostelApplyEntity);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        hostelApplyService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<HostelApplyEntity> wrapper = new EntityWrapper<HostelApplyEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = hostelApplyService.selectCount(wrapper);
		return R.ok().put("count", count);
	}

    /**
     * 审核
     */
    @RequestMapping("/updatePro")
    public R updatePro(@RequestBody HostelApplyEntity hostelApplyEntity, HttpServletRequest request){
        //根据宿舍编号查询宿舍是否存在，是否满员
        String applyType = hostelApplyEntity.getApplyType();
        if ("申请".equals(applyType)){
            HostelInfoEntity hostelInfoEntity = new HostelInfoEntity();
            hostelInfoEntity.setHostelNo(hostelApplyEntity.getHostelNo());
            EntityWrapper< HostelInfoEntity> ew = new EntityWrapper< HostelInfoEntity>();
            ew.allEq(MPUtil.allEQMapPre( hostelInfoEntity, "hostel_info"));
            HostelInfoView hostelInfoView = hostelInfoService.selectView(ew);
            if (null == hostelInfoView){
                return R.error("宿舍号不存在");
            }
            if (null == hostelInfoView.getKnum() || "0".equals(hostelInfoView.getKnum())){
                return R.error("该宿舍已满员，无法分配");
            }
            if ("审核通过".equals(hostelApplyEntity.getApplyPro())) {
                HostelInfoEntity hostel = new HostelInfoEntity();
                hostel.setId(hostelInfoView.getId());
                hostel.setHostelName(hostelInfoView.getHostelName());
                hostel.setHostelNo(hostelInfoView.getHostelNo());
                hostel.setNum(hostelInfoView.getNum());
                hostel.setCrtTime(hostelInfoView.getCrtTime());
                if (null == hostelInfoView.getC1() || hostelInfoView.getC1().longValue() == 0) {
                    hostel.setC1(hostelApplyEntity.getStuId());
                } else if (null == hostelInfoView.getC2() || hostelInfoView.getC2().longValue() == 0) {
                    hostel.setC2(hostelApplyEntity.getStuId());
                } else if (null == hostelInfoView.getC3() || hostelInfoView.getC3().longValue() == 0) {
                    hostel.setC3(hostelApplyEntity.getStuId());
                } else if (null == hostelInfoView.getC4() || hostelInfoView.getC4().longValue() == 0) {
                    hostel.setC4(hostelApplyEntity.getStuId());
                } else if (null == hostelInfoView.getC5() || hostelInfoView.getC5().longValue() == 0) {
                    hostel.setC5(hostelApplyEntity.getStuId());
                } else if (null == hostelInfoView.getC6() || hostelInfoView.getC6().longValue() == 0) {
                    hostel.setC6(hostelApplyEntity.getStuId());
                }
                hostelInfoService.updateById(hostel);
            }
        }else{
            if ("审核通过".equals(hostelApplyEntity.getApplyPro())) {
                HostelInfoEntity hostelInfoEntity = new HostelInfoEntity();
                hostelInfoEntity.setHostelNo(hostelApplyEntity.getHostelNo());
                EntityWrapper<HostelInfoEntity> ew = new EntityWrapper<HostelInfoEntity>();
                HostelInfoView hostelInfoView = hostelInfoService.selectView(ew);
                HostelInfoEntity hostel = new HostelInfoEntity();
                hostel.setId(hostelInfoView.getId());
                hostel.setHostelName(hostelInfoView.getHostelName());
                hostel.setHostelNo(hostelInfoView.getHostelNo());
                hostel.setNum(hostelInfoView.getNum());
                hostel.setCrtTime(hostelInfoView.getCrtTime());
                if (hostelApplyEntity.getStuId() == hostelInfoView.getC1()) {
                    hostel.setC1(0L);
                } else if (hostelApplyEntity.getStuId() == hostelInfoView.getC2()) {
                    hostel.setC2(0L);
                } else if (hostelApplyEntity.getStuId() == hostelInfoView.getC3()) {
                    hostel.setC3(0L);
                } else if (hostelApplyEntity.getStuId() == hostelInfoView.getC4()) {
                    hostel.setC4(0L);
                } else if (hostelApplyEntity.getStuId() == hostelInfoView.getC5()) {
                    hostel.setC5(0L);
                } else if (hostelApplyEntity.getStuId() == hostelInfoView.getC6()) {
                    hostel.setC6(0L);
                }
                hostelInfoService.updateById(hostel);
            }
        }
        //先更新数据状态
        String applyPro = hostelApplyEntity.getApplyPro();
        Long hostelApplyId = hostelApplyEntity.getId();
        hostelApplyService.updatePro(applyPro,hostelApplyId,hostelApplyEntity.getHostelNo());
        return R.ok();
    }
	


}

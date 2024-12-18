package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.MessageInfoEntity;
import com.entity.UserInfoEntity;
import com.entity.WeFeesEntity;
import com.entity.WeFeesEntity;
import com.entity.view.RepairInfoView;
import com.entity.view.UserInfoView;
import com.entity.view.WeFeesView;
import com.service.*;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 费用
 * 后端接口
 */
@RestController
@RequestMapping("/weFees")
public class WeFeesController {
    @Autowired
    private WeFeesService weFeesService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private HostelInfoService hostelInfoService;
    @Autowired
    private MessageInfoService messageInfoService;

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, WeFeesEntity weFeesEntity,
                  HttpServletRequest request){
        EntityWrapper<WeFeesEntity> ew = new EntityWrapper<WeFeesEntity>();
        Long id = (Long)request.getSession().getAttribute("userId");
        UserInfoEntity userInfoEntity = userInfoService.selectById(id);
        String userType = userInfoEntity.getUserType();
        //根据学生ID查询出学生所在宿舍
        String hostelNo = hostelInfoService.selectHostelNo(id);
        PageUtils page = null;
        if ("领导".equals(userType) || "宿管".equals(userType)){
            page = weFeesService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weFeesEntity), params), params));
        }
        //学生只能查询自己的数据
        if ("学生".equals(userType)){
            page = weFeesService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weFeesEntity), params).and().eq("hostel_no",hostelNo), params));
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
    public R list(@RequestParam Map<String, Object> params,WeFeesEntity weFeesEntity, HttpServletRequest request){
        EntityWrapper<WeFeesEntity> ew = new EntityWrapper<WeFeesEntity>();
		PageUtils page = weFeesService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weFeesEntity), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WeFeesEntity weFeesEntity){
       	EntityWrapper<WeFeesEntity> ew = new EntityWrapper<WeFeesEntity>();
      	ew.allEq(MPUtil.allEQMapPre( weFeesEntity, "weFeesEntity")); 
        return R.ok().put("data", weFeesService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WeFeesEntity weFeesEntity){
        EntityWrapper< WeFeesEntity> ew = new EntityWrapper< WeFeesEntity>();
 		ew.allEq(MPUtil.allEQMapPre( weFeesEntity, "weFeesEntity")); 
		WeFeesView weFeesView =  weFeesService.selectView(ew);
		return R.ok("查询信息成功").put("data", weFeesView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WeFeesEntity weFeesEntity = weFeesService.selectById(id);
        return R.ok().put("data", weFeesEntity);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WeFeesEntity weFeesEntity = weFeesService.selectById(id);
        return R.ok().put("data", weFeesEntity);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WeFeesEntity weFeesEntity, HttpServletRequest request){
        weFeesService.insert(weFeesEntity);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WeFeesEntity weFeesEntity, HttpServletRequest request){
    	weFeesEntity.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        weFeesService.insert(weFeesEntity);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody WeFeesEntity weFeesEntity, HttpServletRequest request){
        String isPay = weFeesEntity.getIsPay();
        if ("1".equals(isPay)){
            String payDate = dealDate();
            weFeesEntity.setPaydate(payDate);
            //写入消息表
            EntityWrapper<UserInfoEntity> ew = new EntityWrapper<UserInfoEntity>();
            Long id = (Long)request.getSession().getAttribute("userId");
            ew.or().eq("user_type","领导").or().eq("user_type","宿管");
            List<UserInfoView> list = userInfoService.selectListView(ew);
            for (UserInfoView userInfoView:list){
                MessageInfoEntity messageInfoEntity = new MessageInfoEntity();
                messageInfoEntity.setSendId(id);
                messageInfoEntity.setAccpetId(userInfoView.getId());
                messageInfoEntity.setContent("宿舍编号："+weFeesEntity.getHostelNo()+"宿舍的"+weFeesEntity.getMonth()+"月费用已缴纳");
                messageInfoService.insert(messageInfoEntity);
            }
        }
        weFeesService.updateById(weFeesEntity);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        weFeesService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<WeFeesEntity> wrapper = new EntityWrapper<WeFeesEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = weFeesService.selectCount(wrapper);
		return R.ok().put("count", count);
	}

    /**
     * 查询水电费数据
     */
    @RequestMapping("/fees")
    public R query(HttpServletRequest request){
        Long id = (Long)request.getSession().getAttribute("userId");
        UserInfoEntity userInfoEntity = userInfoService.selectById(id);
        String userType = userInfoEntity.getUserType();
        PageUtils page = null;
        List<String> list = null;
        //查询所有
        if ("领导".equals(userType) || "宿管".equals(userType)){
            list  = weFeesService.calcFees(null);
        }else{
            //根据学生ID查询出学生所在宿舍
            String hostelNo = hostelInfoService.selectHostelNo(id);
            list  = weFeesService.calcFees(hostelNo);
        }
        return R.ok("查询信息成功").put("data", list);
    }

    public String dealDate(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }



}

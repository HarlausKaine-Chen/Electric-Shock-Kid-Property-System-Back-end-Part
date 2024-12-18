package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.MessageInfoEntity;
import com.entity.RepairInfoEntity;
import com.entity.UserInfoEntity;
import com.entity.view.RepairInfoView;
import com.entity.view.UserInfoView;
import com.service.MessageInfoService;
import com.service.RepairInfoService;
import com.service.UserInfoService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 报修
 * 后端接口
 */
@RestController
@RequestMapping("/repair")
public class RepairInfoController {
    @Autowired
    private RepairInfoService repairInfoService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private MessageInfoService messageInfoService;
    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, RepairInfoEntity repairInfoEntity,
                  HttpServletRequest request){
        EntityWrapper<RepairInfoEntity> ew = new EntityWrapper<RepairInfoEntity>();
        Long id = (Long)request.getSession().getAttribute("userId");
        UserInfoEntity userInfoEntity = userInfoService.selectById(id);
        String userType = userInfoEntity.getUserType();
        PageUtils page = null;
        if ("领导".equals(userType) || "宿管".equals(userType)){
            page = repairInfoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, repairInfoEntity), params), params));
        }
        //学生只能查询自己的数据
        if ("学生".equals(userType)){
            page = repairInfoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, repairInfoEntity), params).and().eq("user_id",id), params));
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
    public R list(@RequestParam Map<String, Object> params,RepairInfoEntity repairInfoEntity, HttpServletRequest request){
        EntityWrapper<RepairInfoEntity> ew = new EntityWrapper<RepairInfoEntity>();
		PageUtils page = repairInfoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, repairInfoEntity), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RepairInfoEntity repairInfoEntity){
       	EntityWrapper<RepairInfoEntity> ew = new EntityWrapper<RepairInfoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( repairInfoEntity, "repairInfoEntity")); 
        return R.ok().put("data", repairInfoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RepairInfoEntity repairInfoEntity){
        EntityWrapper< RepairInfoEntity> ew = new EntityWrapper< RepairInfoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( repairInfoEntity, "repairInfoEntity")); 
		RepairInfoView repairInfoView =  repairInfoService.selectView(ew);
		return R.ok("查询信息成功").put("data", repairInfoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RepairInfoEntity repairInfoEntity = repairInfoService.selectById(id);
        return R.ok().put("data", repairInfoEntity);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RepairInfoEntity repairInfoEntity = repairInfoService.selectById(id);
        return R.ok().put("data", repairInfoEntity);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RepairInfoEntity repairInfoEntity, HttpServletRequest request){
        repairInfoEntity.setRepairPro("待处理");
        //写入消息表
        EntityWrapper<UserInfoEntity> ew = new EntityWrapper<UserInfoEntity>();
        Long id = (Long)request.getSession().getAttribute("userId");
        ew.or().eq("user_type","领导").or().eq("user_type","宿管");
        List<UserInfoView> list = userInfoService.selectListView(ew);
        for (UserInfoView userInfoView:list){
            MessageInfoEntity messageInfoEntity = new MessageInfoEntity();
            messageInfoEntity.setSendId(id);
            messageInfoEntity.setAccpetId(userInfoView.getId());
            messageInfoEntity.setContent(repairInfoEntity.getName()+"提了一份报修内容，请到报修登记和进度查询功能查看详细信息");
            messageInfoService.insert(messageInfoEntity);
        }
        repairInfoService.insert(repairInfoEntity);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody RepairInfoEntity repairInfoEntity, HttpServletRequest request){
        repairInfoService.insert(repairInfoEntity);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody RepairInfoEntity repairInfoEntity, HttpServletRequest request){
        repairInfoService.updateById(repairInfoEntity);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        repairInfoService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<RepairInfoEntity> wrapper = new EntityWrapper<RepairInfoEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = repairInfoService.selectCount(wrapper);
		return R.ok().put("count", count);
	}

    /**
     * 审核
     */
    @RequestMapping("/updatePro")
    public R updatePro(@RequestBody RepairInfoEntity repairInfoEntity, HttpServletRequest request){
        //写入消息表
        Long id = (Long)request.getSession().getAttribute("userId");
        MessageInfoEntity messageInfoEntity = new MessageInfoEntity();
        messageInfoEntity.setSendId(id);
        messageInfoEntity.setAccpetId(repairInfoEntity.getUserId());
        messageInfoEntity.setContent(repairInfoEntity.getName()+":您提的报修信息已更新进度为"+repairInfoEntity.getRepairPro());
        messageInfoService.insert(messageInfoEntity);
        repairInfoService.updatePro(repairInfoEntity.getRepairPro(),repairInfoEntity.getId());//全部更新
        return R.ok();
    }

}

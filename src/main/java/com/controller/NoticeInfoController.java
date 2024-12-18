package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.NoticeInfoEntity;
import com.entity.view.NoticeInfoView;
import com.service.NoticeInfoService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;


/**
 * 公告
 * 后端接口
 */
@RestController
@RequestMapping("/notice")
public class NoticeInfoController {
    @Autowired
    private NoticeInfoService noticeInfoService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, NoticeInfoEntity noticeInfoEntity,
                  HttpServletRequest request){
        EntityWrapper<NoticeInfoEntity> ew = new EntityWrapper<NoticeInfoEntity>();
		PageUtils page = noticeInfoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, noticeInfoEntity), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,NoticeInfoEntity noticeInfoEntity, HttpServletRequest request){
        EntityWrapper<NoticeInfoEntity> ew = new EntityWrapper<NoticeInfoEntity>();
		PageUtils page = noticeInfoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, noticeInfoEntity), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( NoticeInfoEntity noticeInfoEntity){
       	EntityWrapper<NoticeInfoEntity> ew = new EntityWrapper<NoticeInfoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( noticeInfoEntity, "noticeInfoEntity")); 
        return R.ok().put("data", noticeInfoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(NoticeInfoEntity noticeInfoEntity){
        EntityWrapper< NoticeInfoEntity> ew = new EntityWrapper< NoticeInfoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( noticeInfoEntity, "noticeInfoEntity")); 
		NoticeInfoView messageInfoView =  noticeInfoService.selectView(ew);
		return R.ok("查询信息成功").put("data", messageInfoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        NoticeInfoEntity noticeInfoEntity = noticeInfoService.selectById(id);
        return R.ok().put("data", noticeInfoEntity);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        NoticeInfoEntity noticeInfoEntity = noticeInfoService.selectById(id);
        return R.ok().put("data", noticeInfoEntity);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NoticeInfoEntity noticeInfoEntity, HttpServletRequest request){
        noticeInfoService.insert(noticeInfoEntity);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody NoticeInfoEntity noticeInfoEntity, HttpServletRequest request){
        noticeInfoService.insert(noticeInfoEntity);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody NoticeInfoEntity noticeInfoEntity, HttpServletRequest request){
        noticeInfoService.updateById(noticeInfoEntity);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        noticeInfoService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<NoticeInfoEntity> wrapper = new EntityWrapper<NoticeInfoEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = noticeInfoService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}

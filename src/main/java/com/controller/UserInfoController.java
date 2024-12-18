package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.UserInfoEntity;
import com.entity.view.UserInfoView;
import com.service.HostelInfoService;
import com.service.TokenService;
import com.service.UserInfoService;
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
 *
 * 后端接口
 * 用户
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;
    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String account, String password, String role, HttpServletRequest request) {
		UserInfoEntity user = userInfoService.selectOne(new EntityWrapper<UserInfoEntity>().eq("account", account).eq("user_type",role));
		if(user==null || !user.getPassword().equals(password)) {
			return R.error("账号或密码不正确或未分配权限");
		}
		
		String token = tokenService.generateToken(user.getId(), account,"user",  role );
		return R.ok().put("token", token);
	}
	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody UserInfoEntity userInfoEntity){
		UserInfoEntity user = userInfoService.selectOne(new EntityWrapper<UserInfoEntity>().eq("account", userInfoEntity.getAccount()));
		if(user!=null) {
			return R.error("注册用户已存在");
		}
        userInfoService.insert(userInfoEntity);
        return R.ok();
    }
	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        UserInfoEntity user = userInfoService.selectById(id);
        return R.ok().put("data", user);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	UserInfoEntity user = userInfoService.selectOne(new EntityWrapper<UserInfoEntity>().eq("account", username));
    	if(user==null) {
    		return R.error("账号不存在");
    	}
        user.setPassword("123456");
		userInfoService.updateById(user);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,UserInfoEntity userInfoEntity,
		HttpServletRequest request){
		Long id = (Long)request.getSession().getAttribute("userId");
		UserInfoEntity user = userInfoService.selectById(id);
		String userType = user.getUserType();
		EntityWrapper<UserInfoEntity> ew = new EntityWrapper<UserInfoEntity>();
		PageUtils page = null;
		//如果是领导，查询所有数据
		if ("领导".equals(userType)){
			page = userInfoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, userInfoEntity), params), params));
		}
		//学生只能查询自己的数据
		if ("学生".equals(userType)){
			page = userInfoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, userInfoEntity), params).eq("account",user.getAccount()), params));
		}
		//宿管能查询学生和宿管的数据
		if ("宿管".equals(userType)){
			page = userInfoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, userInfoEntity), params).ne("user_type","领导"), params));
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
    public R list(@RequestParam Map<String, Object> params,UserInfoEntity yuangong, HttpServletRequest request){
        EntityWrapper<UserInfoEntity> ew = new EntityWrapper<UserInfoEntity>();
		PageUtils page = userInfoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuangong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( UserInfoEntity userInfoEntity){
       	EntityWrapper<UserInfoEntity> ew = new EntityWrapper<UserInfoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( userInfoEntity, "user"));
        return R.ok().put("data", userInfoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(UserInfoEntity userInfoEntity){
        EntityWrapper< UserInfoEntity> ew = new EntityWrapper< UserInfoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( userInfoEntity, "user"));
		UserInfoView userInfoView =  userInfoService.selectView(ew);
		return R.ok("查询数据成功").put("data", userInfoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        UserInfoEntity userInfoEntity = userInfoService.selectById(id);
        return R.ok().put("data", userInfoEntity);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
		UserInfoEntity userInfoEntity = userInfoService.selectById(id);
        return R.ok().put("data", userInfoEntity);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody UserInfoEntity userInfoEntity, HttpServletRequest request){

		UserInfoEntity user = userInfoService.selectOne(new EntityWrapper<UserInfoEntity>().eq("account", userInfoEntity.getAccount()));
		if(user!=null) {
			return R.error("用户已存在");
		}
        userInfoService.insert(userInfoEntity);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody UserInfoEntity userInfoEntity, HttpServletRequest request){
		userInfoEntity.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuangong);
		UserInfoEntity user = userInfoService.selectOne(new EntityWrapper<UserInfoEntity>().eq("account", userInfoEntity.getAccount()));
		if(user!=null) {
			return R.error("用户已存在");
		}
		userInfoEntity.setId(new Date().getTime());
		userInfoService.insert(userInfoEntity);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody UserInfoEntity userInfoEntity, HttpServletRequest request){
		userInfoEntity.setUpTime(new Date());
		userInfoService.updateById(userInfoEntity);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        userInfoService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<UserInfoEntity> wrapper = new EntityWrapper<UserInfoEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = userInfoService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}

package com.dzh.foodrs.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dzh.foodrs.po.User;
import com.dzh.foodrs.po.UserInfo;
import com.dzh.foodrs.repository.RoleRepository;
import com.dzh.foodrs.service.UserInfoService;
import com.dzh.foodrs.service.UserService;
import com.dzh.foodrs.util.JsonDataUtil;
import com.dzh.foodrs.vo.LoginVo;
import com.dzh.foodrs.vo.UserVo;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	private User user;
	private UserInfo userInfo;
	@Autowired
	private UserService userService;
	@Autowired
	private UserInfoService userInfoService;
//	下面的这个Repository略微不规范应该搞service
	@Autowired
	private RoleRepository roleRepository;
	 @RequestMapping("/register")
	    public Map<String, Object> register(@Valid @RequestBody UserVo userVo){
		 	user = new User();
		 	userInfo = new UserInfo();
		 	if (userService.findOneUser(userVo.getUsername())==null) {
				if (userVo.getPassword().equals(userVo.getRpassword())) {
					user.setId(userVo.getUsername());
				 	user.setPassword(userVo.getPassword());
				 	user.setUsername(userVo.getNickname());
				 	userInfo.setName(userVo.getNickname());
				 	userInfo.setId(userVo.getUsername());
				 	userInfoService.saveUserInfo(userInfo);
				 	user.setRole(roleRepository.findOne(1));
				 	userService.saveUser(user);
				 	return JsonDataUtil.toMapCorrectly("1", "注册成功", user);
				}else {
					return JsonDataUtil.toMapCorrectly("2", "密码不一致", null);
				}
			}
		 	return JsonDataUtil.toMapCorrectly("0", "用户已注册", null);
	        
	    }
	 @RequestMapping("/registercheckuser")
	    public Map<String, Object> registercheckuser(@Valid @RequestBody String username){
		 	
		 	if (userService.findOneUser(username)==null) {
				 return JsonDataUtil.toMapCorrectly("1", "账号可用", null);
		 	}
			return JsonDataUtil.toMapCorrectly("0", "用户已注册", null);
	    }
	 @RequestMapping("/login")
	    public Map<String, Object> login(@Valid @RequestBody LoginVo loginVo,HttpSession session){
		 	user =userService.findOneUser(loginVo.getId());
		 	PasswordEncoder encoder = new Md5PasswordEncoder();
//		 	System.out.println(user.getUserInfo().getAddress());
		 	if (user!=null) {
		 		
				if (user.getPassword().equals(encoder.encodePassword(loginVo.getPassword(),null))){
					session.setAttribute("user", user);
					return JsonDataUtil.toMapCorrectly("1", "登录成功", user);
				} 
				return JsonDataUtil.toMapCorrectly("2", "密码错误", null);
			}
			return JsonDataUtil.toMapCorrectly("2", "账号不存在", null);
	    }
	 @RequestMapping("/loginout")
	    public Map<String, Object> loginout(HttpSession session){
		 	if (session.getAttribute("user")!=null) {
		 		session.removeAttribute("user");
			 	return JsonDataUtil.toMapCorrectly("1", "注销成功", null);
			}
		 		return JsonDataUtil.toMapCorrectly("2", "根本没登录", null);
	    }
	 
	 @RequestMapping("/userinfo-get")
	    public Map<String, Object> getUserinfo(@Valid @RequestBody UserInfo userInfo){
		 System.out.println(userInfo.getId());
		 UserInfo userInfo2 = userInfoService.findOneUserInfo(userInfo.getId());
		 	return JsonDataUtil.toMapCorrectly("1", "获取成功",userInfo2 );
	    }
}

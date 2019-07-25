package com.bawei.cms.web.controllers;


import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bawei.cms.domain.User;
import com.bawei.cms.enums.Gender;
import com.bawei.cms.service.IUserService;
import com.bawei.cms.web.forms.UserForm;
import com.bawei.cms.web.forms.UserProfileForm;
import com.bawei.common.utils.AssertUtil;
import com.bawei.common.utils.AssertionException;
import com.bawei.web.Constant;

/**
 * <p>
 * 系统用户表 前端控制器
 * </p>
 *
 * @author bawei
 * @since 2019-07-21
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/home")
	public ModelAndView showUserHomeView() {
		ModelAndView mav = new ModelAndView("user-space/home");
		
		return mav;
	}
	
	@GetMapping("/reg")
	public ModelAndView showUserRegisteryView() {
		ModelAndView mav = new ModelAndView("passport/reg");
		UserForm userForm = new UserForm();
		mav.addObject("userForm", userForm);
		return mav;
	}
	
	@PostMapping("/reg")
	public ModelAndView userRegistery(@ModelAttribute("userForm") UserForm userForm, 
			RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView();
		
		// 对注册参数进行合法性断言
		try {
			AssertUtil.assertHasLength(userForm.getUsername(), "用户名不能为空");
			AssertUtil.assertHasLength(userForm.getPassword(), "登录密码不能为空");
			AssertUtil.assertTrue(userForm.getPassword().equals(userForm.getRePassword()), "密码两次输入不一致");
			
			User user = userService.register(userForm.getUsername(),userForm.getPassword(),userForm.getGender());
			userForm.setPassword("");
			//redirectAttributes.addFlashAttribute("userForm", userForm);
			
			mav.setViewName("redirect:/user/login?username="+userForm.getUsername());
			
		} catch (AssertionException e) {
			mav.addObject("message", e.getMessage());
			mav.setViewName("passport/reg");
		}
		
		return mav;
		
		
	}
	
	@GetMapping("/login")
	public ModelAndView showUserLoginView(@RequestParam(required = false) String username) {
		ModelAndView mav = new ModelAndView("passport/login");
		
		UserForm userForm = new UserForm();
		userForm.setUsername(username);
		mav.addObject("userForm", userForm);
		
		return mav;
	}
	
	@PostMapping("/login")
	public ModelAndView userLogin(@ModelAttribute("userform") UserForm userForm,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		try {
			AssertUtil.assertHasLength(userForm.getUsername(), "用户名不能为空");
			AssertUtil.assertHasLength(userForm.getPassword(), "登录密码不能为空");
			
			User user = userService.login(userForm.getUsername(), userForm.getPassword());
			
			AssertUtil.assertNotNull(user, "用户不存在");
			
			session.setAttribute(Constant.LOGIN_USER, user);
			
			mav.setViewName("user-space/home");
		} catch (AssertionException e) {
			mav.addObject("message", e.getMessage());
			mav.setViewName("passport/login");
		}
		
		return mav;
	}
	
	@GetMapping("/profile")
	public ModelAndView showUserProfilePage(HttpSession session) {
		ModelAndView mav = new ModelAndView("user-space/profile");
		
		try {
			User currentUser = (User) session.getAttribute(Constant.LOGIN_USER);
			
			User user = userService.getUnLockedUser(currentUser.getId());
			
			UserProfileForm userForm = new UserProfileForm();
			
			userForm.setId(user.getId());
			userForm.setUsername(user.getUsername());
			userForm.setNickname(user.getNickname());
			userForm.setBirthday(user.getBirthday());
			userForm.setGender(user.getGender() == 1?Gender.MALE:Gender.FAMALE);
			
			mav.addObject("userForm", userForm);
		} catch (Exception e) {
			mav.addObject("message", e.getMessage());
			mav.setViewName("redirect:/user/login");
		}
		
		return mav;
	}
	
	@PostMapping("/profile")
	public ModelAndView updateUserProfile(@ModelAttribute("userForm") UserProfileForm userForm) {
		ModelAndView mav = new ModelAndView();
		
		try {
			AssertUtil.assertHasLength(userForm.getUsername(), "用户名不能为空");
			AssertUtil.assertHasLength(userForm.getNickname(), "昵称不能为空");
			
			User user = new User();
			user.setId(userForm.getId());
			user.setBirthday(userForm.getBirthday());
			user.setGender(userForm.getGender() == Gender.MALE ? 1:0);
			user.setNickname(userForm.getNickname());
			user.setUpdated(new Date());
			
			boolean result = userService.saveOrUpdate(user);
			
			AssertUtil.assertTrue(result, "用户信息保存失败");
		} catch (Exception e) {
			mav.addObject("message", e.getMessage());
		}
		
		
		// 无论怎样的结果，都回到个设置页面，同时回显表单个人信息。
		mav.addObject("userForm", userForm);
		mav.setViewName("user-space/profile");
		return mav;
	}
	
	@GetMapping("/profile/avatar")
	public ModelAndView showUserAvatorPage(HttpSession session) {
		ModelAndView mav = new ModelAndView("user-space/avatar");
		User user = (User) session.getAttribute(Constant.LOGIN_USER);
		return mav;
	}
	
	@GetMapping("/comments")
	public ModelAndView showUserComments(HttpSession session) {
		ModelAndView mav = new ModelAndView("user-space/comments");
		
		
		
		return mav;
	}
}

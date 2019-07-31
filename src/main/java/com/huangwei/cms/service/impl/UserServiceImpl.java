package com.huangwei.cms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.SelectOne;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huangwei.cms.dao.UserMapper;
import com.huangwei.cms.domain.User;
import com.huangwei.cms.enums.Gender;
import com.huangwei.cms.service.IUserService;
import com.huangwei.common.utils.AssertUtil;
import com.huangwei.web.Constant;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author bawei
 * @since 2019-07-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

	/**
	 * 用户信息注册方法实现
	 */
	@Override
	public User register(String username, String password, Gender gender) {
		User result = null;
		
		User user = new User();
		
		// 对该 方法传入参数的断言
		AssertUtil.assertHasLength(username, "用户名不能为空");
		AssertUtil.assertHasLength(password, "登录密码不能为空");
		AssertUtil.assertNotNull(gender, "用户性别不能为空");
	
		
		// 判断注册的用户名是否重复
		int userCount = this.count((new QueryWrapper<User>()).eq("username", username));
		System.out.println(userCount);
		AssertUtil.assertTrue(userCount==0, "用户名已存在");
		
		// 使用传入的参数，填充user对象
		
		user.setUsername(username);
		
		// 使用MD5加密用户密码用于保存。通过结合用户名、密码和加密盐，使MD5摘要信息更强壮。
		String base = username + Constant.SALT + password;
		user.setPassword(DigestUtils.md5DigestAsHex(base.getBytes()));
		
		user.setNickname(username);
		user.setGender(gender==Gender.MALE?1:0);
		user.setBirthday(null);
		user.setLocked(false);
		user.setCreated(new Date());
		user.setUpdated(user.getCreated());
		
		if(this.save(user)) {
			result = new User();
			BeanUtils.copyProperties(user, result, "password");
		}
		
		return result;
	}

	/**
	 * 用户登录实现
	 */
	@Override
	public User login(String username, String password) {
		User result = null;
		
		// 对输入参数进行断言处理
		AssertUtil.assertHasLength(username, "用户名不能为空");
		AssertUtil.assertHasLength(password, "登录密码不能为空");
		
		// 计算密码摘要
		String pass = DigestUtils.md5DigestAsHex((username+Constant.SALT+password).getBytes());
		
		// 根据用户名和密码查询用户
		User user = this.getOne(
				new QueryWrapper<User>()
						.eq("username", username)
						.eq("password", pass));
		
		// 对查询出的用户对象进行断言处理
		AssertUtil.assertNotNull(user, "用户不存在");
		
		// 将查询出的信息作为副本返回给调用者。
		result = new User();
		
		BeanUtils.copyProperties(user, result, "password");
		
		return result;
	}

	@Override
	public User getUnLockedUser(Integer id) {
		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
		
		queryWrapper.eq("id", id).eq("locked", 0);
		
		User user = this.getOne(queryWrapper);
		
		AssertUtil.assertNotNull(user, "用户被锁定");
		
		User result = new User();
		BeanUtils.copyProperties(user, result);
		
		return result;
	}

}

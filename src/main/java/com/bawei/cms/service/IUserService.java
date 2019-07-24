package com.bawei.cms.service;

import com.bawei.cms.domain.User;
import com.bawei.cms.enums.Gender;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author bawei
 * @since 2019-07-21
 */
public interface IUserService extends IService<User> {

	/**
	 * 注册用户信息
	 * @param username 注册的用户名
	 * @param password 注册用户的PASSWORD
	 * @param gender   注册用户的性别
	 * @return 注册成功后，返回用户实体对象
	 */
	User register(String username, String password, Gender gender);

	User login(String username, String password);

}

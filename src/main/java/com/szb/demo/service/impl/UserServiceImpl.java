package com.szb.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.szb.demo.business.IUserBusiness;
import com.szb.demo.data.User;
import com.szb.demo.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserBusiness userBusiness;
	
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userBusiness.getUserById(userId);
	}
	
	@Override
	public int insert(User record) {
		return userBusiness.insert(record);
	}
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return userBusiness.deleteByPrimaryKey(id);
	}
	
	@Override
	public List<User> selectUserAll() {
		return userBusiness.selectUserAll();
	}
	
	@Override
	public int updateByPrimaryKeySelective(User record) {
		return userBusiness.updateByPrimaryKeySelective(record);
	}
}

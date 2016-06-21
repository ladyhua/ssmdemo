package com.szb.demo.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.szb.demo.business.IUserBusiness;
import com.szb.demo.dao.IUserDao;
import com.szb.demo.data.User;
@Component
public class UserBusinessImpl implements IUserBusiness {
	@Resource
	private IUserDao userDao;
	
	@Override
	public User getUserById(int userId) {
		return userDao.selectByPrimaryKey(userId);
	}
	
	@Override
	public int insert(User record) {
		return userDao.insert(record);
	}
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return userDao.deleteByPrimaryKey(id);
	}
	
	@Override
	public List<User> selectUserAll() {
		return userDao.selectUserAll();
	}
	
	@Override
	public int updateByPrimaryKeySelective(User record) {
		return userDao.updateByPrimaryKeySelective(record);
	}
}

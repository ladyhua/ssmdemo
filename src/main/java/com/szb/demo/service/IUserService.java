package com.szb.demo.service;

import java.util.List;

import com.szb.demo.data.User;

public interface IUserService {
	public User getUserById(int userId);
	
	public int insert(User record);
	
	public int deleteByPrimaryKey(Integer id);
	
	public List<User> selectUserAll();
	
	public int updateByPrimaryKeySelective(User record);
}

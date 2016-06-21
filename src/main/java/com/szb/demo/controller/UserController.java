package com.szb.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.szb.demo.data.User;
import com.szb.demo.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;
	
	private User user;
	
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}
	@Resource(name="user")
	public void setUser(User user) {
		this.user = user;
	}

	@RequestMapping("/showUser")
	public void toIndex(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException{
		int userId = Integer.parseInt(request.getParameter("id"));
		//String password = request.getParameter("password");
		//System.out.println(password);
		User user = this.userService.getUserById(userId);
		Gson gson = new Gson();
		String json = gson.toJson(user);
		System.out.println(json);
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
		out.close();
		
	}
	
	@RequestMapping("/addUser")
	public String addUser(HttpServletRequest request,HttpServletRequest response) {
		int userId = Integer.parseInt(request.getParameter("id"));
		System.out.println("add: " + userId);
		user.setId(userId);
		user.setPassword(request.getParameter("password"));
		user.setUserName(request.getParameter("userName"));
		user.setAge(Integer.parseInt(request.getParameter("age")));
		int i;
		i = userService.insert(user);
		if(i>0){
			return "addUserSuccess";
		} else {
			return "addUserError";
		}
	}
	
	@RequestMapping("/deleteUser")
	public String deleteUser(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		System.out.println("delete: "+ userId);
		int i = userService.deleteByPrimaryKey(userId);
		if(i>0) {
			return "deleteUserSuccess";
		}else {
			return "deleteUserError";
		}
	}
	
	@RequestMapping("/selectUserAll") 
	public void selectUserAll (HttpServletRequest request,HttpServletResponse response) throws IOException {
		List<User> list = userService.selectUserAll();
		Gson gson = new Gson();
		String json = gson.toJson(list);
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
		out.close();
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("update: "+id);
		user.setId(id);
		String password = request.getParameter("password");
		//System.out.println(password != "");
		//System.out.println(password);
		user.setPassword(password);
		user.setUserName(request.getParameter("userName"));
		user.setAge(Integer.parseInt(request.getParameter("age")));
		int i = userService.updateByPrimaryKeySelective(user);
		if(i>0) {
			return "updateUserSuccess";
		} else {
			return "updateUserError";
		}
	}
}

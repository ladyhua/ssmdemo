<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% String context = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<a href="<%=context %>/user/selectUserAll">查询所有用户</a><br/>
<a href="<%=context %>/inputSelectId.jsp">通过ID查询单个用户</a><br/>
<a href="<%=context %>/addUser.jsp">添加用户</a><br/>
<a href="<%=context %>/inputDeleteId.jsp">删除用户</a><br/>
<a href="<%=context %>/inputUpdateData.jsp">修改用户信息</a><br/>
</body>
</html>

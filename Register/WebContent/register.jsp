<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<style type="text/css">
.db{
  width:600px;
  height:300px;
  border:1px soild red;
  position: absolute;
  top: 460px;
  left:360px;
}
ul {
	list-style: none; 
	margin: 0px; 
	padding: 5px;
}

li {
	padding: 5px; 
}
.picbutton{
   background-image: url(images/back.jpg);
   height: 23px;
   width: 82px; 
   font-size: 14px;	  
}
</style>
</head>
<body>
<%@ include file="model.jsp" %>
<center>
	<div class="db">
	<p style="font-size:25px">登&nbsp;&nbsp;录</p>
	<form action="register.jsp" method="post">
	<ul>
		<li>昵称：<input type="text" name="id" ></li><br/>
		<li>学校：<input type="text" name="school" ></li><br/>
		<li>密码：<input type="password" name="password" ></li>
		<li><input type="submit" value="登录"  class="picbutton"></li>
	</ul>
	</form>
	</div>
</center>
</body>
</html>
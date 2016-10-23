<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>登陆</title>
	<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
	<style type="text/css">
	   body {
	    background: url('http://i.imgur.com/Eor57Ae.jpg') no-repeat fixed center center;
	    background-size: cover;
	    font-family: Montserrat;
	}
	
	.logo {
	    width: 213px;
	    height: 36px;
	    background: url('http://i.imgur.com/fd8Lcso.png') no-repeat;
	    margin: 30px auto;
	}
	
	.login-block {
	    width: 320px;
	    padding: 20px;
	    background: #fff;
	    border-radius: 5px;
	    border-top: 5px solid #ff656c;
	    margin: 0 auto;
	}
	
	.login-block h1 {
	    text-align: center;
	    color: #000;
	    font-size: 18px;
	    text-transform: uppercase;
	    margin-top: 0;
	    margin-bottom: 20px;
	}
	
	.login-block input {
	    width: 100%;
	    height: 42px;
	    box-sizing: border-box;
	    border-radius: 5px;
	    border: 1px solid #ccc;
	    margin-bottom: 20px;
	    font-size: 14px;
	    font-family: Montserrat;
	    padding: 0 20px 0 50px;
	    outline: none;
	}
	
	.login-block input#username {
	    background: #fff url('http://i.imgur.com/u0XmBmv.png') 20px top no-repeat;
	    background-size: 16px 80px;
	}
	
	.login-block input#username:focus {
	    background: #fff url('http://i.imgur.com/u0XmBmv.png') 20px bottom no-repeat;
	    background-size: 16px 80px;
	}
	
	.login-block input#password {
	    background: #fff url('http://i.imgur.com/Qf83FTt.png') 20px top no-repeat;
	    background-size: 16px 80px;
	}
	
	.login-block input#password:focus {
	    background: #fff url('http://i.imgur.com/Qf83FTt.png') 20px bottom no-repeat;
	    background-size: 16px 80px;
	}
	
	.login-block input:active, .login-block input:focus {
	    border: 1px solid #ff656c;
	}
	
	.login-block button {
	    width: 100%;
	    height: 40px;
	    background: #ff656c;
	    box-sizing: border-box;
	    border-radius: 5px;
	    border: 1px solid #e15960;
	    color: #fff;
	    font-weight: bold;
	    text-transform: uppercase;
	    font-size: 14px;
	    font-family: Montserrat;
	    outline: none;
	    cursor: pointer;
	}
	
	.login-block button:hover {
	    background: #ff7b81;
	}
	</style>
</head>
<body>
	<form action="login_check" method="post">
	<div class="logo"></div>
	    <div class="login-block">
	    <h1>登陆</h1>
	    <input type="text" value="" placeholder="用户名" name="username" id="username" />
	    <input type="password" value="" placeholder="密    码" name="password" id="password" />
	    <button>提    交</button>
	</div>
	<!-- 登陆失败显示错误信息 -->
    <center>${ error }</center>
	</form>
</body>
</html>
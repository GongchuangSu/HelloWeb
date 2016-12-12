<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap-responsive.min.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/font-awesome.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/uniform.css" type="text/css"/>	
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/select2.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/unicorn.main.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/unicorn.grey.css"  type="text/css"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>首页-表格</title>
</head>
<body>
	<div id="header">
		<h1><a href=".">Home</a></h1>		
	</div>
	<div id="search">
			<input type="text" placeholder="请输入搜索内容..."/>
			<button type="submit" class="tip-right" title="Search">
				<i class="icon-search icon-white"></i>
			</button>
	</div>
	<div id="user-nav" class="navbar navbar-inverse">
           <ul class="nav btn-group">
               <li class="btn btn-inverse">
				   <a title="" href="#"><i class="icon icon-user"></i> <span class="text">个人资料</span></a>
               </li>
               <li class="btn btn-inverse dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">消息</span> <span class="label label-important">5</span> <b class="caret"></b></a>
                   <ul class="dropdown-menu">
                       <li><a class="sAdd" title="" href="#">新消息</a></li>
                       <li><a class="sInbox" title="" href="#">收件箱</a></li>
                       <li><a class="sOutbox" title="" href="#">发件箱</a></li>
                       <li><a class="sTrash" title="" href="#">发送</a></li>
                   </ul>
               </li>
               <li class="btn btn-inverse"><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">设置</span></a></li>
               <li class="btn btn-inverse"><a title="" href="login.html"><i class="icon icon-share-alt"></i> <span class="text">退出</span></a></li>
           </ul>
       </div>
	<div id="sidebar">
		<a href="." class="visible-phone"><i class="icon icon-home"></i>首页</a>
		<ul>
			<li ><a href="."><i class="icon icon-home"></i> <span>首页</span></a></li>
			<li class="submenu">
				<a href="#"><i class="icon icon-th-list"></i> <span>表单组件</span> <span class="label">3</span></a>
				<ul>
					<li><a href="form-common.html">通用组件</a></li>
					<li><a href="form-validation.html">表单验证</a></li>
					<li><a href="form-wizard.html">表单提示</a></li>
				</ul>
			</li>
			<li><a href="buttons.html"><i class="icon icon-tint"></i> <span>按钮 &amp; 图标</span></a></li>
			<li><a href="interface.html"><i class="icon icon-pencil"></i> <span>UI元素</span></a></li>
			<li class="active"><a href="tables.html"><i class="icon icon-th"></i> <span>表格</span></a></li>
			<li><a href="grid.html"><i class="icon icon-th-list"></i> <span>网格布局</span></a></li>
			<li class="submenu">
				<a href="#"><i class="icon icon-file"></i> <span>其他页面</span> <span class="label">4</span></a>
				<ul>
					<li><a href="invoice.html">清单</a></li>
					<li><a href="chat.html">聊天</a></li>
					<li><a href="calendar.html">日历</a></li>
					<li><a href="gallery.html">相册</a></li>
				</ul>
			</li>
			<li>
				<a href="charts.html"><i class="icon icon-signal"></i> <span>图表统计</span></a>
			</li>
			<li>
				<a href="widgets.html"><i class="icon icon-inbox"></i> <span>插件</span></a>
			</li>
		</ul>
	
	</div>
		
	<div id="style-switcher">
		<i class="icon-arrow-left icon-white"></i>
		<span>Style:</span>
		<a href="#grey" style="background-color: #555555;border-color: #aaaaaa;"></a>
		<a href="#blue" style="background-color: #2D2F57;"></a>
		<a href="#red" style="background-color: #673232;"></a>
	</div>
		
	<div id="content">
		<div id="content-header">
			<h1>表格</h1>
		</div>
		<div id="breadcrumb">
			<a href="." title="返回首页" class="tip-bottom"><i class="icon-home"></i> 首页</a>
			<a href="tables" class="current">表格</a>
		</div>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">					
					<div class="widget-box">
						<div class="widget-title">
							<h5>用户信息</h5>
						</div>
						<div class="widget-content nopadding">
							<table class="table table-bordered data-table">
								<thead>
									<tr>
										<th>用户名</th> 
										<th>性别</th>
										<th>手机号</th>
										<th>地址</th>									
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${userList}" var="user">
									<tr>
										<td>${user.username}</td>
										<td>${user.sex}</td>
										<td>${user.phonenumber}</td>
										<td>${user.emailaddress}</td>										
									</tr>
								</c:forEach>
								</tbody>								
							</table>  
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row-fluid">
			<div id="footer" class="span12">
				2011-2016 &copy; By GongchuangSu. 
			</div>
		</div>		
	</div>
    <script src="<%=request.getContextPath()%>/static/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/jquery.ui.custom.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/jquery.uniform.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/select2.min.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/jquery.dataTables.min.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/unicorn.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/unicorn.tables.js"></script>
</body>
</html>
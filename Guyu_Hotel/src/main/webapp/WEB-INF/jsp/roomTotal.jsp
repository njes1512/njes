<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主界面</title>

<!-- 引入css文件 -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/jquery-easyui-1.4/themes/default/easyui.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/jquery-easyui-1.4/themes/icon.css">
<!-- 引入js文件 -->
<script type="text/javascript" src="<%=request.getContextPath() %>/jquery-easyui-1.4/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/jquery-easyui-1.4/jquery.easyui.min.js"></script>
</head>
<body class="easyui-layout">
				<script type="text/javascript">
					$(function () {
						
						$('#dg2').datagrid({    
						 	url:'CountList', //通过url地址 从后台程序 获取一段josn数据
						    columns:[[
						        {field:'tname',title:'房型',width:200,align:'center'},    
						        {field:'count',title:'房间数量',width:200,align:'center'},          
						    ]]
						    
						})
						
						

					})
		
				</script>
<table id="dg2"></table>  
</body>
</body>
</html>
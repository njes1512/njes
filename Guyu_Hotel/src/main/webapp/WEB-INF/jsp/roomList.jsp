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
			<div title="面板一">
				<script type="text/javascript">
					$(function () {					
						$('#dg1').datagrid({    
						 	url:'hotelList', //通过url地址 从后台程序 获取一段josn数据  
						    columns:[[
						        {field:'rid',title:'房间号码',width:200,align:'center'},    
						        {field:'tname',title:'房型',width:200,align:'center'},    
						        {field:'fid',title:'楼层',width:100,align:'center'},    
						        {field:'sname',title:'房间状态',width:100,align:'center'					 
						        },    
						        {field:'price',title:'房间价格',width:100,align:'center'			
						        }    
						    ]],
						    toolbar: '#tb',					   
						});
					});					
					function addRooms(){
						$('#add_win').window({    
						    width:800,    
						    height:800,    
						    modal:true,//是否模态 
						    href:'<%=request.getContextPath() %>/toAdd'
						}); 
					}
					function tototal(){
						$('#total_win').window({    
						    width:800,    
						    height:800,    
						    modal:true,//是否模态 
						    href:'<%=request.getContextPath() %>/toTotal'
						}); 
					}
					//修改页面
					function toUpdateRoom(){
						var selectRows = $('#dg1').datagrid('getSelections');
						if(selectRows.length==0){
							$.messager.alert('警告','没有选中要修改的数据'); 
							return ;
						}
						if(selectRows.length>1){
							$.messager.alert('警告','修改的时候 只能选中一行'); 
							return ;
						}
						$('#edit_win').window({    
							    width:600,    
							    height:400,    
							    modal:true,//是否模态 
							    href:"<%=request.getContextPath() %>/toedit"
						}); 
					}
				</script>
			</div>
		<div class="easyui-tabs" data-options = "fit:'true'" id = "mytabs">
			<div title="面板一" data-options = "closable:'true',iconCls:'icon-reload'">
				<table id="dg1"></table>  
				<div id="tb">
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"  onclick="addRooms()">增加房间信息</a>
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="toUpdateRoom()">修改房间信息</a>
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="tototal()">查看统计信息</a>
				</div>
				<div id="add_win"></div>
				<div id="edit_win"></div> 
				<div id="total_win"></div> 
			</div>
		</div>
</body>
</html>
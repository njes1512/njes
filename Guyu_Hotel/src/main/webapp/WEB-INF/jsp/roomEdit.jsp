<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改页面</title>
<!-- 引入css文件 -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/jquery-easyui-1.4/themes/default/easyui.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/jquery-easyui-1.4/themes/icon.css">
<!-- 引入js文件 -->
<script type="text/javascript" src="<%=request.getContextPath() %>/jquery-easyui-1.4/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/jquery-easyui-1.4/jquery.easyui.min.js"></script>


</head>
<body>
<script type="text/javascript">
	$(function(){
		//获取被选中的
		var row = $('#dg1').datagrid('getSelected');
		$('#state1').combobox({
			url:'<%=request.getContextPath() %>/getStateList', 
		    valueField:'sid',    
		    textField:'sname'   
		}); 
		$('#type1').combobox({
			url:'<%=request.getContextPath() %>/getTypeList', 
		    valueField:'tid',    
		    textField:'tname'   
		});  
		$('#edit_good_form').form('load',row);	// 基本属性 回显完成
		
	})
	
	function updateRooms(){
		$.messager.progress();	// 显示进度条
		$('#edit_good_form').form('submit', {
			//提交到后台的地址
			url: "<%=request.getContextPath() %>/updateRooms",
			onSubmit: function(){//提交之前的校验
				var isValid = $(this).form('validate');
				if (!isValid){
					$.messager.progress('close');	// 如果表单是无效的则隐藏进度条
				}
				return isValid;	// 返回false终止表单提交
			},
			success: function(){
				$.messager.progress('close');	// 如果提交成功则隐藏进度条
				$('#edit_win').window('close');  // 关闭模态窗口
				$('#dg1').datagrid('reload');    // 重新载入当前页面数据 
				//消息提示框
				$.messager.show({
					title:'我的消息',
					msg:'修改完成。',
					timeout:1000,
					showType:'show'
				});
			}
		});


	}
</script>
<form id="edit_good_form" method="post"> 
   <div>   
        <label for="name">房间编号:</label>   
        <input class="easyui-validatebox" type="text" name="id" data-options="required:true" readonly="readonly"/>   
    </div>   
    <div>   
        <label for="name">房间号码:</label>   
        <input class="easyui-validatebox" type="text" name="rid" data-options="required:true" />   
    </div> 
    <div>   
        <label for="email">房型:</label>   
        <input id="type1" name="tid" >  
    </div>  
    <div>   
        <label for="email">楼层:</label>   
        <select id="cc1" class="easyui-combobox" name="fid" style="width:200px;">   
		    <option value="1">1</option>   
		    <option value="2">2</option>   
		    <option value="3">3</option>   
		    <option value="4">4</option>   
		</select>
    </div> 
     <div>   
        <label for="email">房间状态:</label>   
        <input id="state1" name="sid" >  
   	 </div>
     <div>   
        <label for="email">房间价格:</label>   
        <input class="easyui-validatebox" type="text" name="price" data-options="required:true" />   
     </div>    
    <a id="btn" href="#" class="easyui-linkbutton" onclick="updateRooms()" data-options="iconCls:'icon-save'">保存</a>  
</form>  
</body>
</html>
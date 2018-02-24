<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'User.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="JS/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="JS/easyui/themes/default/easyui.css">
	<script type="text/javascript" src="JS/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="JS/easyui/jquery.easyui.min.js"></script>

  </head>
  
  
    <body class="easyui-layout">   
      
    
    <div data-options="region:'east',iconCls:'icon-reload',title:'角色设置',split:true" style="width:35%;">
       <table id="dg2" class="easyui-datagrid" title="角色信息" style="width:100%;height:400px" 
  data-options="url:'servlet/RoleServ',fitColumns:true,pagination:true,pageList:[10]">   

		<thead>
			<tr>
			    <th data-options="field:'RoleId',checkbox:'true',width:40"></th>
				<th data-options="field:'Title',width:80">角色名称</th>
				<th data-options="field:'Memo',width:100">说明</th>
			</tr>
		</thead>
		</table>
		<div id="tb2">    
		    <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="save()">保存设置</a> 
		</div>		
    </div>   
    <div data-options="region:'west',title:'用户维护',split:true" style="width:65%;">
      <table id="dg1" class="easyui-datagrid" title="用户信息" style="width:100%;height:400px" 
          data-options="url:'servlet/UserServ',fitColumns:true,singleSelect:true,pagination:true,pageList:[10]">   

		<thead>
			<tr>
			    <th data-options="field:'UserId',width:0"> </th>
				<th data-options="field:'UserName',width:80">用户名</th>
				<th data-options="field:'UserPwd',width:90">用户密码</th>
				<th data-options="field:'OpenId',width:160" >微信唯一标识</th>
				<th data-options="field:'Name',width:60,align:'right'" >姓名</th>
				<th data-options="field:'Phone',width:170," >用户联系电话</th>
				<th data-options="field:'Memo',width:80,align:'right'" >备注</th>
				<th data-options="field:'_operate',width:120,align:'center',formatter:formatOper">操作</th>
			</tr>
		</thead>
	</table>
	  <div id="tb1">    
    <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">增加用户</a> 
    </div>
    </div>     
    <!-- ++++++++++++++++++++弹出的增加用户框++++++++++++++++++++++++++++++++++++++++ --> 
      <div class="easyui-dialog" id="add" 
		data-options="title:'增加用户',closable:true,top:10,closed:true,buttons:[{text:'确定',handler:queding},{text:'关闭',handler:function(){$('#add').dialog('close')}}]">

		 <table>
			<tr><td>用户名:<td><input name="UserName" type="text" id="username"></td></td></tr>
			<tr><td>用户密码：<td><input name="UserPwd" type="text" id="userpwd"></td></td></tr>
			<tr><td>微信标识：<td><input name="OpenId" type="text" id="openid"></td></td></tr>
			<tr><td>姓名：<td><input name="Name" type="text" id="name"></td></td></tr>
			<tr><td>用户联系电话：<td><input name="Phone" type="text" id="phone"></td></td></tr>
			<tr><td>备注：<td><input name="Memo" type="text" id="memo"></td></td></tr>
			</table>
		</div>
     <!-- ++++++++++++++++++++++++弹出的编辑用户框++++++++++++++++++++++++++++++++++++++ -->
        <div class="easyui-dialog" id="edit" 
		data-options="title:'编辑用户',closable:true,top:10,closed:true,buttons:[{text:'确定',handler:queding2},{text:'关闭',handler:function(){$('#edit').dialog('close')}}]">

		 <table>
		     <tr style='display:none'><td>用户id:<td><input name="UserId" type="text" id="userid2"></td></td></tr>
			<tr><td>用户名:<td><input name="UserName" type="text" id="username2"></td></td></tr>
			<tr><td>用户密码：<td><input name="UserPwd" type="text" id="userpwd2"></td></td></tr>
			<tr><td>微信标识：<td><input name="OpenId" type="text" id="openid2"></td></td></tr>
			<tr><td>姓名：<td><input name="Name" type="text" id="name2"></td></td></tr>
			<tr><td>用户联系电话：<td><input name="Phone" type="text" id="phone2"></td></td></tr>
			<tr><td>备注：<td><input name="Memo" type="text" id="memo2"></td></td></tr>
			</table>
		</div>
  </body>
  <script type="text/javascript">

    function formatOper(value,row,index){  
            
	          return '<a href="javascript:void(0);" onclick="bianjiUser('+index+')">编辑</a> <a href="javascript:void(0);" onclick="shanchuUser('+index+')">删除</a> <a href="javascript:void(0);" onclick="jiebang('+index+')">解绑</a>';
	    };
	//++++++++++增加用户按钮++++++++    
	$("#dg1").datagrid({
	    toolbar:'#tb1'
    });
    //+++++增加用户+++++
       function add(){
         $('#add').dialog('open').dialog({
                title:增加用户,
                modal: true
         });
       };
       
       function queding(){
                                                   
         var message={
                        "username":$("#username").val(),
                        "userpwd":$("#userpwd").val(),
                        "openid":$("#openid").val(),
                        "name":$("#name").val(),
                        "phone":$("#phone").val(),
                        "memo":$("#memo").val(),
                    };
             if($("#username").val()!=""&&$("#userpwd").val()!=""&&$("#name").val()!=""&&$("#phone").val()!=""&&$("#memo").val()!="")
              {
                  $.ajax({
                      type:"post",
                      url:"servlet/addUserServ",
                      data:{"Message":JSON.stringify(message)},
                      success:function(){
                         $('#dg1').datagrid('reload');
                         alert("添加成功！");
                         $("#username").val("");
		                $("#userpwd").val("");
		                $("#openid").val("");
                        $("#name").val("");
                        $("#phone").val("");
		                $("#memo").val("");
                        $('#add').dialog('close');
                      }
                    })  
                    
                } 
                else{alert("请填写完整！");
                       $("#username").val("");
		                $("#userpwd").val("");
		                $("#openid").val("");
                        $("#name").val("");
                        $("#phone").val("");
		                $("#memo").val("");
                    }             
                
       }
     //++++++++++用户编辑+++++++++++++
       function  bianjiUser(index){
        $("#dg1").datagrid('selectRow',index);
          var row=$("#dg1").datagrid('getSelected');
       //=+=====++++++++编辑框的弹出以及内容的填充=========
              $.ajax({
                     type:"post",
                     url:"servlet/fillEditServ",
                     data:{"index":row.UserId},
                     dataType:"json",
                     success:function(ob){
                        $("#userid2").val(ob.userid);
                        $("#username2").val(ob.username);
		                $("#userpwd2").val(ob.userpwd);
		                $("#openid2").val(ob.openid);
                        $("#name2").val(ob.name);
                        $("#phone2").val(ob.phone);
		                $("#memo2").val(ob.memo);
                     }
                 });
                 
               $("#edit").dialog('open').dialog({
                title:编辑用户,
                modal: true,
               });
              }
         //+++++++++++++++++编辑框的编辑++++++++++++++++++++++++      
                 function queding2(){
                                                   
                    var message={
                        "userid":$("#userid2").val(),
                        "username":$("#username2").val(),
                        "userpwd":$("#userpwd2").val(),
                        "openid":$("#openid2").val(),
                        "name":$("#name2").val(),
                        "phone":$("#phone2").val(),
                        "memo":$("#memo2").val(),
                      };
                 if($("#username2").val()!=""&&$("#userpwd2").val()!=""&&$("#name2").val()!=""&&$("#phone2").val()!=""&&$("#memo2").val()!="")
                  {
	                  $.ajax({
	                      type:"post",
	                      url:"servlet/EditServ",
	                      data:{"Message":JSON.stringify(message)},
	                      success:function(){
	                         $('#dg1').datagrid('reload');
	                         alert("修改成功！");
	                        $("#edit").dialog('close');
	                      }
	                    });  
                    
                   } 
                  else{
                     alert("请填写完整！");
                    }             
            }
		               
       
     
     //++++++++++++用户删除++++++++++++++++  
        function shanchuUser(index){
        $("#dg1").datagrid('selectRow',index);
          var row=$("#dg1").datagrid('getSelected');
           $.ajax({
               type:"post",
               url:"servlet/deleUserServ",
               data:{"index":row.UserId},
               success:function(){
                  $("#dg1").datagrid('reload');
               }
           });
           
        }
     //+++++++++++++用户解绑++++++++++++++++   
      function jiebang(index){
        $("#dg1").datagrid('selectRow',index);
          var row=$("#dg1").datagrid('getSelected');
           $.ajax({
               type:"post",
               url:"servlet/JieBangServ",
               data:{"index":row.UserId},
               success:function(){
                  $("#dg1").datagrid('reload');
               }
           });
           
        }
    //++++++++保存设置按钮+++++++++
    $("#dg2").datagrid({
	    toolbar:'#tb2'
     });
     //=====保存设置===== 
      function save(){
         var userow=$('#dg1').datagrid("getSelected");
         var rows1=$('#dg2').datagrid("getChecked");
         
         $.ajax({                           //先删除用户所对应的角色
             type:"post",
             url:"servlet/UseRoServ",
             data:{"userid":userow.UserId},
         });
         
            $.ajax({                        //再将勾选的角色保存
                  type:"post",
                  url:"servlet/saveURServ",
                  data:{"rows":JSON.stringify(rows1),"userid":userow.UserId}
            })
       
         
       };
	    
	     $("#dg1").datagrid({
	            //================点击用户选中角色============
	          onClickRow:function(Index,rowData){
	          var rows = $('#dg2').datagrid("getRows");
	          $("#dg2").datagrid('uncheckAll');
	              $.ajax({
	                   type:"post",
	                   url:"servlet/UR2Serv",
	                   data:{"Userid":rowData.UserId},
	                   dataType:"json",
	                   success:function(array1){
	                      for(var i=0;i<array1.length;i++){
	                          for(var j=0;j<rows.length;j++){
	                           if(array1[i]==rows[j].RoleId){
	                                $("#dg2").datagrid('checkRow',j);                                 
	                           }
	                        }	                        
	                      }
	                   }
	              });
	           }
	     });
	      
	         
	   //$("#dg2").datagrid({
	   //============勾选角色保存设置=====
	   //     onCheck:function(Index,rowData){
	   //        $.ajax({
	   //             type:"post",
	   //              url:"servlet/ru1Servlet",
	   //              data:{"roleid":rowData.RoleId},
	   //              dataType:"json",
	                 
	   //        });
	           
	   //     }
	   //});
	 //  var rows = $('#dg2').datagrid('getSelected');
	 //   alert(rows.Title);
	   
	    
	    
  </script>
</html>

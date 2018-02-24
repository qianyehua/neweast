<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'dept.jsp' starting page</title>
    
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
  
  <body>
    
   <!-- +++++++++++++++++++表格++++++++++++++++++++++++++++++++++ -->
    <table id="visfin"  class="easyui-datagrid" title="业务部门管理" style="width:100%;height:336px"
 data-options="url:'servlet/getDeptServ',fitColumns:true,singleSelect:true,pagination:true,pageList:[10]">
		<thead>
			<tr>
			    <th data-options="field:'id',hidden:true,width:0"></th>
				<th data-options="field:'dept',width:120,align:'center'">部门名称</th>
				<th data-options="field:'code',width:70,align:'center'">部门编号</th>
				<th data-options="field:'name',width:120,align:'center'">部门经理</th>
				<th data-options="field:'_operate',width:100,align:'center',formatter:formatOper">操作</th>
			</tr>
		</thead>
	</table>
         <div id="tb1">    
		    <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addCus()">添加部门</a> 
		</div>
		
		<!-- ++++++++++++++++++++弹出的增加分管++++++++++++++++++++++++++++++++++++++++ --> 
      <div class="easyui-dialog" id="addCus" 
		data-options="title:'添加部门',top:10,closable:true,closed:true,buttons:[{text:'确定',handler:queding},{text:'关闭',handler:function(){$('#addCus').dialog('close')}}]" style="height: 200px; ">

		 <table>
			<tr><td>部门名称：<td><input name="deptName" type="text" id="deptname"></td></td></tr>
			<tr><td>部门编号：<td><input name="UserName" type="text" id="deptid"></td></td></tr>		                             
			<tr><td>部门经理：<td><input id="staff" class="easyui-combobox" name="staff" 
					               data-options="valueField:'id',textField:'text',
					                             url:'servlet/getstaffServ', 
					                             onSelect:function(rec){selectedhos(rec)},"> </td></td></tr>		                             
					                             
			</table>
		</div>
	<!-- ++++++++++++++++++++++++弹出的编辑用户框++++++++++++++++++++++++++++++++++++++ -->
        <div class="easyui-dialog" id="edit" 
		data-options="title:'修改部门信息',top:10,closable:true,closed:true,buttons:[{text:'修改',handler:queding2},{text:'取消',handler:function(){$('#edit').dialog('close')}}]">

		 <table>
		     <tr><td>部门名称：<td><input name="deptName" type="text" id="deptname2"></td></td></tr>
			<tr><td>部门编号：<td><input name="UserName" type="text" id="deptid2"></td></td></tr>		                             
			<tr><td>部门经理：<td><input id="staff2" class="easyui-combobox" name="staff2" 
					               data-options="valueField:'id',textField:'text',
					                             url:'servlet/getstaffServ', 
					                             onSelect:function(rec){selectedhos2(rec)},"> </td></td></tr>
			</table>
		</div>	
  </body>

<script type="text/javascript"> 
var a,b,c;
function formatOper(value,row,index){  
            
	          return '<a href="javascript:void(0);" onclick="bianjiUser('+index+')">编辑</a> <a href="javascript:void(0);" onclick="shanchuUser('+index+')">删除</a>';
	    };
   //++++++++++增加按钮++++++++    
	$("#visfin").datagrid({
	    toolbar:'#tb1'
    });
     //+++++增加分管+++++
       function addCus(){
       $('#hospital').combobox('reload');
         $('#addCus').dialog('open').dialog({
                title:添加部门,
                modal: true
         });
       };
        
         function selectedhos(rec){
          b=rec.id;
         }   
       function queding(){
      
                   
             if(b!=""&&$("#deptname").val()!=""&&$("#deptid").val()!="")
              {
                  $.ajax({
                      type:"post",
                      url:"servlet/addDeptServ",
                      data:{"staffid":b,"dept":$("#deptname").val(),"code":$("#deptid").val()},
                      success:function(){
                         $('#visfin').datagrid('reload');
                         alert("添加成功！");
                        $('#addCus').dialog('close');
                        
                      }
                    })  
                    
                } 
                else{alert("请填写正确！");
                      
                    }             
                
       }
       //++++++++++++部门删除++++++++++++++++  
        function shanchuUser(index){
           $("#visfin").datagrid('selectRow',index);
          var row=$("#visfin").datagrid('getSelected');
           $.ajax({
               type:"post",
               url:"servlet/deleteDeptServ",
               data:{"id":row.id},
               success:function(){
                  $("#visfin").datagrid('reload');
               }
           });
           
        }
        
        //++++++++++用户编辑+++++++++++++
         function selectedhos2(rec){
          a=rec.id;
         }   
       function  bianjiUser(index){
          $("#visfin").datagrid('selectRow',index);
          var row=$("#visfin").datagrid('getSelected');
          c=row.id;
                     $("#deptname2").val(row.dept);
                     $("#deptid2").val(row.code);
                     $("#staff2").combobox('setValue',row.name);
		            
       //=+=====++++++++编辑框的弹出以及内容的填充=========
       //       $.ajax({
       //              type:"post",
       //              url:"servlet/fillEditServ",
       //              data:{"index":row.id},
      //               dataType:"json",
       //              success:function(ob){
       //                 $("#deptname2").val(ob.userid);
       //                 $("#deptid2").val(ob.username);
		//                $("#staff2").val(ob.userpwd);
		                
      //               }
      //           });
                 
               $("#edit").dialog('open').dialog({
                title:编辑用户,
                modal: true,
               });
              }
         //+++++++++++++++++编辑框的编辑++++++++++++++++++++++++      
                 function queding2(){
                    
                 if($("#dept2").val()!=""&&$("#code2").val()!=""&&a!="")
                  {
	                  $.ajax({
	                      type:"post",
	                      url:"servlet/UpdateDeptServ",
	                      data:{"deptid":c,"dept":$("#deptname2").val(),"code":$("#deptid2").val(),"staffid":a},
	                      success:function(flag){
	                         $("#visfin").datagrid('reload');
	                         alert("修改成功！");
	                        $("#edit").dialog('close');
	                      }
	                    });  
                    
                   } 
                  else{
                     alert("请填写完整！");
                    }             
            }
</script>
</html>
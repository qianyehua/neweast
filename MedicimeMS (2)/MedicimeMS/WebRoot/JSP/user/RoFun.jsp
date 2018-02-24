<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'RoFun.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" type="text/css" href="JS/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="JS/easyui/themes/default/easyui.css">
	<script type="text/javascript" src="JS/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="JS/easyui/jquery.easyui.min.js"></script>
  </head>
  
 <body class="easyui-layout">   
      
    <div data-options="region:'east',iconCls:'icon-reload',title:'功能设置',split:true" style="width:45%;">
       
       <ul id="tt"></ul>  
       
    </div> 
    <div data-options="region:'west',title:'角色维护',split:true" style="width:55%;">
       <table id="dg2" class="easyui-datagrid" title="角色信息" style="width:100%;height:300px" 
             data-options="url:'servlet/RoleServ',fitColumns:true,singleSelect:true,pagination:true,pageList:[10]">   

		<thead>
			<tr>
			    <th data-options="field:'RoleId',width:0" ></th>
				<th data-options="field:'Title',width:60">角色名称</th>
				<th data-options="field:'Memo',width:120">说明</th>
				<th data-options="field:'operate',width:120,align:'center',formatter:formatOper">操作</th>
			</tr>
		</thead>
	<!-- ++++++++++++++功能树+++++++++++++++++++++ -->	
		 <div id="tb2">    
		    <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addrole()">增加角色</a> 
		</div>		
	</table>
		
    </div>   
   <!-- ++++++++++++++++++++弹出的增加角色框++++++++++++++++++++++++++++++++++++++++ --> 
      <div class="easyui-dialog" id="addrole" 
		data-options="title:'增加角色',closable:true,top:10,closed:true,buttons:[{text:'确定',handler:queding},{text:'关闭',handler:function(){$('#addrole').dialog('close')}}]">

		 <table>
			<tr><td>角色名:<td><input name="RoleName" type="text" id="rolename"></td></td></tr>
			<tr><td>说明：<td><input name="Memo" type="text" id="memo"></td></td></tr>
			</table>
		</div>
  </body>
  
  
  <script type="text/javascript">
     var o;
    function formatOper(value,row,index){  
            
	          return '<a href="javascript:void(0);" onclick="editUser('+index+')">编辑</a>','<a href="javascript:void(0);" onclick="shanchuUser('+index+')">删除</a>';
	    };
	    
	    //+++++++++++++功能树++++++++++++
	     $('#tt').tree({ 
	            checkbox:'true',
			    url:"servlet/FunctionServ",   
			});  
			
			$("#dg2").datagrid({
	            toolbar:'#tb2'
                 });
	//+++++增加用户+++++
       function addrole(){
         $('#addrole').dialog('open').dialog({
                title:增加用户,
                modal: true
         });
       };
       function queding(){
          var message={"rolename":$("#rolename").val(),
                       "memo":$("#memo").val()};
              if($("#rolename").val()!=""&&$("#memo").val()!="")
              {
                  $.ajax({
                      type:"post",
                      url:"servlet/addRoleServ",
                      data:{"Message":JSON.stringify(message)},
                      success:function(){
                         $('#dg2').datagrid('reload');
                         alert("添加成功！");
                         $("#rolename").val("");
		                $("#memo").val("");
                        $('#addrole').dialog('close');
                      }
                    });  
                    
                } 
                else{alert("请填写完整！");
                       $("#rolename").val("");
		                $("#memo").val("");
                    }             
                
       
       }
		//++++++++++++++++++删除角色++++++++++++++++++++++++
		 function shanchuUser(index){
           $.ajax({
               type:"post",
               url:"servlet/deleRoleServ",
               data:{"index":index},
               success:function(){
                  $("#dg2").datagrid('reload');
               }
           });
           
        }
	 //+++++++++++点击角色显示功能++++++++
	
	 
	  $("#dg2").datagrid({
	          onClickRow:function(Index,rowData){
	          var nodes = $('#tt').tree("getChildren");
	             for(var k=0;k<nodes.length;k++){
	                   $("#tt").tree('uncheck',nodes[k].target);   //所有的复选框都取消勾
	                 }
	                
	             $.ajax({
	                   type:"post",
	                   url:"servlet/RoFu1Serv",
	                   data:{"Roleid":rowData.RoleId},
	                   dataType:"json",
	                   success:function(Fidarray){  //得到与点击的roleid在t_rolefunction对应的functionid
	                      o=true;
	                      for(var i=0;i<Fidarray.length;i++){
	                          for(var j=0;j<nodes.length;j++){
	                             if(Fidarray[i]==nodes[j].id){
                                     $("#tt").tree('check',nodes[j].target); 
	                              }
	                           }	
	                        }
	                        o=false;
	                   }
	              });
	           }
	     });
	      		
	     //++++++++++++改变角色对应的功能++++++++++++++	
		 $('#tt').tree({
          onCheck:function(node,checked){
             var nodes=$("#dg2").datagrid("getSelected");
             if(o==false){
             if(checked==true){
                  $.ajax({
                       type:"post",
                       url:"servlet/SaveFunServ",
                       data:{"funid":node.id,"roleid":nodes.RoleId}
                  })
               }
             else{
                   $.ajax({
                          type:"post",
                          url:"servlet/DeleFunServ",
                          data:{"funid":node.id,"roleid":nodes.RoleId}
                    })
                }
            }
          }
      }) 	
   </script>	    
</html>

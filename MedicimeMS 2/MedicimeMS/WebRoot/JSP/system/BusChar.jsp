<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'BusChar.jsp' starting page</title>
    
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
    <table id="visfin"  class="easyui-datagrid" title="业务分管管理" style="width:100%;height:366px"
 data-options="url:'servlet/buscharServ',rownumbers:true,fitColumns:true,singleSelect:true,pagination:true,pageList:[10]">
		<thead>
			<tr>
			    <th data-options="field:'MoniHosId',hidden:true,width:0"></th>
				<th data-options="field:'Name',width:120,align:'center'">业务员</th>
				<th data-options="field:'HospitalName',width:70,align:'center'">客户单位</th>
				<th data-options="field:'_operate',width:100,align:'center',formatter:formatOper">操作</th>
			</tr>
		</thead>
	</table>
         <div id="tb1">    
		    <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addCus()">增加分管</a> 
		</div>
		
		<!-- ++++++++++++++++++++弹出的增加分管++++++++++++++++++++++++++++++++++++++++ --> 
      <div class="easyui-dialog" id="addCus" 
		data-options="title:'增加分管',closable:true,closed:true,buttons:[{text:'确定',handler:queding},{text:'关闭',handler:function(){$('#addCus').dialog('close')}}]" style="height: 200px; ">

		 <table>
			<tr><td>业务员：<td><input id="user" class="easyui-combobox" name="User" 
					               data-options="valueField:'id',textField:'text',
					                             url:'./getAllStaffServ?id=0&userid=0', 
					                             onSelect:function(rec){selecteduser(rec)},"> </td></td></tr>
			<tr><td>客户单位：<td><input id="hospital" class="easyui-combobox" name="Hospital" 
					               data-options="valueField:'id',textField:'text',
					                             url:'servlet/getAddHosSer', 
					                             onSelect:function(rec){selectedhos(rec)},"> </td></td></tr>		                             
					                             
			</table>
		</div>
  </body>

<script type="text/javascript"> 
var a,b;
function formatOper(value,row,index){  
            
	          return '<a href="javascript:void(0);" onclick="shanchuUser('+index+')">删除</a>';
	    };
   //++++++++++增加按钮++++++++    
	$("#visfin").datagrid({
	    toolbar:'#tb1'
    });
     //+++++增加分管+++++
       function addCus(){
       $('#hospital').combobox('reload');
         $('#addCus').dialog('open').dialog({
                title:增加分管,
                modal: true
         });
       };
         function selecteduser(rec){
          a=rec.id;
         }  
         
         function selectedhos(rec){
          b=rec.id;
         }   
       function queding(){
                                                   
         var message={
                        "userid":a,
                        "hosid":b,
                    };
                   
             if(b!=""&&a!="")
              {
                  $.ajax({
                      type:"post",
                      url:"servlet/addMoHoSer",
                      data:{"Message":JSON.stringify(message)},
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
       //++++++++++++分管删除++++++++++++++++  
        function shanchuUser(index){
           $("#visfin").datagrid('selectRow',index);
          var row=$("#visfin").datagrid('getSelected');
           $.ajax({
               type:"post",
               url:"servlet/deleMoHoServ",
               data:{"index":row.MoniHosId},
               success:function(){
                  $("#visfin").datagrid('reload');
               }
           });
           
        }
</script>
</html>
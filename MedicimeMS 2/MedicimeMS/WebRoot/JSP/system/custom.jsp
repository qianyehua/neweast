<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String userId=(String)session.getAttribute("userid");
int userid=Integer.parseInt(userId);
String RoleId=(String)session.getAttribute("roleid");
int roleid=Integer.parseInt(RoleId);

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'custom.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="JS/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="JS/easyui/themes/default/easyui.css">
	<script type="text/javascript" src="JS/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="JS/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=0Nik0DmKL5G48BgzhlYGGDg9dXfgpGat" ></script>
  </head>
  
  <body>
    <!-- ++++++++++++++++++++搜索框+++++++++++++++++++++++++++ 
	  <input id="ss" style="width:240px"></input> 
		<div id="mm" style="width:120px"> 
			 
			<div data-options="name:'hospital'">客户单位</div> 
			
		</div> -->
		
		<div style="display:none;width:1px;height:1px;" id="container"></div>
		
	  医院选择:
               <input id="cpkind_combobox2" class="easyui-combobox" name="hoskind"  style='height:25px;width:250px' 
               data-options="valueField:'id',textField:'text',
                             url:'./getAllHospitalServ?id=0',
                             onSelect:function(rec){setHosId(rec)}
                             "/>  

 

	                          	
   <!--  +++++++++++++++++++表格++++++++++++++++++++++++++++++++++-->
    <table id="custom"  class="easyui-datagrid" title="客户管理" style="width:100%;height:366px"
 data-options="url:'servlet/customServ',rownumbers:true,fitColumns:true,singleSelect:true,pagination:true,pageList:[10]">
		<thead>
			<tr>
			    <th data-options="field:'HospitalId',hidden:true,width:0"></th>
				<th data-options="field:'HospitalName',width:120,align:'center'">客户单位</th>
				<th data-options="field:'ProName',width:60,align:'center'">单位类型</th>
				<th data-options="field:'Person',width:70,align:'center'">联系人</th>
				<th data-options="field:'Phone',width:90,align:'center'">联系电话</th>
				<th data-options="field:'Address',width:150,align:'center'">客户地址</th>
				<th data-options="field:'Caption',width:80,align:'center'">所属区域</th>
				<th data-options="field:'Longitude',width:80,align:'center'">经度</th>
				<th data-options="field:'Latitude',width:80,align:'center'">经度</th>
				<th data-options="field:'_operate',width:100,align:'center',formatter:formatOper">操作</th>
			    
			</tr>
			
		</thead>
	</table>
	
	    <div id="tb1">    
		    <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addCus()">增加用户</a> 
		</div>
		
		<!-- ++++++++++++++++++++弹出的增加客户框++++++++++++++++++++++++++++++++++++++++  -->
      <div class="easyui-dialog" id="add" 
		data-options="title:'增加用户',closable:true,top:10,closed:true,buttons:[{text:'确定',handler:queding},{text:'关闭',handler:function(){$('#add').dialog('close')}}]" style="height:330px;width:330px ">

		 <table style="padding-top:10px">
			<tr><td>客户单位:<td><input name="HospitalName" type="text" id="hospitalname"></td></td></tr>
			<tr><td>单位类型：<td><input id="proname" class="easyui-combobox" name="ProName" 
					               data-options="valueField:'id',textField:'text',
					                             url:'servlet/getProServ', 
					                             onSelect:function(rec){selectedpro(rec)},"> </td></td></tr>
			<tr><td>联系人：<td><input name="Person" type="text" id="person"></td></td></tr>
			<tr><td>联系电话：<td><input name="Phone" type="text" id="phone"></td></td></tr>
			<tr><td>客户地址：<td><input name="Address" type="text" id="address"></td></td></tr>
			<tr><td>所属区域：<td><input id="caption" class="easyui-combobox" name="Caption" 
					               data-options="valueField:'id',textField:'text',
					                             url:'servlet/getComServ', 
					                             onSelect:function(rec){selectedKind(rec)},"> </td></td></tr>
           <tr><td>查询的地址:<td><input id="text_" type="text" value="宁波"><td><input type="button" value="查询" onclick="searchByStationName();"></td></td></td></tr>
		    <tr><td>查询结果:</td></tr>
		    <tr><td>经度:<td><input id="result_1" type="text" style="width:80px" /></td></td></tr>
		    <tr><td>纬度:<td><input id="result_2" type="text" style="width:80px" /></td></td></tr>
		</table>
		</div> 
    <!-- ++++++++++++++++++++++++++++弹出的编辑用户框+++++++++++++++++++++++++++++++++++++++ -->
       <div class="easyui-dialog" id="editCus" 
		data-options="title:'编辑用户',closable:true,top:10,closed:true,buttons:[{text:'确定',handler:queding2},{text:'关闭',handler:function(){$('#editCus').dialog('close')}}]" style="height: 330px;width:330px ">

		 <table>
		    <tr style="display:none"><td>用户id:<td><input name="HospitalId" type="text" id="hospitalid2"></td></td></tr>
			<tr><td>客户单位:<td><input name="HospitalName" type="text" id="hospitalname2"></td></td></tr>
			<tr><td>单位类型：<td><input id="proname2" class="easyui-combobox" name="ProName" 
					               data-options="valueField:'id',textField:'text',
					                             url:'servlet/getProServ', 
					                             onSelect:function(rec){selectedpro2(rec)},"> </td></td></tr>
			<tr><td>联系人：<td><input name="Person" type="text" id="person2"></td></td></tr>
			<tr><td>联系电话：<td><input name="Phone" type="text" id="phone2"></td></td></tr>
			<tr><td>客户地址：<td><input name="Address" type="text" id="address2"></td></td></tr>
			<tr><td>所属区域：<td><input id="caption2" class="easyui-combobox" name="Caption" 
					               data-options="valueField:'id',textField:'text',
					                             url:'servlet/getComServ', 
					                             onSelect:function(rec){selectedKind2(rec)},"> </td></td></tr>
			<tr><td>查询的地址:<td><input id="text_B" type="text" value="宁波"><td><input type="button" value="查询" onclick="searchByStationNameB();"></td></td></td></tr>
		    <tr><td>查询结果:</td></tr>
		    <tr><td>经度:<td><input id="result_1B" type="text" style="width:80px" /></td></td></tr>
		    <tr><td>纬度:<td><input id="result_2B" type="text" style="width:80px" /></td></td></tr>
			</table>
		</div> 
  </body>

<script type="text/javascript">
     
    var a,b,c,d;

 function formatOper(value,row,index){  
            
	          return '<a href="javascript:void(0);" onclick="bianjiUser('+index+')">编辑</a> <a href="javascript:void(0);" onclick="shanchuUser('+index+')">删除</a>';
	    };
	    
	    //++++++++选择下拉框+++++++++
	     function setHosId(rec){
          hosname=rec.text
          hosid=rec.id;
           refresh(hosname);
      }
       function refresh(){
         $('#custom').datagrid('load',{
           "value":hosname,
         })
       }
	    //+++++++++++++搜索框+++++++++++++++++
	    //$('#ss').searchbox({ 
		//searcher:function(value,name){
		//$('#custom').datagrid('load',{
		//   "value":value,
		   
		 //  })
		//}, 
		//menu:'#mm', 
		//prompt:'Please Input Value' 
		//}); 
  //++++++++++增加按钮++++++++    
	$("#custom").datagrid({
	    toolbar:'#tb1'
    });
    /* $('#add').panel('move',{ 
       left:100, 
        top:100 
     }); */
    //+++++增加用户+++++
       function addCus(){
         $('#add').dialog('open').dialog({
                title:增加用户,
                modal: true
         });
       };
         function selectedKind(rec){
          a=rec.id;
         }   
         function selectedpro(rec){
           c=rec.id;
         }
       function queding(){
                                                   
         var message={
                        "hospitalname":$("#hospitalname").val(),
                        "proid":c,
                        "person":$("#person").val(),
                        "phone":$("#phone").val(),
                        "address":$("#address").val(),
                        "areaid":a,
                        "longitude":$("#result_1").val(),
                        "latitude":$("#result_2").val(),
                    };
                   
             if($("#hospitalname").val()!=""&&$("#person").val()!=""&&$("#phone").val()!=""&&$("#address").val()!=""&&a!="")
              {
                  $.ajax({
                      type:"post",
                      url:"servlet/addCusServ",
                      data:{"Message":JSON.stringify(message)},
                      success:function(){
                         $('#custom').datagrid('reload');
                         alert("添加成功！");
                         $("#hospitalname").val("");
		                $("#person").val("");
		                $("#phone").val("");
                        $("#address").val("");
                        $("#result_1").val("");
                        $("#result_2").val("");
                        $('#add').dialog('close');
                      }
                    })  
                    
                } 
                else{alert("请填写正确！");
                       $("#hospitalname").val("");
		                $("#person").val("");
		                $("#phone").val("");
                        $("#address").val("");
                        $("#result_1").val("");
                        $("#result_2").val("");
                    }             
                
       }
     //++++++++++用户编辑+++++++++++++
     
       function  bianjiUser(index){
           $("#custom").datagrid('selectRow',index);
          var row=$("#custom").datagrid('getSelected');
	          $("#hospitalid2").val(row.HospitalId);
	          $("#hospitalname2").val(row.HospitalName);
	          $("#proname2").combobox('setValue',row.ProName);
	          $("#person2").val(row.Person);
			  $("#phone2").val(row.Phone);
			  $("#address2").val(row.Address);
			  $("#caption2").combobox('setValue',row.Caption); 
			  $("#result_1B").val(row.Longitude);
              $("#result_2B").val(row.Latitude);
       //=+=====++++++++编辑框的弹出以及内容的填充=========
              /* $.ajax({
                     type:"post",
                     url:"servlet/fillCusServ",
                    data:{"hospitalid":row.HospitalId},
                    dataType:"json",
                     success:function(ob){
                       $("#hospitalid2").val(ob.hospitalid);
                       $("#hospitalname2").val(ob.hospitalname);
                       $("#person2").val(ob.person);
		               $("#phone2").val(ob.phone);
		               $("#address2").val(ob.address);
		               $("#caption2").combobox('setValue',row.caption);
                    }
               }); */
                 
               $("#editCus").dialog('open').dialog({
                title:编辑用户,
                modal: true,
               });
              }
              function selectedKind2(rec){
		          b=rec.id;
		        }
		      function selectedpro2(rec){
		         d=rec.id;
		      }     
         //+++++++++++++++++编辑框的编辑++++++++++++++++++++++++      
                 function queding2(){
                                                   
                    var message={
                        "hospitalid":$("#hospitalid2").val(),
                        "hospitalname":$("#hospitalname2").val(),
                        "proid":d,
                        "person":$("#person2").val(),
                        "phone":$("#phone2").val(),
                        "address":$("#address2").val(),
                        "areaid":b,
                        "longitude":$("#result_1B").val(),
                        "latitude":$("#result_2B").val(),
                      };
                 if($("#hospitalname2").val()!=""&&$("#person2").val()!=""&&$("#phone2").val()!=""&&$("#address2").val()!=""&&b!="")
                  {
	                  $.ajax({
	                      type:"post",
	                      url:"servlet/editCusServ",
	                      data:{"Message":JSON.stringify(message)},
	                      success:function(){
	                         $('#custom').datagrid('reload');
	                         alert("修改成功！");
	                        $("#editCus").dialog('close');
	                      }
	                    });  
                    
                   } 
                  else{
                     alert("请填写完整！");
                    }             
            }
		               
      
     
     //++++++++++++用户删除++++++++++++++++  
        function shanchuUser(index){
           $("#custom").datagrid('selectRow',index);
          var row=$("#custom").datagrid('getSelected');
           $.ajax({
               type:"post",
               url:"servlet/deleCusServ",
               data:{"index":row.HospitalId},
               success:function(){
                  $("#custom").datagrid('reload');
               }
           });
           
        } 
     //+++++++++++++++++经纬度查询+++++++++++++++++++++++++++   
      var map = new BMap.Map("container");
	  map.centerAndZoom("宁波", 12); 
		
		var localSearch= new BMap.LocalSearch (map, {
			renderOptions: {
			pageCapacity: 8,
			autoViewport: true,
			selectFirstResult: false
			}
		});

		localSearch.enableAutoViewport();
		//增加框
		function searchByStationName()
		{
		
		var keyword = document.getElementById("text_").value;
		localSearch.setSearchCompleteCallback(function(searchResult){
		var poi = searchResult.getPoi(0);
	//	alert(poi.point.lng+" "+poi.point.lat);
		$("#result_1").val(poi.point.lng);
		$("#result_2").val(poi.point.lat);
		map.centerAndZoom(poi.point, 8);
		});
		localSearch.search(keyword);
		
		}
		//编辑框
		function searchByStationNameB()
		{
		
		var keyword = document.getElementById("text_B").value;
		localSearch.setSearchCompleteCallback(function(searchResult){
		var poi = searchResult.getPoi(0);
	//	alert(poi.point.lng+" "+poi.point.lat);
		$("#result_1B").val(poi.point.lng);
		$("#result_2B").val(poi.point.lat);
		map.centerAndZoom(poi.point, 8);
		});
		localSearch.search(keyword);
		
		}
</script>
</html>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String userId=(String)session.getAttribute("userid");
int userid=Integer.parseInt(userId);
String RoleId=(String)session.getAttribute("roleid");
int roleid=Integer.parseInt(RoleId);
//roleid=11 管理员  ; 12 运管员 ;13 分公司运管员;14 业务员;24 部门经理
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'VisFin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="JS/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="JS/easyui/themes/default/easyui.css">
	<script type="text/javascript" src="JS/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="JS/easyui/jquery.easyui.min.js"></script>
    <script src="JS/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
  </head>
  
  <body>
    <!-- ++++++++++++++++++++搜索框+++++++++++++++++++++++++++ -->
    <div>
	 <!--  <input id="ss" style="width:240px"></input> 
		<div id="mm" style="width:120px"> 
			<div data-options="name:'name'">业务员</div> 
		     <div data-options="name:'hospital'">客户单位</div>
			<div data-options="name:'content'">内容</div>
	    </div> 	 -->	
	               类别选择:
               <input id="cpkind_combobox3" class="easyui-combobox" name="typekind"  style='height:25px;width:150px' 
               data-options="valueField:'id',textField:'text',
                             url:'servlet/VistTypeServ?id=0',
                             onSelect:function(rec){setTypeId(rec)}
                             "/> 
			 医院选择:
               <input id="cpkind_combobox1" class="easyui-combobox" name="hoskind"  style='height:25px;width:150px' 
               data-options="valueField:'id',textField:'text',
                             url:'./getAllHospitalServ?id=0',
                             onSelect:function(rec){setHosId(rec)}
                             "/>  
         <%if(roleid==11) {%>                 
                           业务员选择:
               <input id="cpkind_combobox2" class="easyui-combobox" name="staffkind"  style='height:25px;width:150px' 
               data-options="valueField:'id',textField:'text',
                             url:'./getAllStaffServ?id=0&userid=0',
                             onSelect:function(rec){setStaffId(rec)}
                             "/>                  
		<%} %>
		<%if(roleid==24){ %>
		    业务员选择:
               <input id="cpkind_combobox2" class="easyui-combobox" name="staffkind"  style='height:25px;width:150px' 
               data-options="valueField:'id',textField:'text',
                             url:'./getAllStaffServ?id=0&userid=<%=userid %>',
                             onSelect:function(rec){setStaffId(rec)}
                             "/>            
		<%} %>
	                       开始:
      <input id="startdate" type="text"  required="required" style='height:25px'></input>  
                                     结束:
      <input id="enddate" type="text" required="required" style='height:25px'></input>	
   </div>
   <!-- +++++++++++++++++++表格++++++++++++++++++++++++++++++++++ -->
    <table id="visfin"  class="easyui-datagrid" title="拜访查询" style="width:100%;height:336px"
 data-options="url:'servlet/VisFinServ',rownumbers:true,fitColumns:true,singleSelect:true,pagination:true,pageList:[10]">
		<thead>
			<tr>
			    <th data-options="field:'operate1',width:30,align:'center',formatter:formatOper">详情</th>
			    <th data-options="field:'VisitId',hidden:true,width:0"></th>
				<th data-options="field:'Name',width:80">业务员</th>
				<th data-options="field:'HospitalName',width:100">客户单位</th>
				<th data-options="field:'Type',width:100,align:'center'">拜访类别</th>
				<th data-options="field:'VisitContent',hidden:true,width:100,align:'center'">拜访内容</th>
				<th data-options="field:'VisitTime',width:80,align:'center'">拜访时间</th>
				<%if(roleid==11){ %>
				<th data-options="field:'operate2',width:30,align:'center',formatter:formatOperB">操作</th>
			    <%} %>
			</tr>
		</thead>
	</table>
	<!-- +++++++++++++++++++++++详情+++++++++++++++++++++++++++++ -->
    <div class="easyui-dialog" id="edit1" 
		data-options="title:'详情',top:10,closable:true,closed:true,buttons:[{text:'关闭',handler:function(){$('#edit1').dialog('close')}}]">

		 <table>
		     <tr style='display:none'><td>信息id:<td><input name="VisitId" type="text" id="visitid2"></td></td></tr>
			<tr><td>业务员:<td><input name="Name" type="text" id="name2"></td></td></tr>
			<tr><td>客户单位：<td><input name="HospitalName" type="text" id="hospitalname2"></td></td></tr>
			<tr><td>拜访内容：<td><textarea rows="8" cols="20" name="VisitContent" type="text" id="visitcontent2"></textarea></td></td></tr>
			<tr><td>拜访时间：<td><input  name="VisitTime" type="text" id="visittime2"></td></td></tr>
			
		</table>
	</div>
  </body>

<script type="text/javascript"> 
 //传userid roleid 返回所查的自己的记录
    var roleid=<%=roleid%>;
    var userid=<%=userid%>;
    var stdate=getbeforedate();
    var endate=getnowdate();
    var val=0;
    var hos=0;
    var staff=0;
    function formatOper(value,row,index){  
            
	          return '<a href="javascript:void(0);" onclick="bianjiUser('+index+')">详情</a>';
	    };
	function formatOperB(value,row,index){  
            
	          return '<a href="javascript:void(0);" onclick="shanchu('+index+')">删除</a>';
	    };    
	 //++++++++详情
    function  bianjiUser(index){

          $("#visfin").datagrid('selectRow',index);
          var row=$("#visfin").datagrid('getSelected');
          $("#name2").val(row.Name);
          $("#hospitalname2").val(row.HospitalName);
          $("#visitcontent2").val(row.VisitContent);
          $("#visittime2").val(row.VisitTime);
          
               $("#edit1").dialog('open').dialog({
                title:详情,
                modal: true,
               });
              }
  //++++++++++++++删除++++++++
    function shanchu(index){
        $("#visfin").datagrid('selectRow',index);
        var row=$("#visfin").datagrid('getSelected');
           $.ajax({
               type:"post",
               url:"servlet/deletVisServ",
               data:{"id":row.VisitId},
               success:function(){
                  $("#visfin").datagrid('reload');
               }
           });
           
        
    }
		 //设置起始默认时间
	
	 $("#startdate").datebox({
        required:true,
        editable:false,
        value:stdate,
        onSelect: function(date){
    
           if(date.getTime()>new Date(endate).getTime()){
              alert("选择日期超过结束时间!");
               //stdate=endate;
               $("#startdate").datebox('setValue',stdate);
           }
           else{stdate=format(date); getData();}
        },
      
     });

       

      //设置结束默认时间
	 $("#enddate").datebox({
	   required:true,
	   editable:false,
	   value:endate,
	   onSelect: function(date){
           if(date.getTime()<new Date(stdate).getTime()){
               alert("选择日期早于起始时间!");
              // endate=stdate;
               $("#enddate").datebox('setValue',endate);
           }
           else{endate=format(date); getData();}
        },
	 });
	 
	  //格式化日期
	function format(date){  
	   var y = date.getFullYear();
	   var m = date.getMonth()+1;
       var d = date.getDate();
	   return y+"-"+m+"-"+d;
	} 
	 
//得到当前日期
  function getnowdate(){
  
	var date=new Date();
	var y = date.getFullYear();
	var m = date.getMonth()+1;
	var d = date.getDate();
	return y+"-"+m+"-"+d;

}
//得到七天前的时间
function getbeforedate(){

	var nowdate= new Date();
	var date = new Date(nowdate.getTime()-7 * 24 * 3600 * 1000);
	var y = date.getFullYear();
	var m = date.getMonth()+1;
	var d = date.getDate();
	return y+"-"+m+"-"+d;
}

 function getData(){
 $('#visfin').datagrid('load',{
   "roleid":roleid,"userid":userid,
   "value":val,"other1":staff,"other2":hos,
    "startdate":stdate,"enddate":endate
    });
    }
    //搜索框
    /*  $('#ss').searchbox({ 
		searcher:function(value,name){
		val=value
		$('#visfin').datagrid('load',{
		"roleid":roleid,"userid":userid,
		   "value":val,"other1":staff,"other2":hos,
		   "startdate":stdate,"enddate":endate
		   })
		   
		}, 
		menu:'#mm', 
		prompt:'Please Input Value' 
		});  */
		//++++++++++类别下拉框+++++
		 function setTypeId(rec){
		    val=rec.id;
		    refresh3();
		 }
		 
		 function refresh3(){
		 $('#visfin').datagrid('load',{
		    "roleid":roleid,"userid":userid,
		   "value":val,"other1":staff,"other2":hos,
		   "startdate":stdate,"enddate":endate
		 })
		} 
		//++++++++选择下拉框+++++++++
		 //------医院
	     function setHosId(rec){
          hosname=rec.text;
          hos=rec.id;
          hosid=rec.id;
           refresh1();
           
      }
      
       function refresh1(){
         $('#visfin').datagrid('load',{
         "roleid":roleid,"userid":userid,
           "value":val,"other1":staff,"other2":hos,
           "startdate":stdate,"enddate":endate,
         })
       }
       //------业务员
       function setStaffId(rec){
          hosname=rec.text; 
          staff=rec.id;
          hosid=rec.id;
           refresh2();
        
      }
      
       function refresh2(){
         $('#visfin').datagrid('load',{
         "roleid":roleid,"userid":userid,
           "value":val,"other2":hos,"other1":staff,
           "startdate":stdate,"enddate":endate
         })
       }
</script>
</html>
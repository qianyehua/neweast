<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String userId=(String)session.getAttribute("userid");
int userid=Integer.parseInt(userId);
String roleId=(String)session.getAttribute("roleid");
int roleid=Integer.parseInt(roleId);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MesFin.jsp' starting page</title>
    
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
    <div>
	  
		
		      医院选择:
               <input id="cpkind_combobox2" class="easyui-combobox" name="hoskind"  style='height:25px;width:100px' 
               data-options="valueField:'id',textField:'text',
                             url:'./getAllHospitalServ?id=0',
                             onSelect:function(rec){setHosId(rec)}
                             "/>  
          <%if(roleid==11) {%>                  
                           业务员选择:
               <input id="cpkind_combobox2" class="easyui-combobox" name="staffkind"  style='height:25px;width:100px' 
               data-options="valueField:'id',textField:'text',
                             url:'./getAllStaffServ?id=0&userid=0',
                             onSelect:function(rec){setStaffId(rec)}
                             "/>
       <%} %>
        <%if(roleid==24){ %>       
                            业务员选择:
               <input id="cpkind_combobox2" class="easyui-combobox" name="staffkind"  style='height:25px;width:100px' 
               data-options="valueField:'id',textField:'text',
                             url:'./getAllStaffServ?id=0&userid=<%=userid %>',
                             onSelect:function(rec){setStaffId(rec)}
                             "/>                 
          <%} %>                    
                           类别:
               <input id="cpkind_combobox2" class="easyui-combobox" name="staffkind"  style='height:25px;width:80px' 
               data-options="valueField:'id',textField:'text',
                             url:'servlet/getType?id=0',
                             onSelect:function(rec){setTypeId(rec)}
                             "/>                    
		                开始:
      <input id="startdate" type="text"  required="required" style='height:25px'></input>  
                                     结束:
      <input id="enddate" type="text"" required="required" style='height:25px'></input>
      </div>
   <!-- +++++++++++++++++++表格++++++++++++++++++++++++++++++++++ -->
    <table id="visfin"  class="easyui-datagrid" title="信息查询" style="width:100%;height:336px"
 data-options="url:'servlet/MesFinServ',fitColumns:true,singleSelect:true,pagination:true,pageList:[10]">
		<thead>
			<tr>
			    <th data-options="field:'infoId',hidden:true,width:0"></th>
			    <th data-options="field:'operate1',width:60,align:'center',formatter:formatOper">详情</th>
				<th data-options="field:'Name',width:80">业务员</th>
				<th data-options="field:'HospitalName',width:100,align:'right'">客户单位</th>
				<th data-options="field:'InfoContent',width:120,align:'right'">信息内容</th>
				<th data-options="field:'InfoWay',width:80,align:'right'">信息来源</th>
				<th data-options="field:'SubmitTime',width:80,align:'right'">提交时间</th>
				<th data-options="field:'TypeName',width:80,align:'right'">信息类别</th>
				<th data-options="field:'InfoHandle',width:80,align:'right'">反馈信息</th>
				<%if(roleid==14||roleid==24) {%>
				<th data-options="field:'HandleName',width:80,align:'right'">反馈人</th>
				<%} %>
				 <%if(roleid==11){ %> 
				<th data-options="field:'operate2',width:60,align:'center',formatter:formatOperB">操作</th>
			     <%} %> 
			</tr>
		</thead>
	</table>
	<!-- +++++++++++++++++++++++详情+++++++++++++++++++++++++++++++++++ -->
    <div class="easyui-dialog" id="edit1" style="width:330px;height:330px"
		data-options="title:'详情',closable:true,top:10,closed:true,buttons:[{text:'关闭',handler:function(){$('#edit1').dialog('close')}}]">

		 <table>
		     <tr style='display:none'><td>信息id:<td><input name="InfoId" type="text" id="infoid2"></td></td></tr>
			<tr><td>业务员:<td><input name="Name" type="text" id="name2"></td></td></tr>
			<tr><td>客户单位：<td><input name="HospitalName" type="text" id="hospitalname2"></td></td></tr>
			<tr><td>信息内容：<td><textarea rows="6" cols="20" name="InfoContent" type="text" id="infocontent2"></textarea></td></td></tr>
			<tr><td>信息来源：<td><input  name="InfoWay" type="text" id="infoway2"></td></td></tr>
			<tr><td>提交时间：<td><input name="SubmitTime" type="text" id="submittime2"></td></td></tr>
			<tr><td>信息类别：<td><input name="TypeName" type="text" id="typename2"></td></td></tr>
			<tr><td>反馈内容：<td><textarea  name="InfoHandle" type="text" id="infohandle"></textarea></td></td></tr>
			<tr><td>反馈人：<td><input  name="handleName" type="text" id="handlename"></td></td></tr>
		</table>
	</div>
	<!-- +++++++++++++++++++++++反馈+++++++++++++++++++++++++++++++++++ -->
    <div class="easyui-dialog" id="fan" 
		data-options="title:'详情',closable:true,closed:true,buttons:[{text:'确定',handler:queding},{text:'关闭',handler:function(){$('#fan').dialog('close')}}]">

		 <table>
		     <tr style='display:none'><td>信息id:<td><input name="InfoId" type="text" id="infoid4"></td></td></tr>
			<tr><td>反馈内容：<td><textarea rows="8" cols="20" name="fankuiCon" type="text" id="fankuiCon"></textarea></td></td></tr>
		</table>
	</div>
  </body>

<script type="text/javascript">
    var roleid=<%=roleid%>;
    var userid=<%=userid%>; 
    var stdate=getbeforedate();
    var endate=getnowdate();
    var staff=0;
    var hos=0;
    var type=0;
    
 function formatOper(value,row,index){  
            
	          return '<a href="javascript:void(0);" onclick="xiangqing('+index+')">详情</a>';
	    };
  function formatOperB(value,row,index){  
            
	          return '<a href="javascript:void(0);" onclick="shanchu('+index+')">删除</a> <a href="javascript:void(0);" onclick="fankui('+index+')">反馈</a>';
	    };	    
	    
	    
function  xiangqing(index){

          $("#visfin").datagrid('selectRow',index);
          var row=$("#visfin").datagrid('getSelected');
          
          $("#name2").val(row.Name);
          $("#hospitalname2").val(row.HospitalName);
          $("#infocontent2").val(row.InfoContent);
          $("#infoway2").val(row.InfoWay);
          $("#submittime2").val(row.SubmitTime);
          $("#typename2").val(row.TypeName);
          $("#infohandle").val(row.InfoHandle);
          $("#handlename").val(row.HandleName);
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
               url:"servlet/deleMesServ",
               data:{"id":row.infoId},
               success:function(){
                  $("#visfin").datagrid('reload');
               }
           });
           
        
    }
    
   //+++++++++++++++++反馈+++++++++++++++++++++
      function fankui(index){
         $("#visfin").datagrid('selectRow',index);
         var row=$("#visfin").datagrid('getSelected');
          $("#fankuiCon").val(row.InfoHandle);
          $("#infoid4").val(row.infoId);
            $("#fan").dialog('open').dialog({
                title:反馈,
                modal: true,
               });
      }
         
         function queding(){
            var message={
                        "id":userid,
                        "InfoCon":$("#fankuiCon").val(),
                        "infoid":$("#infoid4").val(),
                        
                      };
             $.ajax({
                type:"post",
               url:"servlet/fankuiServ",
               data:{"message":JSON.stringify(message)},
               success:function(){
                  $("#visfin").datagrid('reload');
                  alert("反馈成功！");
	              $("#fan").dialog('close');
               }
             
             })
          
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
    "other1":staff,"other2":hos,"other3":type,
    "startdate":stdate,"enddate":endate
    });
    }	    
	    
   
		
	//++++++++选择下拉框+++++++++
		 //------医院
	     function setHosId(rec){
          hosname=rec.text
          hosid=rec.id;
          hos=rec.id;
           refresh1();
      }
      
       function refresh1(){
         $('#visfin').datagrid('load',{
            "roleid":roleid,"userid":userid,
           "other1":staff,"other2":hos,"other3":type,
           "startdate":stdate,"enddate":endate
         })
       }
       //------业务经理
       function setStaffId(rec){
          hosname=rec.text
          hosid=rec.id;
          staff=rec.id;
           refresh2();
      }
      
       function refresh2(){
         $('#visfin').datagrid('load',{
           "roleid":roleid,"userid":userid,
          "other1":staff,"other2":hos,"other3":type,
          "startdate":stdate,"enddate":endate
         })
       }	
       //------类别
       function setTypeId(rec){
          hosname=rec.text
          hosid=rec.id;
          type=rec.id;
           refresh3();
      }
      
       function refresh3(){
         $('#visfin').datagrid('load',{
         "roleid":roleid,"userid":userid,
           "other1":staff,"other2":hos,"other3":type,
          "startdate":stdate,"enddate":endate
         })
       }	
</script>
</html>
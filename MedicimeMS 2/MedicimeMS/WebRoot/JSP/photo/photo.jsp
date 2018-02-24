<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String userId=(String)session.getAttribute("userid");
int userid=Integer.parseInt(userId);
String roleid=(String)session.getAttribute("role");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>图片查询</title>
    
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
	  <%if(roleid.equals("管理员")) {%>
                           业务员选择:
               <input id="cpkind_combobox2" class="easyui-combobox" name="staffkind"  style='height:25px;width:150px' 
               data-options="valueField:'id',textField:'text',
                             url:'./getAllStaffServ?id=0&userid=0',
                             onSelect:function(rec){setStaffId(rec)}
                             "/>                  
	 <%} %>	
	 <%if(roleid.equals("部门经理")){ %>
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
      <input id="enddate" type="text"" required="required" style='height:25px'></input>	
   </div>
   <!-- +++++++++++++++++++表格++++++++++++++++++++++++++++++++++ -->
    <table id="visfin" class="easyui-datagrid" title="图片查询"  style="width:100%;height:75%"
         data-options="url:'servlet/getPhotoServ',rownumbers:true,fitColumns:true,singleSelect:true,pagination:true,pageList:[10]">
		 <thead>
			<tr>
			    <th data-options="field:'photoid',hidden:true,width:0"></th>
				<th data-options="field:'name',width:80">提交人</th>
				<th data-options="field:'photoname',width:100">图片名称</th>
				<th data-options="field:'time',width:80,align:'right'">提交时间</th>
				<th data-options="field:'operate',width:60,align:'center',formatter:formatOper">操作</th>
			</tr>
		</thead> 
	</table>
	<!-- +++++++++++++++++++++++详情+++++++++++++++++++++++++++++ -->
    <div class="easyui-dialog" id="edit1" style="width:60%;height:90%"
		data-options="title:'详情',closable:true,top:10,closed:true,buttons:[{text:'关闭',handler:function(){$('#edit1').dialog('close')}}]">

		 <img alt="" src="" style="width:100%;height:90%">
		  <div style="text-align:center" id="imgname"></div>
	</div>
  </body>

<script type="text/javascript"> 
    var stdate=getbeforedate();
    var endate=getnowdate();
    var roleid=<%=roleid%>;
    var userid=<%=userid%>;
    var hos=0;
    var staff=0;
    
   //$('#visfin').datagrid({ 
   //            url:'servlet/getPhotoServ?other1='+staff+'&startdate='+stdate+'&enddate='+endate+'',
   //            singleSelect:true,
   //            rownumbers:true,
   //            fitColumns:true,
   //            title:'图片查询', 
   //            pagination: true,
   //            pageSize: 10,
   //            pageList:[10],
   //            columns:[[    
   //                 {field:'photoid',hidden:true,width:0},   
    //                {field:'name',width:60,title:'提交人',align:'center'},    
   //                 {field:'photoname',width:120,title:'图片名称',align:'center'},   
   //                 {field:'time',width:80,title:'提交时间',align:'center'}, 
   //                 {field:'feedbackId',title:'操作',width:20,align:'center',formatter:formatOper},     
   //             ]],
         
   //       }); 
   
    function formatOper(value,row,index){  
            
	          return '<a href="javascript:void(0);" onclick="chakan('+index+')">查看</a>';
	    };
	    
	    
    function  chakan(index){

          $("#visfin").datagrid('selectRow',index);
          var row=$("#visfin").datagrid('getSelected');
          
             var src="http://www.hfmes.com/VisitPicDownLoad/"+row.photoname;
             $("#edit1").children("img").attr({"src":src});
             $("#imgname").text(row.photoname);
               $("#edit1").dialog('open').dialog({
                title:图片详情,
                modal: true,
               });
              }
  
		 //设置起始默认时间
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
//data-options="url:'servlet/getPhotoServ',fitColumns:true,singleSelect:true,pagination:true,pageList:[10]"
 function getData(){
 $('#visfin').datagrid('load',{
      "userid":userid,"roleid":roleid,
     "other1":staff,"startdate":stdate,"enddate":endate
    });
   // $.ajax({
   //    type:"post",
   //    url:"servlet/getPhotoServ",
   //    data:{"other1":staff,"startdate":stdate,"enddate":endate,"page":'1'},
   //    async:false,
   //	   dataType:"json",
   //	   success:function(content){
   //	      if(content==null){$('#visfin').datagrid('loadData',[]);}
  //	       else{$('#visfin').datagrid('loadData',content);}
		       
	//		  },
			  //error:function(){alert("加载失败");}
   //})
 
    }
    
     
		
		
       //------业务经理
       function setStaffId(rec){
          hosname=rec.text; 
          staff=rec.id;
          hosid=rec.id;
           refresh2(hosname);
        
      }
      //"type":"name",
       function refresh2(){
       $('#visfin').datagrid('load',{
            "userid":userid,"roleid":roleid,
           "other1":staff,"startdate":stdate,"enddate":endate
       });
        
       }
</script>
</html>
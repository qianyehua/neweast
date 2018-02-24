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
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'hosweekreport.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="JS/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="JS/easyui/jquery.easyui.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="JS/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="JS/easyui/themes/icon.css">
	<script src="JS/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
	
  </head>
  
  <body>
       <div style="padding-top:5px;padding-bottom:10px">
           <%if(roleid==11){ %>
                                             业务员选择:
               <input id="staff_combobox2" class="easyui-combobox" name="staffkind"  style='height:25px;width:250px' 
               data-options="valueField:'id',textField:'text',
                             url:'./getAllStaffServ?id=0&userid=0',
                             onSelect:function(rec){setStaffId(rec)}
                             "/>
            <%} %>
            <% if(roleid==24){%>     
                                业务员选择:
               <input id="staff_combobox2" class="easyui-combobox" name="staffkind"  style='height:25px;width:250px' 
               data-options="valueField:'id',textField:'text',
                             url:'./getAllStaffServ?id=0&userid=<%=userid %>',
                             onSelect:function(rec){setStaffId(rec)}
                             "/> 
             <%} %>                            
                                            医院选择:
               <input id="hos_combobox2" class="easyui-combobox" name="hoskind"  style='height:25px;width:250px' 
               data-options="valueField:'id',textField:'text',
                             url:'./getAllHospitalServ?id=0',
                             onSelect:function(rec){setHosId(rec)}
                             "/> 
                             
                                            开始:
               <input id="startdate" type="text"  required="required" style='height:25px'></input>  
                                              结束:
               <input id="enddate" type="text"" required="required" style='height:25px'></input>   
      </div>  
      <table id="hosreport_datagrid" style="width:100%;height:400px">
          </table> 
      
      <script>
     var stdate=getbeforedate();
    var endate=getnowdate();
    var pgsz=10;   	//记录选择的页大小
    var pgnb=1;     //记录选择的页数
  
    var uid=0;
    var hosid=0;

   
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
           else{stdate=format(date); getData(pgnb,pgsz);}
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
           else{endate=format(date); getData(pgnb,pgsz);}
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

            
    function setHosId(rec){
       
          hosid=rec.id;

          getData(pgnb,pgsz);   
     }
     
    function setStaffId(rec){
           uid=rec.id;
           $('#hos_combobox2').combobox('reload','./getAllHospitalServ?id='+uid);
           hosid=0;         
           getData(pgnb,pgsz);

     }
     
   $('#hosreport_datagrid').datagrid({                
                                       url:'./getDayReportServ?pagenumber=1&pagesize=10&uid='+uid+'&hospitalid='+hosid+'&startdate='+stdate+'&enddate='+endate,
                                       fitColumns:true,
                                       rownumbers:true,
                                       checkOnSelect:false,
                                       selectOnCheck:false,
                                       singleSelect:true,
                                       pagination:true,  
                                       columns:[[    
                                             {field:'staffname',title:'业务经理姓名',width:140,align:'center'},  
                                             {field:'hospital',title:'医院名称',width:200,align:'center'},
                                             {field:'amount',title:'访问次数',width:140,align:'center'},                           
                                        ]]                           
                                      });
                                        
        $('#hosreport_datagrid').datagrid('getPager').pagination({
          pageSize: 10,
          pageList: [10,20,30],
          beforePageText: '第',
          afterPageText: '页    共 {pages} 页', 
          displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
          onSelectPage:function(pageNumber,pageSize){getData(pageNumber,pageSize);} 
      });
          
    function getData(pageNumber,pageSize){
      pgnb=pageNumber;
      pgsz=pageSize;
      $.ajax({
		      type:"Post",
		      url:"./getDayReportServ?uid="+uid+"&hospitalid="+hosid,
		      data:{"pagesize":pageSize,"pagenumber":pageNumber,"startdate":stdate,"enddate":endate},
		      async:false,
		      dataType:"json",
		      success:function(showcontentarray){
		         if(showcontentarray["total"]==0){ $('#hosreport_datagrid').datagrid('loadData',{"total":0,"rows":[]});}
		        else{$('#hosreport_datagrid').datagrid('loadData',showcontentarray);} 
		       
			  },
			  error:function(){alert("加载失败");}
	   });
    }
      </script> 
  </body>
</html>
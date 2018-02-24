<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'hosmonthreport.jsp' starting page</title>
    
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
    <div style="padding-bottom:20px">   
               医院选择:
               <input id="cpkind_combobox2" class="easyui-combobox" name="hoskind"  style='height:25px;width:250px' 
               data-options="valueField:'id',textField:'text',
                             url:'./getAllHospitalServ?id=0',
                             onSelect:function(rec){setHosId(rec)}
                             "/> 
                             
                年份选择:
               <input id="cpkind_combobox" class="easyui-combobox" name="year"  style='height:25px;width:250px' 
               data-options="valueField:'id',textField:'text',
                             url:'JS/year.json',
                             onSelect:function(rec){setYearId(rec)}
                             "/>    
                             
     </div>                        
           <table id="hosmonth_datagrid" style="width:80%;height:400px">
          </table>                     
   <script>
   
     var pgsz=10;   	//记录选择的页大小
    var pgnb=1;     //记录选择的页数
  
    var hosid=0;
   var year="2016";
 
     
   $('#hosmonth_datagrid').datagrid({                
                                       url:'./getHospitalMonthReportServ?pagenumber=1&pagesize=10&hospitalid='+hosid+'&year='+year,
                                       fitColumns:true,
                                       rownumbers:true,
                                       checkOnSelect:false,
                                       selectOnCheck:false,
                                       singleSelect:true,
                                       pagination:true,  
                                       columns:[[    
                                             {field:'hospital',title:'医院名称',width:260,align:'center'},  
                                             {field:'1',title:'一月',width:200,align:'center'},
                                             {field:'2',title:'二月',width:200,align:'center'},
                                             {field:'3',title:'三月',width:200,align:'center'},
                                             {field:'4',title:'四月',width:200,align:'center'},
                                             {field:'5',title:'五月',width:200,align:'center'},
                                             {field:'6',title:'六月',width:200,align:'center'},
                                             {field:'7',title:'七月',width:200,align:'center'},
                                             {field:'8',title:'八月',width:200,align:'center'},
                                             {field:'9',title:'九月',width:200,align:'center'},
                                             {field:'10',title:'十月',width:200,align:'center'},
                                             {field:'11',title:'十一月',width:200,align:'center'},
                                             {field:'12',title:'十二月',width:200,align:'center'}                                      
                                        ]]                           
                                      });
                                        
        $('#hosmonth_datagrid').datagrid('getPager').pagination({
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
		      url:"./getHospitalMonthReportServ?&hospitalid="+hosid,
		      data:{"pagesize":pageSize,"pagenumber":pageNumber,"year":year},
		      async:false,
		      dataType:"json",
		      success:function(showcontentarray){
		        if(showcontentarray["total"]==0){$('#hosmonth_datagrid').datagrid('loadData',{"total":0,"rows":[]});}
		         else{$('#hosmonth_datagrid').datagrid('loadData',showcontentarray);}
		       
			  },
			  error:function(){alert("加载失败");}
	   });
    }
      function setHosId(rec){
      
          hosid=rec.id;
           getData(pgnb,pgsz);
      }
      
      function setYearId(rec){
         year=rec.text;
         getData(pgnb,pgsz);
      
      }
       	 


      
   </script>
   
                   
  </body>
</html>

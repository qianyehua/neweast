<%@page import="net.sf.json.JSONArray"%>
<%@ page language="java" import="java.util.*,com.MedicimeMS.Dao.SysChaDao" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String name=(String)session.getAttribute("uname");

String roleid=(String)session.getAttribute("roleid");
int RoleId=Integer.parseInt(roleid);

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>业务经理访问系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

    <link rel="icon" href="<%=basePath%>/icon.ico" type="image/x-icon">
    <link rel="shortcut icon" href="<%=basePath%>/icon.ico" type="image/x-icon">
	
	<script type="text/javascript" src="JS/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="JS/easyui/jquery.easyui.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="JS/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="JS/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="JSP/main.css">
	<script src="JS/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=0Nik0DmKL5G48BgzhlYGGDg9dXfgpGat" ></script>
	
	 <!--  <script type="text/javascript" src="utf8-jsp/ueditor.config.js"></script>
      <script type="text/javascript" src="utf8-jsp/ueditor.all.js"></script>-->
  </head>
  
  <body class="easyui-layout">   
    <div data-options="region:'north'" style="height:20%;">
    <img src="./img/title3.png" width=100% height=100%>
     <div class="info">
      <div class="detail">欢迎，<font color=red><%=name %>&nbsp;</font>登陆&nbsp;&nbsp; </div>
     </div>
      <div class="out"><div id="out"><span>注销</span></div></div>
    </div>     
   
    <div data-options="region:'west',title:'管理菜单',border:false" style="width:16%;">
          <div id="aa" class="easyui-accordion" style="width:100%;height:100%;">  
              <%  JSONArray array1=new SysChaDao().getMenuByPid(1, RoleId);
              if(array1.size()!=0){%>    
                  <div title="系统管理" class="panel" id="productinfo_accordion">   
            
                    <ul id="productinfo_tree" class="easyui-tree" style="text-align:left"
                      data-options=" url:'servlet/getSysChaServ?parentid=1&roleid=<%=RoleId%>',
	                                lines:true,
	                                onClick: function(node){addTab(node);}">
                    </ul>  
             
                 </div>   
             <%} 
               JSONArray array2=new SysChaDao().getMenuByPid(2, RoleId);
              if(array2.size()!=0){%>
                 <div title="拜访管理" class="panel" id="goodscount_accordion">  
           
                    <ul id="news_tree" class="easyui-tree" style="text-align:left"
                     data-options=" url:'servlet/getSysChaServ?parentid=2&roleid=<%=RoleId%>',
	                                lines:true,
	                                onClick: function(node){addTab(node);}">
                    </ul>  
              
                 </div>   
                 <%} 
                   JSONArray array3=new SysChaDao().getMenuByPid(3, RoleId);
              if(array3.size()!=0){%>
                 <div title="计划管理" class="panel" id="infoquery_accordion">   
          
                    <ul id="companyinfo_tree" class="easyui-tree" style="text-align:left"
                    data-options=" url:'servlet/getSysChaServ?parentid=3&roleid=<%=RoleId%>',
	                                lines:true,
	                                onClick:function(node){addTab(node); }">
                    </ul>                
                 </div> 
                 <%} 
                   JSONArray array4=new SysChaDao().getMenuByPid(4, RoleId);
              if(array4.size()!=0){%>
                 <div title="信息管理" class="panel" id="dataservice_accordion"> 
            
                    <ul id="feedback_tree" class="easyui-tree" style="text-align:left"
                     data-options=" url:'servlet/getSysChaServ?parentid=4&roleid=<%=RoleId%>',
	                                lines:true,
	                                onClick:function(node){addTab(node); }"
	                                >
                    </ul>  
               
                 </div>   
                 <%} 
                   JSONArray array6=new SysChaDao().getMenuByPid(6, RoleId);
              if(array6.size()!=0){%>
                  <div title="图片管理" class="panel" id="photo_accordion"> 
            
                    <ul id="photo_tree" class="easyui-tree" style="text-align:left"
                     data-options=" url:'servlet/getSysChaServ?parentid=6&roleid=<%=RoleId%>',
	                                lines:true,
	                                onClick:function(node){addTab(node); }"
	                                >
                    </ul>  
               
                 </div>   
                 <%} 
                   JSONArray array5=new SysChaDao().getMenuByPid(5, RoleId);
              if(array5.size()!=0){%>
                <div title="用户管理" class="panel" id="infoquery_accordion">   
          
                    <ul id="friendlink_tree" class="easyui-tree" style="text-align:left"
                    data-options=" url:'servlet/getSysChaServ?parentid=5&roleid=<%=RoleId%>',
	                                lines:true,
	                                onClick:function(node){addTab(node);}">
                    </ul>                
                 </div> 
                 <%} %>
                <%--  <%}
                 else if(funCon.equals("5")){ %>
                 <div title="拜访管理" class="panel" id="goodscount_accordion">  
           
                    <ul id="news_tree" class="easyui-tree" style="text-align:left"
                     data-options=" url:'servlet/getSysChaServ?parentid=2',
	                                lines:true,
	                                onClick: function(node){addTab(node);}">
                    </ul>  
              
                 </div>   
                 
                 <div title="计划管理" class="panel" id="infoquery_accordion">   
          
                    <ul id="companyinfo_tree" class="easyui-tree" style="text-align:left"
                    data-options=" url:'servlet/getSysChaServ?parentid=3',
	                                lines:true,
	                                onClick:function(node){addTab(node); }">
                    </ul>                
                 </div> 
                  <%} 
                 else if(funCon.equals("1")){ %>
                  <div title="信息管理" class="panel" id="dataservice_accordion"> 
            
                    <ul id="feedback_tree" class="easyui-tree" style="text-align:left"
                     data-options=" url:'servlet/getSysChaServ?parentid=4',
	                                lines:true,
	                                onClick:function(node){addTab(node); }"
	                                >
                    </ul>  
               
                 </div>   
                 <%}
                   else if(funCon.equals("0")) {%>
                      <h1>没有使用权限</h1>
                      <%} %> --%>
            <!--        <div title="网页显示管理" class="panel" id="infoquery_accordion">   
          
                    <ul id="category_tree" class="easyui-tree" style="text-align:left"
                    data-options=" url:'./getMenuServ?parentid=6',
	                                lines:true,
	                                onClick:function(node){addTab(node);}">
                    </ul>                
                 </div>       -->
         </div>  
    </div>   
    <div data-options="region:'center',border:false" style="width:84%;">
             <div id="tab" class="easyui-tabs" style="width:100%;height:100%;">   
                  <div title="起始页" data-options="border:false">  
                       <img src="./img/bigpic.png" width=100% height=100%>
                  </div>
                                               
            </div> 
    </div>   
    
    <script>
   
   function addTab(node){
			var tt = $('#tab');
			if (tt.tabs('exists', node.text)){//如果tab已经存在,则选中并刷新该tab    	
		        tt.tabs('select', node.text);
		        //refreshTab({tabTitle:title,url:href});
			} else {
				var content="";
		    	if (node.attributes.url){
			    	 content = '<iframe scrolling="no" frameborder="0"  src="' 
			    		+ node.attributes.url + '" style="width:100%;height:100%;z-index:999"></iframe>';
		    	} else {
			    	content = '未实现';
		    	}
		    	tt.tabs('add',{
			    	title:node.text,
			    	closable:true,
			    	content:content
		    	});
			}
		}
		/**    
		 * 刷新tab
		 * @cfg 
		 *example: {tabTitle:'tabTitle',url:'refreshUrl'}
		 *如果tabTitle为空，则默认刷新当前选中的tab
		 *如果url为空，则默认以原来的url进行reload
		 */
		function refreshTab(cfg){
			var refresh_tab = cfg.tabTitle?$('#tabs').tabs('getTab',cfg.tabTitle):$('#tabs').tabs('getSelected');
			if(refresh_tab && refresh_tab.find('iframe').length > 0){
			var _refresh_ifram = refresh_tab.find('iframe')[0];
			var refresh_url = cfg.url?cfg.url:_refresh_ifram.src;
			//_refresh_ifram.src = refresh_url;
			_refresh_ifram.contentWindow.location.href=refresh_url;
			}
		}
		
		
		
   function getToday(){
    var date=new Date();
	var y = date.getFullYear();
	var m = date.getMonth()+1;
	var d = date.getDate();
	return y+"-"+m+"-"+d;
   }
   
   function getWeek(){
     var numWeekDay=new Date().getDay();
    if (numWeekDay == 0) {
        return '周日';
    } else if (numWeekDay == 1) {
        return '周一';
    } else if (numWeekDay == 2) {
        return '周二';
    } else if (numWeekDay == 3) {
        return '周三';
    } else if (numWeekDay == 4) {
        return '周四';
    } else if (numWeekDay == 5) {
        return '周五';
    } else if (numWeekDay == 6) {
        return '周六';
    } else {
        return '';
    }
   }
   
   $("#out span").click(function(){window.location.href="./index.jsp"});
 </script>
</body>  


</html>


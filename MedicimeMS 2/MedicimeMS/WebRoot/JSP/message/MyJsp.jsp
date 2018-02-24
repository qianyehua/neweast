<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text ml; charset=utf-8">
<title></title>
<script type="text/javascript" src="../../JS/easyui/jquery.min.js"></script>
<script type="text/javascript" src="../../JS/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=0Nik0DmKL5G48BgzhlYGGDg9dXfgpGat" ></script>
</head>
<body>
<div style="width:1px;height:1px;" id="container"></div>
<input id="text_" type="text" value="上海"/>
<input type="button" value="search" onclick="searchByStationName();">
</body>
<script>
var map = new BMap.Map("container");
map.centerAndZoom("北京", 6);

var localSearch= new BMap.LocalSearch (map, {
renderOptions: {
pageCapacity: 8,
autoViewport: true,
selectFirstResult: false
}
});

localSearch.enableAutoViewport();
function searchByStationName()
{

var keyword = document.getElementById("text_").value;
localSearch.setSearchCompleteCallback(function(searchResult){
var poi = searchResult.getPoi(0);
alert(poi.point.lng+" "+poi.point.lat);
map.centerAndZoom(poi.point, 8);
});
localSearch.search(keyword);

}
</script>
</html> 
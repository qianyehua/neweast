<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.baidu.ueditor.ActionEnter"
    pageEncoding="UTF-8"%>
<%@  page import="com.skyjoo.neweast.web.action.article.UploadImageOnArticle" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%

    request.setCharacterEncoding( "utf-8" );
	response.setHeader("Content-Type" , "text/html");
	
	String rootPath = application.getRealPath( "/" );
	
	out.write(new UploadImageOnArticle().upload(request, new ActionEnter( request, rootPath ).exec()));
	
%>
package com.MedicimeMS.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MedicimeMS.Dao.SaveFunDao;

public class SaveFunServ extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

response.setContentType("text/html;charset=UTF-8");
		
		String roleid=request.getParameter("roleid");
		String funid=request.getParameter("funid");
		int RoleId=Integer.parseInt(roleid);
		int FunId=Integer.parseInt(funid);
//		int i=new saveTreeService().compare(RoleId, FunId);   //去数据库里判断是否有同样的数据
//		if(i==0){                          //没有就保存
			SaveFunDao s=new SaveFunDao();
			s.baocun(RoleId, FunId);          
//		}
		 
		PrintWriter out = response.getWriter();
		
		out.flush();
		out.close();
	}

}

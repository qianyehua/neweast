package com.MedicimeMS.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MedicimeMS.Dao.deleRoleDao;
import com.MedicimeMS.Dao.deleUserDao;

public class deleRoleServ extends HttpServlet {

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

        response.setContentType("text/html;setchar=UTF-8");
		
		String i=request.getParameter("index");
		int I=Integer.parseInt(i);
		
		int x=new deleRoleDao().shanchu(I);
		deleRoleDao a=new deleRoleDao();
		a.shanchu2(x);
		PrintWriter out = response.getWriter();
		
		out.flush();
		out.close();
	}

}
